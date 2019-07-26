/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.itta.springmvc.conf;

import net.itta.springmvc.clients.ClientsMemoryRepository;
import net.itta.springmvc.clients.ClientsRepository;
import org.springframework.context.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.*;


@Configuration
@EnableWebMvc
@Import(value={AppSecurityConfig.class, AppSessionConfig.class})
@ComponentScan(basePackages = {"net.itta.springmvc"})
public class AppConfig {

    @Bean
    @Scope(value=WebApplicationContext.SCOPE_SESSION,proxyMode =  ScopedProxyMode.INTERFACES )
    ClientsRepository myClientsRepository(){
        return new ClientsMemoryRepository();
    }
}
