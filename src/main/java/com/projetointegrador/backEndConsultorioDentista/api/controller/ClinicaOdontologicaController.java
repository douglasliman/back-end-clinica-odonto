package com.projetointegrador.backEndConsultorioDentista.api.controller;

import com.projetointegrador.backEndConsultorioDentista.domain.entity.ClinicaOdontologica;
import com.projetointegrador.backEndConsultorioDentista.domain.repository.ClinicaOdontologicaRepository;
import com.projetointegrador.backEndConsultorioDentista.domain.service.ClinicaOdontologicaService;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("v1/clinicas")
@Tag(name = "Clinicas Odontológicas API", description = "API com dados das Clínicas Odontológicas")
public class ClinicaOdontologicaController {

    private final ClinicaOdontologicaService clinicaOdontologicaService;
    private final ClinicaOdontologicaRepository clinicaOdontologicaRepository;

    @Autowired
    public ClinicaOdontologicaController(ClinicaOdontologicaService clinicaOdontologicaService,
                                         ClinicaOdontologicaRepository clinicaOdontologicaRepository) {
        this.clinicaOdontologicaService = clinicaOdontologicaService;
        this.clinicaOdontologicaRepository = clinicaOdontologicaRepository;
    }

    @PostMapping
    public ResponseEntity<ClinicaOdontologica> cadastrarClinica(@RequestBody ClinicaOdontologica clinicaOdontologica) {
        ClinicaOdontologica novaClinica = clinicaOdontologicaService.cadastrarClinica(clinicaOdontologica);
        return new ResponseEntity<>(novaClinica, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClinicaOdontologica> buscarClinicaPorId(@PathVariable UUID id) {
        ClinicaOdontologica clinicaOdontologica = clinicaOdontologicaService.buscarClinicasPorId(id);
        if (clinicaOdontologica != null) {
            return ResponseEntity.ok(clinicaOdontologica);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ClinicaOdontologica>> listarTodasClinicas() {
        List<ClinicaOdontologica> clinicaOdontologica = clinicaOdontologicaService.buscarTodasAsClinicas();
        return ResponseEntity.ok(clinicaOdontologica);
    }



    @PutMapping("/{id}")
    public ResponseEntity<ClinicaOdontologica> atualizarDentista(@PathVariable UUID id, @RequestBody ClinicaOdontologica  clinicaOdontologica) {
        if (clinicaOdontologica != null) {
            ClinicaOdontologica atualizadaClinica = clinicaOdontologicaService.atualizarClinica(id, clinicaOdontologica);
            return ResponseEntity.ok(atualizadaClinica);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarClinica(@PathVariable UUID id) {
        clinicaOdontologicaService.excluirClinica(id);
        return ResponseEntity.noContent().build();
    }



}
