package com.voluptaria.vlpt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class DestinoDTO {

    private Long id;

    private  String dataInicial;
    private String dataFinal;
    private String cnpjEmpresa;

    private Long idPacote;

    private Long idEmpresa;



}
