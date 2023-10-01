package com.projetointegrador.backEndConsultorioDentista.exception;

import java.util.UUID;

public class ClinicaNotFoundException extends RuntimeException{
    public ClinicaNotFoundException(UUID id)  {
        super("Paciente não encontrado".formatted(id));
    }
}
