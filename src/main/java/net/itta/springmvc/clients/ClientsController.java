package net.itta.springmvc.clients;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class ClientsController {

    @Autowired
    ClientsRepository clientsRepository;
    
    List<Client> getListeClient(){
        return clientsRepository.getListeclients();
    }

     @RequestMapping(value = "/clients" ,method = RequestMethod.GET)
    public ModelAndView clients(Model model){
        return new ModelAndView("clients","listeclients",getListeClient());
    }
    
    
     @RequestMapping(value = "/modifyclient" ,method = RequestMethod.GET)
    public ModelAndView modifyclient(@RequestParam(name = "id") int id, Model model){
        Optional<Client> client=clientsRepository.getClientById(id);
        if(client.isPresent())
            return new ModelAndView("modifyclient","command",client.get());
        return new ModelAndView("clients","listeclients",getListeClient());
    }

    
    @RequestMapping(value = "/updateclient" ,method = RequestMethod.POST)
    public RedirectView updateclient(@ModelAttribute("ittaSpringMvc") Client client){
         clientsRepository.updateClient(client);
         return  new RedirectView("clients.html");

    }

   
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
