package com.exam.cabascango.exam.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@Document(collection = "ejecutivos")
@CompoundIndexes({
    @CompoundIndex(name = "idxu_exam_codigoUsuario",
    def = "{'codigoUusario': 1}", unique = true)
})
public class Turno {

    @Id
    private String id;
    private Integer numero;

    @Indexed
    private String cedula;
    private String nombre;
    private String codigo;
    private String nombreEjecutivo;
    private Date fechaGeneracion;
    private Date fechaInicioAtencion;
    private Date fechaFinAtencion;
    private Integer calificacion;

    @Version
    private Long version;
}
