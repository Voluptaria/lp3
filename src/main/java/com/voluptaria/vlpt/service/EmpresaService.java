package com.voluptaria.vlpt.service;

import com.voluptaria.vlpt.dto.EmpresaDTO;
import com.voluptaria.vlpt.model.Empresa;
import com.voluptaria.vlpt.repository.EmpresaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EmpresaService {

    private final EmpresaRepository repository;

    public List<EmpresaDTO> getEmpresas(){

        return repository.findAll()
                .stream().map(EmpresaDTO::createDTO).collect(Collectors.toList());
    }

    public EmpresaDTO getEmpresaById(Long id){
        Empresa empresa = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Empresa não encontrado"));
       return EmpresaDTO.createDTO(empresa);
    }
}
