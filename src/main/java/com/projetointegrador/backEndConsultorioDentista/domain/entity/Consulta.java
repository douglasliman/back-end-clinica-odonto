package com.projetointegrador.backEndConsultorioDentista.domain.entity;

import jakarta.persistence.*;
import jdk.jfr.BooleanFlag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Consulta")
public class Consulta  {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "data_consulta", nullable = false)
    private LocalDateTime dataConsulta;


    @Column(length = 255, nullable = false)
    private String descricao;


    @Column(length = 255, nullable = false)
    private String motivoCancelamento;

    @BooleanFlag
    private Boolean cancelada;
    
    @OneToOne
    private Paciente paciente;

    @ManyToOne
    private Dentista dentista;

    @ManyToOne
    private ClinicaOdontologica clinicaOdontologicaId;

    @Transient
    @Column(columnDefinition = "DATETIME")
    private Instant createdAt;

    @Transient
    @Column(columnDefinition = "DATETIME")
    private Instant updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
        updatedAt = Instant.now();
       // log.info("Consulta agendada para o paciente: {}", pacienteId.getNome());
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
        //log.info("Atualuzada a consulta do paciente: {}", pacienteId.getNome());
    }

}