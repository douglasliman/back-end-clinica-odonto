package com.projetointegrador.backEndConsultorioDentista.api.dto.request;

import com.projetointegrador.backEndConsultorioDentista.domain.entity.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;

@Getter
@Setter
public class ConsultaRequest {
    @NotNull
    private LocalDateTime dataConsulta;
    @NotNull
    private Paciente paciente;
    @NotNull
    private Dentista dentista;
    @NotNull
    private ClinicaOdontologica clinicaOdontologica;
    @NotNull
    private String descricao;
    @NotNull
    private Boolean cancelada;
    @NotNull
    private String motivoCancelamento;
}
