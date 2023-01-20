package com.test.tec.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome", length = 85)
    private String nome;

    @Column(name = "dataNasci")
    private LocalDate dataNasci;

    public Pessoa(String nome, LocalDate dataNasci){
        this.nome = nome;
        this.dataNasci = dataNasci;
    }
}
