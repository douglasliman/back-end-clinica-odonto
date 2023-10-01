package com.projetointegrador.backEndConsultorioDentista.domain.repository;

import com.projetointegrador.backEndConsultorioDentista.domain.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface PacienteRepository  extends JpaRepository<Paciente, UUID> {
    @Query("SELECT p FROM Paciente p WHERE p.nome = ?1")
    Paciente findPacienteByName(String nome);
}
