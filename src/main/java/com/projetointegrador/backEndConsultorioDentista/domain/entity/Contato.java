package com.projetointegrador.backEndConsultorioDentista.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.util.UUID;

@Slf4j
@Getter
@Setter
@Entity
@Table(name = "Contato")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 15, nullable = false)
    private String telefone;


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
        log.info("Novo e-mail cadastrado: {}", email);
        log.info("Novo telefone cadastrado: {}", telefone);

    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
        log.info("E-mail atualizado: {}", email);
        log.info("Telefone atualizado: {}", telefone);

    }

}