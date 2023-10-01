package com.projetointegrador.backEndConsultorioDentista.api.controller;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.projetointegrador.backEndConsultorioDentista.domain.entity.Paciente;
import com.projetointegrador.backEndConsultorioDentista.domain.repository.PacienteRepository;
import com.projetointegrador.backEndConsultorioDentista.domain.service.PacienteService;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import java.util.UUID;


@RestController
@RequestMapping("v1/pacientes")
@Tag(name = "Pacientes API", description = "API com dados dos pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    private final ObjectMapper mapper;
    private final PacienteRepository pacienteRepository;

    @Autowired
    public PacienteController(PacienteService pacienteService, ObjectMapper mapper,
                              PacienteRepository pacienteRepository) {
        this.pacienteService = pacienteService;

        this.mapper = mapper;
        this.pacienteRepository = pacienteRepository;
    }
    @PostMapping
    public ResponseEntity<Paciente> criarPaciente(@RequestBody Paciente paciente) {
        Paciente novoPaciente = pacienteService.cadastrarPaciente(paciente);
        return new ResponseEntity<>(novoPaciente, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPacientePorId(@PathVariable UUID id) {
        Paciente paciente = pacienteService.buscarPacientePorId(id);
        if (paciente != null) {
            return ResponseEntity.ok(paciente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> listarPacientes() {
        List<Paciente> pacientes = pacienteService.buscarTodosOsPaciente();
        return ResponseEntity.ok(pacientes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> atualizarPaciente(@PathVariable UUID id, @RequestBody Paciente paciente) {
        if (paciente != null) {
            Paciente atualizadoDentista = pacienteService.atualizarPaciente(id, paciente);
            return ResponseEntity.ok(atualizadoDentista);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPaciente(@PathVariable UUID id) {
        pacienteService.excluir(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/buscar/{nome}")
    public ResponseEntity<Paciente> buscarPorNome(@PathVariable String nome) {
        Paciente paciente = pacienteRepository.findPacienteByName(nome);
        if (paciente != null) {
            return ResponseEntity.ok(paciente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
