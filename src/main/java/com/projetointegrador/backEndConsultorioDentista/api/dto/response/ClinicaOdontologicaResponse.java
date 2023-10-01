package com.projetointegrador.backEndConsultorioDentista.api.dto.response;


import com.projetointegrador.backEndConsultorioDentista.domain.entity.Contato;
import com.projetointegrador.backEndConsultorioDentista.domain.entity.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class ClinicaOdontologicaResponse {

    private UUID id;
    private String nome;
    private String cpnj;
    private String razaoSocial;
    private String descricao;
    private Instant createdAt;
    private Instant updatedAt;
    private Endereco endereco;
    private Contato contato;

}
