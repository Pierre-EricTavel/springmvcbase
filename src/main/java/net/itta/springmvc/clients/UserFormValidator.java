/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.itta.springmvc.clients;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
class UserFormValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
       
       return Client.class.equals(clazz);
    }
   
    @Override
    public void validate(Object target, Errors errors) {
        Client client = (Client)target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", "NotEmpty");
        if(client.getNom().length()>15){
            errors.rejectValue("nom", "Valid");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prenom", "NotEmpty");
        if(client.getPrenom().length()>30){
            errors.rejectValue("prenom", "Valid");
        }
    }
    
}
