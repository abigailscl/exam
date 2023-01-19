package com.exam.cabascango.exam.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exam.cabascango.exam.model.Ejecutivo;
import com.exam.cabascango.exam.model.Turno;
import com.exam.cabascango.exam.repository.EjecutivoRepository;
import com.exam.cabascango.exam.repository.TurnoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TurnoService {
    
    private final TurnoRepository turnoRepository;
    private final EjecutivoRepository ejecutivoRepository;

    public TurnoService(TurnoRepository turnoRepository, EjecutivoRepository ejecutivoRepository){
        this.turnoRepository = turnoRepository;
        this.ejecutivoRepository = ejecutivoRepository;
    }

    @Transactional
    public void crearNuevoTurno (String cedula, String nombreCompleto){
        List<Turno> ultimoTurno = (List<Turno>) this.turnoRepository.findAll();
        Turno nuevoTurno = new Turno();
        nuevoTurno.setCedula(cedula);
        nuevoTurno.setNombre(nombreCompleto);
        this.turnoRepository.save(nuevoTurno);
    }
 
    @Transactional
    public Turno iniciarAtencion (Integer numero, String codigoEjecutivo){
        List<Turno> ultimoTurno = this.turnoRepository.findByNumero(numero);
        List<Ejecutivo> ejecutivo = this.ejecutivoRepository.findByCodigoUsuario(codigoEjecutivo);
        ultimoTurno.get(0).setCodigo(codigoEjecutivo);
        ultimoTurno.get(0).setFechaInicioAtencion(new Date());
        return this.turnoRepository.save(ultimoTurno.get(0));
    }
    @Transactional
    public Turno finalizarAtencion (Integer numero){
        List<Turno> ultimoTurno = this.turnoRepository.findByNumero(numero);
        ultimoTurno.get(0).setFechaFinAtencion(new Date());
        return this.turnoRepository.save(ultimoTurno.get(0));
    }

    @Transactional
    public Turno calificarAtencion (Integer numero , String cedula, Integer calificacion){
        List<Turno> ultimoTurno = this.turnoRepository.findByNumeroAndCedula(numero, cedula);
        ultimoTurno.get(0).setCalificacion(calificacion);
        return this.turnoRepository.save(ultimoTurno.get(0));
    }
}
