package net.itta.springmvc;

import net.itta.springmvc.clients.Client;
import java.util.Optional;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloController {
    

    
    @RequestMapping(value = "/welcome" ,method = RequestMethod.GET)
    public String welcome(Model model){
        model.addAttribute("nom","Pierre");
        return "welcome";
    }
    
    @RequestMapping(value = "/enter" ,method = RequestMethod.GET)
    public String enter(Model model){
        return "enter";
    }
    
    @RequestMapping(value = "/hello" ,method = RequestMethod.POST)
    public String helloworld(@RequestParam(name = "nom") String nom, Model model){
        model.addAttribute("nom",nom);
        return "hello";
    }
    
     
    @RequestMapping(value = "/enterclient" ,method = RequestMethod.GET)
    public ModelAndView enterClient(Model model){
        return new ModelAndView("enterclient","command",new Client());
    }
    
    @RequestMapping(value = "/helloclient" ,method = RequestMethod.POST)
    public String helloClient(@ModelAttribute("ittaSpringMvc") Client client, Model model){
        model.addAttribute("nom", client.getNom());
        model.addAttribute("prenom", client.getPrenom());
        model.addAttribute("age", client.getAge());
        return "helloclient";
    }
    
    
}
