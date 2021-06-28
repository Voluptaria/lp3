package com.voluptaria.vlpt.controller;

import com.voluptaria.vlpt.dto.ClienteDTO;
import com.voluptaria.vlpt.dto.PacoteDTO;
import com.voluptaria.vlpt.model.Cliente;
import com.voluptaria.vlpt.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/clientes")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteController {

    private final ClienteService service;

    @GetMapping()
    public ResponseEntity getAll() {
      List<Cliente> clientes = service.getClientes();
      return ResponseEntity.ok(clientes.stream().map(ClienteDTO::createDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        Optional<Cliente> cliente =  service.getClienteById(id);
        if(cliente.isEmpty()){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cliente não encontrado");
        }
        return ResponseEntity.ok(ClienteDTO.createDTO(cliente.get()));
    }

    @GetMapping("/{id}/pacotes")
    public ResponseEntity getPacotes(@PathVariable Long id){
        Optional<Cliente> cliente = service.getClienteById(id);
        if(cliente.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cliente não encontrado");
        }
        return ResponseEntity.ok(cliente.get().getPacotes()
                .stream().map(PacoteDTO::createDTO).collect(Collectors.toList()));
    }


}
