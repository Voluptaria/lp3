package com.voluptaria.vlpt.model.repository;

import com.voluptaria.vlpt.model.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, String> {
}

