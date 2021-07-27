package com.voluptaria.vlpt.controller;

import com.voluptaria.vlpt.dto.PassagemDTO;
import com.voluptaria.vlpt.exception.RegraNegocioException;
import com.voluptaria.vlpt.model.entity.Passagem;
import com.voluptaria.vlpt.model.entity.Empresa;
import com.voluptaria.vlpt.model.entity.Pacote;
import com.voluptaria.vlpt.service.EmpresaService;
import com.voluptaria.vlpt.service.PacoteService;
import com.voluptaria.vlpt.service.PassagemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/passagens")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PassagemController {

    private final PassagemService service;
    private final PacoteService pacoteService;
    private final EmpresaService empresaService;

    @GetMapping()
    public ResponseEntity get(){
        List<Passagem> passagens = service.getPassagens();
        return ResponseEntity.ok(passagens.stream().map(PassagemDTO::createDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable Long id){
        Optional<Passagem> passagem = service.getPassagemById(id);
        if(passagem.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Passagem não encontrada");
        }
        return ResponseEntity.ok(PassagemDTO.createDTO(passagem.get()));
    }
    @PostMapping
    public ResponseEntity post(PassagemDTO passagemDTO){
        try {
            Passagem passagem = convertToModel(passagemDTO);
            Passagem passagemSalvo = service.save(passagem);
            return ResponseEntity.status(HttpStatus.CREATED).body(passagemSalvo);
        }catch (RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable Long id,@RequestBody PassagemDTO passagemDTO){
        if(service.getPassagemById(id).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Passagem não Encontrado");
        }
        try {
            Passagem passagem = convertToModel(passagemDTO);
            passagem.setId(id);
            service.update(passagem);
            return ResponseEntity.ok(passagem);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        Optional<Passagem> passagem = service.getPassagemById(id);
        if (!passagem.isPresent()) {
            return new ResponseEntity("Cliente não encontrado", HttpStatus.NOT_FOUND);
        }
        try {
            service.delete(passagem.get());
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch (RegraNegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    private Passagem convertToModel(PassagemDTO passagemDTO){
        ModelMapper modelMapper = new ModelMapper();
        Passagem passagem = modelMapper.map(passagemDTO, Passagem.class);
        if(passagemDTO.getIdPacote() != null){
            Optional<Pacote> pacote = pacoteService.getPacoteById(passagemDTO.getIdPacote());
            if(pacote.isEmpty()){
                passagem.setPacote(null);
            }else {
                passagem.setPacote(pacote.get());
            }
        }
        if(passagemDTO.getIdEmpresa() != null){
            Optional<Empresa> empresa = empresaService.getEmpresaById(passagemDTO.getIdEmpresa());
            if(empresa.isEmpty()){
                passagem.setEmpresa(null);
            }else {
                passagem.setEmpresa(empresa.get());
            }
        }
        return passagem;
    }

}
