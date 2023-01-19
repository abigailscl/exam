package com.exam.cabascango.exam.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.cabascango.exam.controller.dto.TurnoRQ;
import com.exam.cabascango.exam.controller.mapper.TurnoMapper;
import com.exam.cabascango.exam.services.TurnoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/turno")
public class TurnoController {
    private final TurnoService turnoService;

    public TurnoController(TurnoService turnoService){
        this.turnoService = turnoService;
    }

    @PostMapping(value = "/")
    public ResponseEntity<String> crearTurno(@RequestBody TurnoRQ turnoRQ){
        try {
            this.turnoService.crearNuevoTurno(TurnoMapper.toTurno(turnoRQ).getCedula(), TurnoMapper.toTurno(turnoRQ).getNombre());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping(value = "/{idCliente}")
    public ResponseEntity<String> (@PathVariable("idCliente") String id, @RequestBody TurnoRQ turnoRQ){
        try {
            return this.turnoService.iniciarAtencion(id, TurnoMapper.toTurno(turnoRQ));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
