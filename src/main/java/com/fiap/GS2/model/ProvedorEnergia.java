package com.fiap.GS2.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "provedor_energia")
@Data
public class ProvedorEnergia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String tecnologia;
    private String localizacao;
    private Double capacidadeEnergia;
    private String contato;
}
