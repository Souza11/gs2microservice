package com.fiap.GS2.controller;

import com.fiap.GS2.dto.ProvedorEnergiaDTO;
import com.fiap.GS2.service.ProvedorEnergiaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/provedores")
public class ProvedorEnergiaController {

    private final ProvedorEnergiaService service;

    public ProvedorEnergiaController(ProvedorEnergiaService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProvedorEnergiaDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProvedorEnergiaDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping(params = "nome")
    public List<ProvedorEnergiaDTO> buscarPorNome(@RequestParam String nome) {
        return service.buscarPorNome(nome);
    }

    @PostMapping
    public ResponseEntity<ProvedorEnergiaDTO> criar(@RequestBody ProvedorEnergiaDTO dto) {
        return ResponseEntity.ok(service.criar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProvedorEnergiaDTO> atualizar(@PathVariable Long id, @RequestBody ProvedorEnergiaDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
