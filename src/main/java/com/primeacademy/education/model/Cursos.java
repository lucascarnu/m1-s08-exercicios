package com.primeacademy.education.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

//Crie uma classe Cursos.
//A classe deve conter ao menos os atributos:
//ID (sequencial)
//Nome
//Descrição
//Carga Horária
//A classe deve conter um método estático para controlar a sequência dos IDs.
//A classe deve estar devidamente encapsulada.
//O atributo ID não deve possuir um método "set".

@Data
public class Cursos {

    @Setter(AccessLevel.NONE)private Integer id;
    private String nome;
    private String descricao;
    private Integer cargaHoraria;
    private static final AtomicInteger proximoId = new AtomicInteger(1);

    public Cursos(String nome, String descricao, Integer cargaHoraria) {
        this.id = sequenciadorId();
        this.nome = nome;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
    }

    private static Integer sequenciadorId() {
        return proximoId.getAndIncrement();
    }
}
