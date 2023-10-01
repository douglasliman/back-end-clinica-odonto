package com.projetointegrador.backEndConsultorioDentista.api.dto.request;

import com.projetointegrador.backEndConsultorioDentista.domain.entity.Contato;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter

public class DentistaRequest {

    @NotBlank
    private String nome;
    @NotNull
    private LocalDate dataNascimento;
    @NotNull
    private String especialidade;
    @NotNull
    private String sexo;
    @NotNull
    private Contato contatoId;

    private ClinicaOdontologicaRequest clinicaOdontologica;
}
