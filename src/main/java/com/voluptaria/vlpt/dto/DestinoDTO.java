package com.voluptaria.vlpt.dto;

import com.voluptaria.vlpt.model.Destino;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DestinoDTO {
    private Long id;

    @NotEmpty(message = "Campo data inicial não pode ser vazio")
    private  String dataInicial;

    private String dataFinal;

    @NotEmpty(message = "Campo ID do Pacote não pode ser vazio")
    private Long idPacote;

    @NotEmpty(message = "Campo ID da Empresa não pode ser vazio")
    private Long idEmpresa;

    private String nomeEmpresa;

    public static DestinoDTO createDTO(Destino destino) {
        ModelMapper modelMapper = new ModelMapper();
        DestinoDTO dto = modelMapper.map(destino, DestinoDTO.class);
        assert dto.getIdPacote().equals(destino.getPacote().getId());
        assert dto.getIdEmpresa().equals(destino.getEmpresa().getId());
        assert dto.getNomeEmpresa().equals(destino.getEmpresa().getNome());
        return dto;
    }

}
