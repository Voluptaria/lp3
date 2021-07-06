package com.voluptaria.vlpt.service;

import com.voluptaria.vlpt.exception.RegraNegocioException;
import com.voluptaria.vlpt.model.Destino;
import com.voluptaria.vlpt.repository.DestinoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DestinoService {

    private final DestinoRepository repository;


    public List<Destino> getDestinos(){
        return repository.findAll();
    }

    public Optional<Destino> getDestinoById(Long id){
        return repository.findById(id);
    }

    @Transactional
    public Destino save(Destino destino) {
        validar(destino);
        return repository.save(destino);
    }

    private void validar(Destino destino) {

        if(LocalDate.parse(destino.getDataFinal()).isBefore(LocalDate.parse(destino.getDataInicial()))){
            throw new RegraNegocioException("Data final deve ser posterior a data inicial");
        }
    }
}
