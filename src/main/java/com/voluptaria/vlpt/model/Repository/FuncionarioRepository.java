package com.voluptaria.vlpt.model.Repository;

import com.voluptaria.vlpt.model.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
