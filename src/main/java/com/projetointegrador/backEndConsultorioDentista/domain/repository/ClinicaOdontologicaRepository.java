package com.projetointegrador.backEndConsultorioDentista.domain.repository;

import com.projetointegrador.backEndConsultorioDentista.domain.entity.ClinicaOdontologica;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClinicaOdontologicaRepository extends JpaRepository<ClinicaOdontologica, UUID> {

}
