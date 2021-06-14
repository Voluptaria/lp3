package com.voluptaria.vlpt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteDTO {

    private Long id;

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
