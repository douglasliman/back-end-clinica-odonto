package com.projetointegrador.backEndConsultorioDentista.domain.service;

import com.projetointegrador.backEndConsultorioDentista.domain.entity.Dentista;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service

public interface DentistaService {
    Dentista cadastrarDentista(Dentista dentista);

    List<Dentista> buscarTodosOsDentista();

    Dentista buscarDentistaPorId(UUID id);
    Dentista atualizarDentista(UUID id, Dentista dentistaAtualizado);
    Dentista excluir (UUID id);



}
