package com.voluptaria.vlpt.controller;

import com.voluptaria.vlpt.dto.ClienteDTO;
import com.voluptaria.vlpt.model.Cliente;
import com.voluptaria.vlpt.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteController {

    private final ClienteService service;

    @GetMapping()
    public ResponseEntity<List<ClienteDTO>> get() {
        return ResponseEntity.ok(service.getClientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> get(@PathVariable Long id){
      return ResponseEntity.ok(service.getClienteById(id));

    }
}
