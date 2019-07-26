/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.itta.springmvc.clients;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service()
 //@Scope(value=WebApplicationContext.SCOPE_SESSION,proxyMode =  ScopedProxyMode.TARGET_CLASS ) fait dans le bean de AppConfig
public class ClientsMemoryRepository implements ClientsRepository {
    
    private List<Client> listeclients;
    

    @Override
    public List<Client> getListeclients() {
        if(listeclients==null){
            listeclients= new ArrayList<>();
            for (int i = 1; i < 10; i++) {
                 Client c1 = NewClient();
                 c1.setNom("nom "+i);c1.setPrenom("prénom "+i);c1.setAge(i*5);
                 listeclients.add(c1);
            };
        }
        return listeclients;
    }
    
    @Override
    public boolean removeClientById(int id){
        Client c = new Client();
        c.setId(id);
        return listeclients.remove(c);

    }
    
    @Override
    public Optional<Client> getClientById(int id){
        return listeclients.stream()
                .filter(c->c.getId()==id).findFirst();
    }
    private static int compteurClients;
     
    public static Client NewClient(){
        Client c = new Client();
        c.setId(compteurClients++);
        return c;
    }
    
    @Override
    public void insertClient(Client client) {
        client.setId(compteurClients++);
        listeclients.add(client);
    }

    @Override
    public void updateClient(Client client) {

        Optional<Client> clientdb=getClientById(client.getId());
        if(clientdb.isPresent()){
            clientdb.get().setNom( new String(client.getNom().getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
            clientdb.get().setPrenom(new String(client.getPrenom().getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));;
            clientdb.get().setAge(client.getAge());
        }
    
    }

    
}
