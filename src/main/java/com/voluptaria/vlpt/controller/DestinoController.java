package com.voluptaria.vlpt.controller;

import com.voluptaria.vlpt.dto.DestinoDTO;
import com.voluptaria.vlpt.exception.RegraNegocioException;
import com.voluptaria.vlpt.model.Destino;
import com.voluptaria.vlpt.model.Empresa;
import com.voluptaria.vlpt.model.Pacote;
import com.voluptaria.vlpt.service.DestinoService;
import com.voluptaria.vlpt.service.EmpresaService;
import com.voluptaria.vlpt.service.PacoteService;
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
@RequestMapping("/api/v1/destinos")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DestinoController {

    private final DestinoService service;
    private final EmpresaService empresaService;
    private final PacoteService pacoteService;

    @GetMapping()
    public ResponseEntity get() {
        List<Destino> destinos = service.getDestinos();
        return ResponseEntity.ok(destinos.stream().map(DestinoDTO::createDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable Long id){
        Optional<Destino> destino = service.getDestinoById(id);
        if(destino.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Destino não encontrado");
        }
       return ResponseEntity.ok(DestinoDTO.createDTO(destino.get()));
    }

    @PostMapping
    public ResponseEntity post(DestinoDTO destinoDTO){
        try {
            Destino destino = convertToModel(destinoDTO);
            Destino destinoSalvo = service.save(destino);
            return ResponseEntity.status(HttpStatus.CREATED).body(destinoSalvo);
        }catch (RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    private Destino convertToModel(DestinoDTO destinoDTO){
        ModelMapper modelMapper = new ModelMapper();
        Destino destino = modelMapper.map(destinoDTO, Destino.class);
        if(destinoDTO.getIdEmpresa() != null){
            Optional<Empresa> empresa = empresaService.getEmpresaById(destinoDTO.getIdEmpresa());
            if(empresa.isEmpty()){
                destino.setEmpresa(null);
            }else {
                destino.setEmpresa(empresa.get());
            }
        }
        if(destinoDTO.getIdPacote() != null){
            Optional<Pacote> pacote = pacoteService.getPacoteById(destinoDTO.getIdPacote());
            if(pacote.isEmpty()){
                destino.setPacote(null);
            }else {
                destino.setPacote(pacote.get());
            }
        }
        return destino;
    }
}
