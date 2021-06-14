package com.voluptaria.vlpt.dto;

import com.voluptaria.vlpt.model.Cliente;
import com.voluptaria.vlpt.model.Pacote;
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

public class PacoteDTO {
    private Long id;

    @NotEmpty(message = "Campo ID do Cliente não pode ser vazio")
    private Long idCliente;
    private String nomeCliente;
    @NotEmpty(message = "Campo ID do Funcionario não pode ser vazio")
    private Long idFuncionario;
    private String nomeFuncionario;

    public static PacoteDTO createDTO(Pacote pacote) {
        ModelMapper modelMapper = new ModelMapper();
        PacoteDTO dto = modelMapper.map(pacote, PacoteDTO.class);
        assert dto.getIdCliente().equals(pacote.getCliente().getId());
        assert dto.getNomeCliente().equals(pacote.getCliente().getNome());
        assert dto.getIdFuncionario().equals(pacote.getFuncionario().getId());
        assert dto.getNomeFuncionario().equals(pacote.getFuncionario().getNome());
        return dto;
    }



}
