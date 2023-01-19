package com.exam.cabascango.exam.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exam.cabascango.exam.model.Turno;


@Repository
public interface TurnoRepository extends CrudRepository<Turno, String>{
    List<Turno> findByNumero(Integer numero);
    List<Turno>findByNumeroAndCedula(Integer numero, String Cedula);
}
