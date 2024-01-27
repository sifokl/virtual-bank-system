package com.banking.system.vsbank.api.repository.impl;


import com.banking.system.vsbank.api.entity.Client;
import com.banking.system.vsbank.api.repository.ClientRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Repository
public class ClientRepositoryImpl implements ClientRepository {



    private List<Client> clients;

    @PostConstruct
    private void populateRepository(){
        clients = new ArrayList<>();

        clients.add(Client.builder().id(1).name("Saif Ksibi").build());
        clients.add(Client.builder().id(2).name("John Poor ").build());
    }
    @Override
    public Client findById(int id) {
        Client clientById =  clients.stream().flatMap(s -> Stream.ofNullable(s)).filter(client->client.getId()==id).findAny()
                .orElse(null);
        return clientById;
    }

    @Override
    public List<Client> findAll() {
        return null;
    }

    @Override
    public boolean save(Client client) {

        clients.add(client);

        return true;
    }

    @Override
    public List<Client> saveAll(List<Client> list) {
        return null;
    }

    @Override
    public boolean update(Client clientToUpdate) {
        long id = clientToUpdate.getId();
        Client clientById =  clients.stream().flatMap(s -> Stream.ofNullable(s)).filter(client->client.getId()==id).findAny()
                .orElse(null);
        if(null != clientById){
            clientById.setName(clientToUpdate.getName());
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAll() {
        clients.clear();
        return true;
    }
}
