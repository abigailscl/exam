package com.exam.cabascango.exam.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exam.cabascango.exam.model.Ejecutivo;


@Repository
public interface EjecutivoRepository extends CrudRepository<Ejecutivo, String>{
    List<Ejecutivo> findByCodigoUsuario(String codigoUsuario);
}
