package com.voluptaria.vlpt.model;

import com.voluptaria.vlpt.enums.TipoEmpresa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @CNPJ
    private String cnpj;

    @Column(nullable = false)
    private String nome;

    @Email
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String telefone;

    @Enumerated(EnumType.STRING)
    private TipoEmpresa tipoEmpresa;

    @OneToOne
    private Endereco endereco;

    @OneToMany(mappedBy = "empresa")
    private List<Destino> destinos;

    @OneToMany(mappedBy = "empresa")
    private List<Passagem> passagens;


}
