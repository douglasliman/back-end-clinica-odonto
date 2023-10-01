package com.projetointegrador.backEndConsultorioDentista.domain.service;

import com.projetointegrador.backEndConsultorioDentista.domain.entity.Consulta;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ConsultaService {
    Consulta criarConsulta(Consulta consulta);
    List<Consulta> buscarTodasAsConsultas();
    Consulta buscarConsultaPorId(UUID id);
    Consulta atualizarConsulta(UUID id, Consulta consultaAtualizada);
    void cancelarConsultar(UUID id);

}
