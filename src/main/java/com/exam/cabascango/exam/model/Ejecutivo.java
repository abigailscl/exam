package com.exam.cabascango.exam.model;

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
@Document(collection = "ejecutivos")
@CompoundIndexes({
    @CompoundIndex(name = "idxu_exam_codigoUsuario",
    def = "{'codigoUusario': 1}", unique = true)
})
public class Ejecutivo {
    @Id
    private String id;
    private String codigoUsuario;

    @Indexed
    private String nombre;
    private String numeroEscritorio;

    @Version
    private Long version;
}
