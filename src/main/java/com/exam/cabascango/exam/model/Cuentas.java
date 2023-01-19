package com.exam.cabascango.exam.model;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class Cuentas {

    private String numero;
    private String tipo;
    private BigDecimal saldo;
}

