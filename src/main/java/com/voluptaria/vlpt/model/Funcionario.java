package com.voluptaria.vlpt.model;

import com.voluptaria.vlpt.enums.TipoFuncionario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Enumerated(EnumType.STRING)
    private TipoFuncionario tipoFuncionario;
}
