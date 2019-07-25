/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.itta.springmvc.clients;

import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @GetMapping(value="/login.html" )
    public String login( @RequestParam(name="error", required = false) String error, Model model, HttpServletRequest request   ){
        try{
            if(error.equalsIgnoreCase("true")){
                String errorMsg="Mauvais login / mot de passe";
                model.addAttribute("errorMsg", errorMsg);
            }
            else{
                model.addAttribute("errorMsg", error);
            }
        }
        catch(NullPointerException ex){
            return "login";
        }
        return "login";
    }
    @GetMapping(value="/logout.html" )
    public String logout(){
        return "logout";
    }
    
    @GetMapping(value="/after_logout.html" )
    public String afterlogout(){
        return "logout";
    }
    
    @GetMapping(value="logerr.html" )
    public String logerr(){
        return "logerr";
    }
    
    @GetMapping(value="/access_denied.html" )
    public String access_denied(){
        return "access_denied";
    }
}
