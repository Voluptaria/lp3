package com.voluptaria.vlpt.controller;

import com.voluptaria.vlpt.dto.DestinoDTO;
import com.voluptaria.vlpt.service.DestinoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/destinos")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DestinoController {

    private final DestinoService service;

    @GetMapping()
    public ResponseEntity<List<DestinoDTO>> get() {
        return ResponseEntity.ok(service.getDestinos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DestinoDTO> get(@PathVariable Long id){
       return ResponseEntity.ok(service.getDestinoById(id));

    }
}
