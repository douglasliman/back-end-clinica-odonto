package com.projetointegrador.backEndConsultorioDentista.api.dto.request;

import com.projetointegrador.backEndConsultorioDentista.domain.entity.Contato;
import com.projetointegrador.backEndConsultorioDentista.domain.entity.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter

public class PacienteRequest {

    @NotBlank
    private String nome;
    @NotNull
    private LocalDate dataNascimento;
    @NotNull
    private String sexo;
    @NotNull
    private Endereco endereco;
    @NotNull
    private Contato contato;

}
