package com.voluptaria.vlpt.controller;

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
    public ResponseEntity<List<Cliente>> get() {
        List<Cliente> clientes = service.getClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> get(@PathVariable Long id){
      return ResponseEntity.ok(service.getClienteById(id));

    }
}
