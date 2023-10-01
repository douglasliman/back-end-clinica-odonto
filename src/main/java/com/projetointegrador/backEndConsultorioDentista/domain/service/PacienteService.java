package com.projetointegrador.backEndConsultorioDentista.domain.service;

import com.projetointegrador.backEndConsultorioDentista.domain.entity.Paciente;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service

public interface PacienteService {

    Paciente cadastrarPaciente(Paciente paciente);

    List<Paciente> buscarTodosOsPaciente();


    Paciente buscarPacientePorId(UUID id);


    Paciente atualizarPaciente(UUID id, Paciente pacienteAtualizado);

    void excluir(UUID id);




}
