package com.voluptaria.vlpt.model.Repository;

import com.voluptaria.vlpt.model.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}

