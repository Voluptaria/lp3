package com.voluptaria.vlpt.dto;

import com.voluptaria.vlpt.model.Empresa;
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

    private String tipoEmpresa;

    public static EmpresaDTO createDTO(Empresa empresa) {
        ModelMapper modelMapper = new ModelMapper();
        EmpresaDTO dto = modelMapper.map(empresa, EmpresaDTO.class);
        return dto;
    }


}
