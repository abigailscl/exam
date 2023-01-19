package com.exam.cabascango.exam.controller.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientRS implements Serializable{

    private String cedula;
    private String nombres;
}