/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.itta.springmvc.clients;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Administrator
 */
public interface ClientsRepository {

    Optional<Client> getClientById(int id);

    List<Client> getListeclients();

    void insertClient(Client client);

    boolean removeClientById(int id);

    void updateClient(Client client);
    
}
