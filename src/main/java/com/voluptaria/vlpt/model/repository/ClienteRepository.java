package com.voluptaria.vlpt.model.repository;

import com.voluptaria.vlpt.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
}
