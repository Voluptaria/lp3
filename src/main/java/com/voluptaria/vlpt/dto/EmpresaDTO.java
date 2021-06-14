package com.voluptaria.vlpt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class EmpresaDTO {

    private Long id;

    private String cnpj;

    private String nome;
    private String email;
    private String telefone;
    private String logradouro;
    private String numero;
    private String complemento;
    private String uf;
    private String localidade;
    private String cep;

    private String tipoEmpresa;




}
