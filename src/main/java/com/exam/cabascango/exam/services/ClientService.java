package com.exam.cabascango.exam.services;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exam.cabascango.exam.model.Client;
import com.exam.cabascango.exam.repository.ClientRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public List<Client> findClientByIdentification(String cedula){
        List<Client> client = this.clientRepository.findByCedula(cedula);
        if (client == null){
            throw new RuntimeException("The client does not exist");
        }
        return client;
    }
}