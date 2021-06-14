package com.voluptaria.vlpt.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Destino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private  String dataInicial;
    private String dataFinal;
    private String cnpjEmpresa;
    private int idPacote;

//    private  Pacote pacote;
//    private  Empresa empresa;
}
