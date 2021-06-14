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

    public static ClienteDTO createDTO(Cliente cliente) {
        ModelMapper modelMapper = new ModelMapper();
        ClienteDTO dto = modelMapper.map(cliente, ClienteDTO.class);
        return dto;
    }


}
