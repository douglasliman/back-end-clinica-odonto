package com.projetointegrador.backEndConsultorioDentista.domain.service;

import com.projetointegrador.backEndConsultorioDentista.domain.entity.ClinicaOdontologica;



import java.util.List;

import java.util.UUID;

public interface ClinicaOdontologicaService {
    ClinicaOdontologica cadastrarClinica(ClinicaOdontologica clinicaOdontologica);
    List<ClinicaOdontologica> buscarTodasAsClinicas();
   ClinicaOdontologica buscarClinicasPorId(UUID id);
   ClinicaOdontologica atualizarClinica(UUID id, ClinicaOdontologica clinicaAtualizada);
    void excluirClinica(UUID id);
 }
