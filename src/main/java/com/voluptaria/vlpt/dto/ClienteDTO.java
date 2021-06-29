package com.voluptaria.vlpt.dto;

import com.voluptaria.vlpt.model.Cliente;
import com.voluptaria.vlpt.model.Endereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteDTO {
    private Long id;
    private String cpf;
    private String nome;
    private String telefone;
    private String email;
    private Endereco endereco;

    public static ClienteDTO createDTO(Cliente cliente) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(cliente, ClienteDTO.class);
    }


}
