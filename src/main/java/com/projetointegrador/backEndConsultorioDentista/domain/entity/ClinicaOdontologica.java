package com.projetointegrador.backEndConsultorioDentista.domain.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;


import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "ClinicaOdontologica")
public class ClinicaOdontologica {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 255, nullable = false)
    private String nome;

    @Column(length = 20, nullable = false, unique = true )
    private String cpnj;


    @Column(length = 255, nullable = false)
    private String razaoSocial;

    @Column(length = 255, nullable = false)
    private String descricao;


    @ManyToMany
    @JoinTable(name="clinica_odontologica_dentista_id",
            joinColumns = @JoinColumn(name = "clinica_odontologica_id"),
            inverseJoinColumns = @JoinColumn(name = "id_dentista")
    )
    private Set<Dentista> dentistasClinica;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contato_id")
    private Contato contato;


    private Instant createdAt;

    private Instant updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
        updatedAt = Instant.now();
        log.info("Nova clínica criada: {}", nome);
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
        log.info("Atualizado dados da clínica: {}", nome);
    }

}