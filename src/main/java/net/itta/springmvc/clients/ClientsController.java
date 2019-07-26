package net.itta.springmvc.clients;


import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.view.RedirectView;



@Controller

public class ClientsController {

    @Resource(name = "myClientsRepository") //ou @Autowired si clientsMemoryRepository @Scoped("session")
    ClientsRepository clientsRepository;
    
    @Autowired
    Validator userFormValidator;

    Logger log = LoggerFactory.getLogger(this.getClass());
    
    @InitBinder
    protected void InitBinder(final WebDataBinder wdb){
        wdb.addValidators(userFormValidator);
    }
    
    List<Client> getListeClient(){
        return clientsRepository.getListeclients();
    }

     @RequestMapping(value = "/clients" ,method = RequestMethod.GET )
    public ModelAndView clients(HttpServletRequest request){
        
        return new ModelAndView("clients","listeclients",getListeClient());
    }
    
    
     @RequestMapping(value = "/modifyclient" ,method = RequestMethod.GET)
    public ModelAndView modifyclient(@RequestParam(name = "id") int id){
        Optional<Client> client=clientsRepository.getClientById(id);
       
        if(client.isPresent()) {
            return new ModelAndView("modifyclient","client",client.get());
        }
        return new ModelAndView("clients","listeclients",getListeClient());
    }

    
    @RequestMapping(value = "/updateclient" ,method = RequestMethod.POST)
    public String updateclient(@ModelAttribute("client") @Validated Client client, BindingResult result, Model model){
         if(result.hasErrors() ){
            client.setNom( new String(client.getNom().getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
            client.setPrenom(new String(client.getPrenom().getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));;
            return  "modifyclient";
         }
         clientsRepository.updateClient(client);
         return  "redirect:clients.html";

    }

   @PreAuthorize("hasRole('ADMINISTRATORS')")
      @RequestMapping(value = "/supprimeclient" ,method = RequestMethod.GET)
    public ModelAndView supprimeclient(@RequestParam(name = "id") int id){
        Optional<Client> clientdb=clientsRepository.getClientById(id);
        if(clientdb.isPresent()){
            return new ModelAndView("supprimeclient","command",clientdb.get());
        }
        return new ModelAndView("clients","listeclients",getListeClient());
    }
    
      @RequestMapping(value = "/deleteclient" ,method = RequestMethod.POST)
    public RedirectView deleteclient(@RequestParam(name = "id") int id, Model model){
        clientsRepository.removeClientById(id);
        return  new RedirectView("clients.html");
    }
      @RequestMapping(value = "/createclient" ,method = RequestMethod.GET)
    public ModelAndView createclient(){
        Client client= new Client();
        return new ModelAndView("createclient","command",client);
    }
    
      @RequestMapping(value = "/insertclient" ,method = RequestMethod.POST)
    public RedirectView insertclient(@ModelAttribute("ittaSpringMvc") Client client){
        clientsRepository.insertClient(client);
        return  new RedirectView("clients.html");
    }
}
