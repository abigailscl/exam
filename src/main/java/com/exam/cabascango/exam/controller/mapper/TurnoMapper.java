package com.exam.cabascango.exam.controller.mapper;

import com.exam.cabascango.exam.controller.dto.TurnoRQ;
import com.exam.cabascango.exam.model.Turno;

public class TurnoMapper {
    public static Turno toTurno(TurnoRQ turno){
        return Turno.builder()
        .nombre(turno.getNombres())
        .cedula(turno.getCedula())
        .build();
    }    
}
