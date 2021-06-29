package com.voluptaria.vlpt.dto;

import com.voluptaria.vlpt.model.Passagem;
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
public class PassagemDTO {
    private Long id;

    @NotEmpty(message = "Campo Origem não pode ser vazio")
    private String origem;

    @NotEmpty(message = "Campo Destino não pode ser vazio")
    private String destino;

    @NotEmpty(message = "Campo Data de Ida não pode ser vazio")
    private String dataIda;

    private String dataVolta;

    @NotEmpty(message = "Campo ID do Pacote não pode ser vazio")
    private Long idPacote;

    @NotEmpty(message = "Campo ID da Empresa não pode ser vazio")
    private Long idEmpresa;

    public static PassagemDTO createDTO(Passagem passagem) {
        ModelMapper modelMapper = new ModelMapper();
        PassagemDTO dto = modelMapper.map(passagem, PassagemDTO.class);
        assert dto.idEmpresa.equals(passagem.getEmpresa().getId());
        assert dto.idPacote.equals(passagem.getPacote().getId());
        return dto;
    }

}
