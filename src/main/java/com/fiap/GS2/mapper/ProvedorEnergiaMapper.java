package com.fiap.GS2.mapper;

import com.fiap.GS2.dto.ProvedorEnergiaDTO;
import com.fiap.GS2.model.ProvedorEnergia;
import org.springframework.stereotype.Component;

@Component
public class ProvedorEnergiaMapper {

    public ProvedorEnergiaDTO toDTO(ProvedorEnergia entity) {
        if (entity == null) {
            return null;
        }
        ProvedorEnergiaDTO dto = new ProvedorEnergiaDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setTecnologia(entity.getTecnologia());
        dto.setLocalizacao(entity.getLocalizacao());
        dto.setCapacidadeEnergia(entity.getCapacidadeEnergia());
        dto.setContato(entity.getContato());
        return dto;
    }

    public ProvedorEnergia toEntity(ProvedorEnergiaDTO dto) {
        if (dto == null) {
            return null;
        }
        ProvedorEnergia entity = new ProvedorEnergia();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setTecnologia(dto.getTecnologia());
        entity.setLocalizacao(dto.getLocalizacao());
        entity.setCapacidadeEnergia(dto.getCapacidadeEnergia());
        entity.setContato(dto.getContato());
        return entity;
    }
}
