package com.projetointegrador.backEndConsultorioDentista.exception;

import java.util.UUID;

public class DentistaNotFoundException extends RuntimeException{
    public DentistaNotFoundException(UUID id)  {
        super("Dentista não encontrado".formatted(id));
    }
}
