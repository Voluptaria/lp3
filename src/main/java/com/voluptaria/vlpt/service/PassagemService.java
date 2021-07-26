package com.voluptaria.vlpt.service;

import com.voluptaria.vlpt.exception.RegraNegocioException;
import com.voluptaria.vlpt.model.entity.Passagem;
import com.voluptaria.vlpt.model.Repository.PassagemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PassagemService {

    private final PassagemRepository repository;

    public List<Passagem> getPassagens(){
        return repository.findAll();
    }

    public Optional<Passagem> getPassagemById(Long id){
        return repository.findById(id);
    }

    @Transactional
    public Passagem save(Passagem passagem) {
        validar(passagem);
        return repository.save(passagem);
    }

    @Transactional
    public Passagem update(Passagem passagem) {
        Objects.requireNonNull(passagem.getId());
        return save(passagem);
    }

    private void validar(Passagem passagem) {
        if(LocalDate.parse(passagem.getDataVolta()).isBefore(LocalDate.parse(passagem.getDataIda()))){
            throw new RegraNegocioException("Data de volta deve ser posterior a data de ida");
        }
    }
}
