/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.itta.springmvc.conf;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;


public class MyLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler implements LogoutSuccessHandler{

    private final String logouturl;

    MyLogoutSuccessHandler(String logouthtml) {
      this.logouturl=  logouthtml;
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        
        System.out.println("-------- onLogoutSuccess --------------");
        request.getSession().removeAttribute("username"); 
        response.setStatus(200);
        response.sendRedirect(request.getContextPath()+logouturl);
        //super.onLogoutSuccess(request, response, authentication);
    }
}
    

