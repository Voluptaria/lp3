package com.voluptaria.vlpt.service;

//import com.voluptaria.vlpt.api.dto.EmpresaDTO;
import com.voluptaria.vlpt.model.Empresa;
import com.voluptaria.vlpt.repository.EmpresaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EmpresaService {

    private final EmpresaRepository repository;

    public List<Empresa> getEmpresas(){
        return repository.findAll();
    }

    public Empresa getEmpresaById(Long id){
        return repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Empresa não encontrado"));
    }
}
