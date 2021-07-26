package com.voluptaria.vlpt.dto;

import com.voluptaria.vlpt.model.entity.Cliente;
import com.voluptaria.vlpt.model.entity.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    private Long id;

    @NotEmpty(message = "Campo cpf não pode ser vazio")
    @CPF
    private String cpf;

    @NotEmpty(message = "Campo nome não pode ser vazio")
    private String nome;

    @NotEmpty(message = "Campo telefone não pode ser vazio")
    private String telefone;

    @NotEmpty(message = "Campo email não pode ser vazio")
    @Email
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
        Endereco endereco = new Endereco();
        cliente.setEndereco(endereco);
        assert clienteDTO.getEnderecoLogradouro().equals(cliente.getEndereco().getLogradouro());
        assert clienteDTO.getEnderecoNumero().equals(cliente.getEndereco().getNumero());
        assert clienteDTO.getEnderecoComplemento().equals(cliente.getEndereco().getComplemento());
        assert clienteDTO.getEnderecoUf().equals(cliente.getEndereco().getUf());
        assert clienteDTO.getEnderecoCidade().equals(cliente.getEndereco().getCidade());
        assert clienteDTO.getEnderecoCep().equals(cliente.getEndereco().getCep());
        return clienteDTO;
    }

}
