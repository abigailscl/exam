package com.exam.cabascango.exam.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exam.cabascango.exam.model.Client;


@Repository
public interface ClientRepository extends CrudRepository<Client, String>{ 
    List<Client> findByCedula(String cedula);
}
