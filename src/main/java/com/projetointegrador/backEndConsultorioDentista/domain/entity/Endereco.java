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
@Table(name = "Endereco")
public class Endereco {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 100, nullable = false)
    private String rua;

    @Column(length = 100, nullable = false)
    private String bairro;

    @Column(length = 100, nullable = false)
    private String cidade;

    @Column(length = 100, nullable = false)
    private String estado;


    @Column(length = 10, nullable = false)
    private String cep;

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
        log.info("Novo endereço cadastrado: {}, {}",rua, cidade, cep, estado);
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
        log.info("Endereço atualizado: {}, {}", rua, cidade);
    }
}
