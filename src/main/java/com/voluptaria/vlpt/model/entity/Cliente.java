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

public class Cliente {

    @Id
    private String cpf;

    private String name;
    private String telefone;
    private String email;
    private String logradouro;
    private String numero;
    private String complemento;
    private String uf;
    private String cidade;
    private String cep;
}
