package com.voluptaria.vlpt.dto;

import com.voluptaria.vlpt.model.Funcionario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class FuncionarioDTO {
    private Long id;

    @NotEmpty(message = "Campo cpf não pode ser vazio")
    private String cpf;

    @NotEmpty(message = "Campo nome não pode ser vazio")
    private String nome;

    @NotEmpty(message = "Campo telefone não pode ser vazio")
    private String telefone;

    @NotEmpty(message = "Campo email não pode ser vazio")
    private String email;

    @NotEmpty(message = "Campo logradouro não pode ser vazio")
    private String logradouro;

    @NotEmpty(message = "Campo numero não pode ser vazio")
    private String numero;

    private String complemento;

    @NotEmpty(message = "Campo uf não pode ser vazio")
    private String uf;

    @NotEmpty(message = "Campo cidade não pode ser vazio")
    private String cidade;

    @NotEmpty(message = "Campo cep não pode ser vazio")
    private String cep;

    private String tipoFuncionario;

    public static FuncionarioDTO createDTO(Funcionario funcionario) {
        ModelMapper modelMapper = new ModelMapper();
        FuncionarioDTO dto = modelMapper.map(funcionario, FuncionarioDTO.class);
        return dto;
    }



}
