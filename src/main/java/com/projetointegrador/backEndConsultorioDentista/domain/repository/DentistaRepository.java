package com.projetointegrador.backEndConsultorioDentista.domain.repository;

import com.projetointegrador.backEndConsultorioDentista.domain.entity.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DentistaRepository extends JpaRepository<Dentista, UUID> {
}
