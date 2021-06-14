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
public class Pacote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //private Cliente cliente;
    //private Funcionario funcionario;
    private String cpfFuncionario;
    private String cpfCliente;
}
