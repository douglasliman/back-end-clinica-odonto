package com.projetointegrador.backEndConsultorioDentista.exception;

import java.util.UUID;

public class ConsultaNotFoundException extends RuntimeException{
    public ConsultaNotFoundException(UUID id)  {
        super("Consulta não encontrada".formatted(id));
    }
}
