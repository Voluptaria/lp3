package com.voluptaria.vlpt.controller;

import com.voluptaria.vlpt.dto.ClienteDTO;
import com.voluptaria.vlpt.dto.PacoteDTO;
import com.voluptaria.vlpt.exception.RegraNegocioException;
import com.voluptaria.vlpt.model.entity.Cliente;
import com.voluptaria.vlpt.model.entity.Endereco;
import com.voluptaria.vlpt.service.ClienteService;
import com.voluptaria.vlpt.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.image.renderable.RenderableImageOp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/clientes")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteController {

    private final ClienteService service;
    private final EnderecoService enderecoService;

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

    @PostMapping
    public ResponseEntity post(ClienteDTO clienteDTO){
        try {
            Cliente cliente = convertToModel(clienteDTO);
            Endereco endereco = enderecoService.save(cliente.getEndereco());
            cliente.setEndereco(endereco);
            Cliente clienteSalvo = service.save(cliente);
            return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
        }catch (RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable Long id,@RequestBody ClienteDTO clienteDTO){
        if(service.getClienteById(id).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não Encontrado");
        }
        try {
            Cliente cliente = convertToModel(clienteDTO);
            cliente.setId(id);
            service.update(cliente);
            return ResponseEntity.ok(cliente);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    private Cliente convertToModel(ClienteDTO clienteDTO){
        ModelMapper modelMapper = new ModelMapper();
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        Endereco endereco = modelMapper.map(clienteDTO, Endereco.class);
        cliente.setEndereco(endereco);
        return modelMapper.map(clienteDTO, Cliente.class);
    }

}
