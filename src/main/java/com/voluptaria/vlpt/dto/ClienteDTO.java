package com.voluptaria.vlpt.dto;

import com.voluptaria.vlpt.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteDTO {

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

    public static ClienteDTO createDTO(Cliente cliente) {
        ModelMapper modelMapper = new ModelMapper();
        ClienteDTO dto = modelMapper.map(cliente, ClienteDTO.class);
        return dto;
    }


}
