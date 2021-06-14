package com.voluptaria.vlpt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PacoteDTO {

    private Long id;

    private Long idCliente;
    private String nomeCliente;

    private Long idFuncionario;
    private String nomeFuncionario;



}
