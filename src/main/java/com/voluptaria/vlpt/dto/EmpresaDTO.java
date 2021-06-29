package com.voluptaria.vlpt.dto;

import com.voluptaria.vlpt.model.Empresa;
import com.voluptaria.vlpt.model.Endereco;
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
public class EmpresaDTO {
    private Long id;

    @NotEmpty(message = "Campo cnpj não pode ser vazio")
    private String cnpj;

    @NotEmpty(message = "Campo nome não pode ser vazio")
    private String nome;

    @NotEmpty(message = "Campo telefone não pode ser vazio")
    private String telefone;

    @NotEmpty(message = "Campo email não pode ser vazio")
    private String email;

    private String tipoEmpresa;
    private String enderecoLogradouro;
    private String enderecoNumero;
    private String enderecoComplemento;
    private String enderecoUf;
    private String enderecoCidade;
    private String enderecoCep;

    public static EmpresaDTO createDTO(Empresa empresa) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(empresa, EmpresaDTO.class);
    }

}
