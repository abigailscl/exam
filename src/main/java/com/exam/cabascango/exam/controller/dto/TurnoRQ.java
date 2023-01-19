package com.exam.cabascango.exam.controller.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TurnoRQ implements Serializable{

    private String nombres;
    private String cedula;
}
