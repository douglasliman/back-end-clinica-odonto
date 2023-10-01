package com.projetointegrador.backEndConsultorioDentista.api.controller;

import com.projetointegrador.backEndConsultorioDentista.domain.entity.Consulta;
import com.projetointegrador.backEndConsultorioDentista.domain.service.ConsultaService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@Slf4j
@RequestMapping("v1/consultas")
@Tag(name = "Consultas API", description = "API com dados das consultas")
public class ConsultaController  {


    private final ConsultaService consultaService;

    @Autowired
    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @PostMapping
    public ResponseEntity<Consulta> criarConsulta(@RequestBody Consulta consulta) {
        Consulta novaConsulta = consultaService.criarConsulta(consulta);
        return new ResponseEntity<>(novaConsulta, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consulta> buscarConsultaPorId(@PathVariable UUID id) {
        Consulta consulta = consultaService.buscarConsultaPorId(id);
        if (consulta != null) {
            return ResponseEntity.ok(consulta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Consulta>> listarConsultas() {
        List<Consulta> consultas = consultaService.buscarTodasAsConsultas();
        return ResponseEntity.ok(consultas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consulta> atualizarDentista(@PathVariable UUID id, @RequestBody Consulta consulta) {
        if (consulta != null) {
            Consulta atualizadaConsulta = consultaService.atualizarConsulta(id, consulta);
            return ResponseEntity.ok(atualizadaConsulta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarConsulta(@PathVariable UUID id) {
        consultaService.cancelarConsultar(id);
        return ResponseEntity.noContent().build();
    }



}
