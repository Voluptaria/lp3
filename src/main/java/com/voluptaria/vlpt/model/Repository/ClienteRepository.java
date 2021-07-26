package com.voluptaria.vlpt.model.Repository;

import com.voluptaria.vlpt.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
