package com.voluptaria.vlpt.dto;

import com.voluptaria.vlpt.model.Empresa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class EmpresaDTO {

    private Long id;

    private String cnpj;

    private String nome;
    private String email;
    private String telefone;
    private String logradouro;
    private String numero;
    private String complemento;
    private String uf;
    private String localidade;
    private String cep;

    private String tipoEmpresa;

    public static EmpresaDTO createDTO(Empresa empresa) {
        ModelMapper modelMapper = new ModelMapper();
        EmpresaDTO dto = modelMapper.map(empresa, EmpresaDTO.class);
        return dto;
    }


}
