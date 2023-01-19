package com.exam.cabascango.exam.model;


import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "clientes")
@CompoundIndexes({
    @CompoundIndex(name = "idxu_exam_cedula",
    def = "{'cedula': 1}", unique = true)
})
public class Client {

    @Id
    private String id;
    private String cedula;

    @Indexed
    private String nombres;
    private String apellidos;
    private Date fechaNacimiento;
    private String direccion;
    private String telefono;
    private String email;

    private List<Cuentas>cuentas;

    @Version
    private Long version;
}