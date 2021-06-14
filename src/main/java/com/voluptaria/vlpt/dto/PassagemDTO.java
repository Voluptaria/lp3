package com.voluptaria.vlpt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PassagemDTO {

    private Long id;

    private String origem;
    private String destino;
    private String dataIda;
    private String dataVolta;

    private Long idPacote;

    private Long idEmpresa;



}
