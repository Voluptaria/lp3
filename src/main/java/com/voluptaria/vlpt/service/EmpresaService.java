package com.voluptaria.vlpt.service;

import com.voluptaria.vlpt.model.Empresa;
import com.voluptaria.vlpt.repository.EmpresaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmpresaService {

    private final EmpresaRepository repository;

    public List<Empresa> getEmpresas(){
        return repository.findAll();
    }
    public Optional<Empresa> getEmpresaById(Long id){
        return repository.findById(id);
    }
}
