package com.projetointegrador.backEndConsultorioDentista.domain.service.impl;

import com.projetointegrador.backEndConsultorioDentista.domain.entity.Consulta;

import com.projetointegrador.backEndConsultorioDentista.domain.repository.ConsultaRepository;
import com.projetointegrador.backEndConsultorioDentista.domain.service.ConsultaService;
import com.projetointegrador.backEndConsultorioDentista.exception.ConsultaNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ConsultaServiceImpl implements ConsultaService {
    private ConsultaRepository consultaRepository;

    @Autowired
    public ConsultaServiceImpl(ConsultaRepository consultaRepository){
        this.consultaRepository = consultaRepository;
    }

    @Override
    public Consulta criarConsulta(Consulta consulta) {
        return this.consultaRepository.save(consulta);
    }

    @Override
    public List<Consulta> buscarTodasAsConsultas() {
        return this.consultaRepository.findAll();
    }

    @Override
    public Consulta buscarConsultaPorId(UUID id) {
        return this.consultaRepository.findById(id).orElseThrow(() -> new ConsultaNotFoundException(id));
    }

    @Override
    public Consulta atualizarConsulta(UUID id, Consulta consultaAtualizada) {
        Consulta consultaToUpdate = consultaRepository.findById(id)
                .orElseThrow(() -> new ConsultaNotFoundException(id));

        BeanUtils.copyProperties(consultaAtualizada, consultaToUpdate);

        return consultaRepository.save(consultaToUpdate);
    }

    @Override
    public void cancelarConsultar(UUID id) {
        Consulta consulta = consultaRepository.findById(id).orElseThrow(() -> new ConsultaNotFoundException(id));
        this.consultaRepository.delete(consulta);
    }
}
