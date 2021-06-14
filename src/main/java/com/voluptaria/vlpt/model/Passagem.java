package com.voluptaria.vlpt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Passagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String origem;
    private String destino;
    private String dataIda;
    private String dataVolta;
    @ManyToOne
    private Pacote pacote;
    @ManyToOne
    private Empresa empresa;
}
