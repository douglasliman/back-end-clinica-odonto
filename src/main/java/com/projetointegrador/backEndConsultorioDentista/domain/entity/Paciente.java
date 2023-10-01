package com.projetointegrador.backEndConsultorioDentista.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Slf4j
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Paciente")
public class Paciente  {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 250, nullable = false)
    private String nome;


    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(length = 2, nullable = false)
    private String sexo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contato_id", foreignKey = @ForeignKey(name = "fk_paciente_contato"))
    private Contato contato;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", foreignKey = @ForeignKey(name = "fk_paciente_endereco"))
    private Endereco endereco;

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
        log.info("Novo paciente cadastrado: {}", nome);
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
        log.info("Atualizado dados do paciente: {}", nome);
    }
}