package com.fiap.GS2.service;

import com.fiap.GS2.dto.ProvedorEnergiaDTO;
import com.fiap.GS2.mapper.ProvedorEnergiaMapper;
import com.fiap.GS2.model.ProvedorEnergia;
import com.fiap.GS2.repository.ProvedorEnergiaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProvedorEnergiaService {

    private final ProvedorEnergiaRepository repository;
    private final ProvedorEnergiaMapper mapper;

    public ProvedorEnergiaService(ProvedorEnergiaRepository repository, ProvedorEnergiaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<ProvedorEnergiaDTO> listarTodos() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public ProvedorEnergiaDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Provedor não encontrado."));
    }

    public List<ProvedorEnergiaDTO> buscarPorNome(String nome) {
        return repository.findByNome(nome).stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public ProvedorEnergiaDTO criar(ProvedorEnergiaDTO dto) {
        ProvedorEnergia entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    public ProvedorEnergiaDTO atualizar(Long id, ProvedorEnergiaDTO dto) {
        ProvedorEnergia entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Provedor não encontrado."));
        entity.setNome(dto.getNome());
        entity.setTecnologia(dto.getTecnologia());
        entity.setLocalizacao(dto.getLocalizacao());
        entity.setCapacidadeEnergia(dto.getCapacidadeEnergia());
        entity.setContato(dto.getContato());
        return mapper.toDTO(repository.save(entity));
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
