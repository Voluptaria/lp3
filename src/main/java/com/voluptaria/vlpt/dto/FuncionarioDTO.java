package com.voluptaria.vlpt.dto;

import com.voluptaria.vlpt.model.Funcionario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class FuncionarioDTO {


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
    private String senha;

    private String tipoFuncionario;

    public static FuncionarioDTO createDTO(Funcionario funcionario) {
        ModelMapper modelMapper = new ModelMapper();
        FuncionarioDTO dto = modelMapper.map(funcionario, FuncionarioDTO.class);
        return dto;
    }



}
