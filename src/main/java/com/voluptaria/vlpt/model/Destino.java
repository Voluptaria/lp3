package com.voluptaria.vlpt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Destino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private  String dataInicial;

    private String dataFinal;

    @ManyToOne
    private  Pacote pacote;
    @ManyToOne
    private  Empresa empresa;
}
