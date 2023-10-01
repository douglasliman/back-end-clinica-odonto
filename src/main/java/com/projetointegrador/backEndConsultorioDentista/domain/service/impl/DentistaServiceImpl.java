package com.projetointegrador.backEndConsultorioDentista.domain.service.impl;

import com.projetointegrador.backEndConsultorioDentista.domain.entity.Dentista;

import com.projetointegrador.backEndConsultorioDentista.domain.repository.DentistaRepository;
import com.projetointegrador.backEndConsultorioDentista.domain.service.DentistaService;
import com.projetointegrador.backEndConsultorioDentista.exception.DentistaNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DentistaServiceImpl implements DentistaService {

        private final DentistaRepository dentistaRepository;

        @Autowired
    public DentistaServiceImpl(DentistaRepository dentistaRepository) {
        this.dentistaRepository = dentistaRepository;
    }


    @Override
    public Dentista cadastrarDentista(Dentista dentista) {
        return this.dentistaRepository.save(dentista);
    }

    @Override
    public List<Dentista> buscarTodosOsDentista() {
        return this.dentistaRepository.findAll();
    }

    @Override
    public Dentista buscarDentistaPorId(UUID id) {
        return this.dentistaRepository.findById(id).orElseThrow(() -> new DentistaNotFoundException(id) );
    }

    @Override
    public Dentista atualizarDentista(UUID id, Dentista dentistaAtualizado) {
        Dentista dentistaToUpdate = dentistaRepository.findById(id)
                .orElseThrow(() -> new DentistaNotFoundException(id));

        BeanUtils.copyProperties(dentistaAtualizado, dentistaToUpdate);

        return dentistaRepository.save(dentistaToUpdate);
    }


    @Override
    public Dentista excluir(UUID id) {
        Dentista dentista = dentistaRepository.findById(id).orElseThrow(() -> new DentistaNotFoundException(id));
        dentistaRepository.delete(dentista);
        return dentista;
    }
}
