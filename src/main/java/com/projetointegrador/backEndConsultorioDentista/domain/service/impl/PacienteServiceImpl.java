package com.projetointegrador.backEndConsultorioDentista.domain.service.impl;

import com.projetointegrador.backEndConsultorioDentista.domain.repository.PacienteRepository;

import com.projetointegrador.backEndConsultorioDentista.exception.PacienteNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetointegrador.backEndConsultorioDentista.domain.entity.Paciente;
import com.projetointegrador.backEndConsultorioDentista.domain.service.PacienteService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@Service
public class PacienteServiceImpl implements PacienteService {
    private PacienteRepository pacienteRepository;

    @Autowired
        public PacienteServiceImpl(PacienteRepository pacienteRepository) {
            this.pacienteRepository = pacienteRepository;
        }


    @Override
    public Paciente cadastrarPaciente(Paciente paciente) {
        return this.pacienteRepository.save(paciente);
    }

    @Override
    public List<Paciente> buscarTodosOsPaciente() {
        return this.pacienteRepository.findAll();
    }

    @Override
    public Paciente buscarPacientePorId(UUID id) {
        return this.pacienteRepository.findById(id).orElseThrow(() -> new PacienteNotFoundException(id));
    }

    @Override
    public Paciente atualizarPaciente(UUID id, Paciente pacienteAtualizado) {

     Paciente pacienteToUpdate = pacienteRepository.findById(id)
                .orElseThrow(() ->  new PacienteNotFoundException(id));
        BeanUtils.copyProperties(id, pacienteToUpdate);

        return pacienteRepository.save(pacienteToUpdate);
    }

    @Override
    public void excluir(UUID id) {
        Paciente paciente = pacienteRepository.findById(id).orElseThrow(() -> new PacienteNotFoundException(id));
        pacienteRepository.delete(paciente);
    }

    @Transactional(readOnly = true)
    public String buscarPorNome(@PathVariable String nome) {
        return pacienteRepository.findPacienteByName(nome).getNome();
    }

}
