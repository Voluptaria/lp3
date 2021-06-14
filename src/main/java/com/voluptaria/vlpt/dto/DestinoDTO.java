package com.voluptaria.vlpt.dto;

import com.voluptaria.vlpt.model.Destino;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

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

    public static DestinoDTO createDTO(Destino destino) {
        ModelMapper modelMapper = new ModelMapper();
        DestinoDTO dto = modelMapper.map(destino, DestinoDTO.class);
        assert dto.getIdPacote().equals(destino.getPacote().getId());
        assert dto.getIdEmpresa().equals(destino.getEmpresa().getId());
        return dto;
    }

}
