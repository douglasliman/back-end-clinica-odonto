package com.projetointegrador.backEndConsultorioDentista.api.dto.response;



import com.projetointegrador.backEndConsultorioDentista.domain.entity.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class ConsultaResponse {

    private UUID id;
    private LocalDateTime dataConsulta;
    private Paciente paciente;
    private Dentista dentista;
    private String descricao;
    private Boolean cancelada;
    private ClinicaOdontologica clinicaOdontologica;
    private Instant createdAt;
    private Instant updatedAt;


}
