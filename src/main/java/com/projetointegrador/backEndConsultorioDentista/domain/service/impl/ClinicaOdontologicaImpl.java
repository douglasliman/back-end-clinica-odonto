package com.projetointegrador.backEndConsultorioDentista.domain.service.impl;

import com.projetointegrador.backEndConsultorioDentista.domain.entity.ClinicaOdontologica;

import com.projetointegrador.backEndConsultorioDentista.domain.repository.ClinicaOdontologicaRepository;
import com.projetointegrador.backEndConsultorioDentista.domain.service.ClinicaOdontologicaService;
import com.projetointegrador.backEndConsultorioDentista.exception.ClinicaNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import java.util.UUID;

@Service
public class ClinicaOdontologicaImpl implements ClinicaOdontologicaService {

    private final ClinicaOdontologicaRepository clinicaOdontologicaRepository;

    @Autowired
    public ClinicaOdontologicaImpl(ClinicaOdontologicaRepository clinicaOdontologicaRepository) {
        this.clinicaOdontologicaRepository = clinicaOdontologicaRepository;
    }
    @Override
    public ClinicaOdontologica cadastrarClinica(ClinicaOdontologica clinicaOdontologica) {
        return this.clinicaOdontologicaRepository.save(clinicaOdontologica);
    }

    @Override
    public List<ClinicaOdontologica> buscarTodasAsClinicas() {
        return this.clinicaOdontologicaRepository.findAll();
    }


    @Override
    public ClinicaOdontologica buscarClinicasPorId(UUID id) {
        return this.clinicaOdontologicaRepository.findById(id).orElseThrow(() -> new ClinicaNotFoundException(id));
    }



    @Override
    @Transactional
    public ClinicaOdontologica atualizarClinica(UUID id, ClinicaOdontologica clinicaAtualizada) {
        ClinicaOdontologica clinicaToUpdate = clinicaOdontologicaRepository.findById(id)
                .orElseThrow(() -> new ClinicaNotFoundException(id));

        BeanUtils.copyProperties(clinicaAtualizada, clinicaToUpdate);

        return clinicaOdontologicaRepository.save(clinicaToUpdate);
    }




    @Override
    public void excluirClinica(UUID id) {
        ClinicaOdontologica clinicaOdontologica = clinicaOdontologicaRepository.findById(id).orElseThrow(() -> new ClinicaNotFoundException(id));
        this.clinicaOdontologicaRepository.delete(clinicaOdontologica);

    }
}
