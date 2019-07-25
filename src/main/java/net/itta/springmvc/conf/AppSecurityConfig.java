/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.itta.springmvc.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("inMemoryAuthentication");
       
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}Pa$$w0rd")
                .roles("ADMINISTRATORS")
                .and()
                .withUser("user")
                .password("{noop}Pa$$w0rd")
                .roles("USERS");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                
                .antMatchers("/createclient*").hasRole("ADMINISTRATORS")
                .antMatchers("/modifyclient*").hasAnyRole("USERS","ADMINISTRATORS")
                .and()
                .formLogin()
                .loginPage("/login.html")
                .defaultSuccessUrl("/clients.html")
                .successHandler(new LoginSuccessHandler())
                .failureUrl("/login.html?error=true")
                
                .and()
                .logout()
                .logoutUrl("/logout.html") 
                .logoutSuccessHandler(new MyLogoutSuccessHandler("/after_logout.html"))
                //.logoutSuccessUrl("/after_logout.html")
                //.deleteCookies("JSESSIONID")
                .invalidateHttpSession(false) 
                .and()
                .exceptionHandling()
                .accessDeniedPage("/access_denied.html")
                ;
        http.sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
            .maximumSessions(2)
            .expiredUrl("/end_session.html")
            .and()
            .enableSessionUrlRewriting(true)
            .invalidSessionUrl("/invalid_session.html")
            ;
                
        
        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**").antMatchers("/css/**").antMatchers("/scripts/**").antMatchers("/images/**");
    }
    
    
    
    
}
