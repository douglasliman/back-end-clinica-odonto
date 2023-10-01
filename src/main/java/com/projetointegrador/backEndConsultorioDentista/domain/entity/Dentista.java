package com.projetointegrador.backEndConsultorioDentista.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.GenericGenerator;


import java.time.Instant;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;
@Slf4j
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "Dentista")
public class Dentista {



    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(length = 250, nullable = false)
    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;


    @Column(length = 80, nullable = false)
    private String especialidade;


    @Column(length = 10, nullable = false)
    private String sexo;

    @Transient
    @Column(columnDefinition = "DATETIME")
    private Instant createdAt;

    @Transient
    @Column(columnDefinition = "DATETIME")
    private Instant updatedAt;

    @ManyToMany(mappedBy = "dentistasClinica")
    private Set<ClinicaOdontologica> clinicasOdontologicas;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "contato_id",
            referencedColumnName = "id",
            foreignKey =
            @ForeignKey(name = "fk_contato_dentista"))
    private Contato contato;

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
        updatedAt = Instant.now();
        log.info("Novo dentista cadastrado: {}", nome);
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
        log.info("Dados dentista atualizado : {}", nome);
    }

}

