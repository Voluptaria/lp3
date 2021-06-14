package com.voluptaria.vlpt.model;

import com.voluptaria.vlpt.enums.TipoEmpresa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Enumerated(EnumType.STRING)
    private TipoEmpresa tipoEmpresa;
}
