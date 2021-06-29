package com.voluptaria.vlpt.dto;

import com.voluptaria.vlpt.model.Cliente;
import com.voluptaria.vlpt.model.Endereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.persistence.Column;
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
    private String enderecoLogradouro;
    private String enderecoNumero;
    private String enderecoComplemento;
    private String enderecoUf;
    private String enderecoCidade;
    private String enderecoCep;

    public static ClienteDTO createDTO(Cliente cliente) {
        ModelMapper modelMapper = new ModelMapper();
        ClienteDTO clienteDTO = modelMapper.map(cliente, ClienteDTO.class);
        assert clienteDTO.getEnderecoLogradouro().equals(cliente.getEndereco().getLogradouro());
        assert clienteDTO.getEnderecoNumero().equals(cliente.getEndereco().getNumero());
        assert clienteDTO.getEnderecoComplemento().equals(cliente.getEndereco().getComplemento());
        assert clienteDTO.getEnderecoUf().equals(cliente.getEndereco().getUf());
        assert clienteDTO.getEnderecoCidade().equals(cliente.getEndereco().getCidade());
        assert clienteDTO.getEnderecoCep().equals(cliente.getEndereco().getCep());
        return clienteDTO;
    }

}
