package com.voluptaria.vlpt.model.entity;

import com.voluptaria.vlpt.enums.TipoFuncionario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CPF
    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String telefone;

    @Email
    @Column(nullable = false)
    private String email;

    @OneToOne
    private Endereco endereco;

    @Enumerated(EnumType.STRING)
    private TipoFuncionario tipoFuncionario;

    @OneToMany(mappedBy = "funcionario")
    private List<Pacote> pacotes;
}
