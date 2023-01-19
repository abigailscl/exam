package com.exam.cabascango.exam.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.cabascango.exam.controller.dto.ClientRS;
import com.exam.cabascango.exam.controller.mapper.ClientMapper;
import com.exam.cabascango.exam.model.Client;
import com.exam.cabascango.exam.services.ClientService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @GetMapping(value = "/{idCliente}")
    public ResponseEntity<ClientRS> getClientById(@PathVariable("") String cedula){
        List<Client> client = this.clientService.findClientByIdentification(cedula);
        if (client != null){
            return ResponseEntity.ok(ClientMapper.toClientRS(client.get(0)));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
