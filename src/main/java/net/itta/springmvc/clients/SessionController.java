/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.itta.springmvc.clients;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class SessionController {
   
    
    @GetMapping(value="/end_session.html" )
    public String end_session(){
        return "end_session";
    }
    
    @GetMapping(value="/invalid_session.html" )
    public String invalid_session(){
        return "invalid_session";
    }
}
