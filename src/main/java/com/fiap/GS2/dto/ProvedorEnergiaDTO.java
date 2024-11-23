package com.fiap.GS2.dto;

import lombok.Data;

@Data
public class ProvedorEnergiaDTO {
    private Long id;
    private String nome;
    private String tecnologia;
    private String localizacao;
    private Double capacidadeEnergia;
    private String contato;
}
