package com.voluptaria.vlpt.service;

//import com.voluptaria.vlpt.api.dto.EmpresaDTO;
import com.voluptaria.vlpt.model.entity.Empresa;
import com.voluptaria.vlpt.model.repository.EmpresaRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    private EmpresaRepository repository;

    public EmpresaService(EmpresaRepository repository){
        this.repository = repository;
    }

    public List<Empresa> getEmpresas(){
        return repository.findAll();
    }

    public Optional<Empresa> getEmpresaById(String cnpj){
        return repository.findById(cnpj);
    }
}
