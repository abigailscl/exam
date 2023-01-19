package com.exam.cabascango.exam.controller.mapper;

import com.exam.cabascango.exam.controller.dto.ClientRS;
import com.exam.cabascango.exam.model.Client;

public class ClientMapper {

    public static ClientRS toClientRS(Client client){
        return ClientRS.builder()
        .cedula(client.getCedula())
        .nombres(client.getNombres() + client.getApellidos())
        .build();
    }    
}
