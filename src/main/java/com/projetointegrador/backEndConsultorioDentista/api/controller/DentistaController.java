package com.projetointegrador.backEndConsultorioDentista.api.controller;

import com.projetointegrador.backEndConsultorioDentista.domain.entity.Dentista;
import com.projetointegrador.backEndConsultorioDentista.domain.service.DentistaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("v1/dentistas")
@Tag(name = "Dentistas API", description = "API com dados dos dentistas")
public class DentistaController {


    private final DentistaService dentistaService;

    @Autowired
    public DentistaController(DentistaService dentistaService) {
        this.dentistaService = dentistaService;
    }

    @PostMapping
    public ResponseEntity<Dentista> criarDentista(@RequestBody Dentista dentista) {
        Dentista novoDentista = dentistaService.cadastrarDentista(dentista);
        return new ResponseEntity<>(novoDentista, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dentista> buscarDentistaPorId(@PathVariable UUID id) {
        Dentista dentista = dentistaService.buscarDentistaPorId(id);
        if (dentista != null) {
            return ResponseEntity.ok(dentista);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Dentista>> listarDentistas() {
        List<Dentista> dentistas = dentistaService.buscarTodosOsDentista();
        return ResponseEntity.ok(dentistas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dentista> atualizarDentista(@PathVariable UUID id, @RequestBody Dentista dentista) {
        if (dentista != null) {
            Dentista atualizadoDentista = dentistaService.atualizarDentista(id, dentista);
            return ResponseEntity.ok(atualizadoDentista);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDentista(@PathVariable UUID id) {
        dentistaService.excluir(id);
        return ResponseEntity.noContent().build();
    }

}


