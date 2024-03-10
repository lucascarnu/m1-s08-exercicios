package com.primeacademy.education.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.Date;
// Crie uma classe Aluno
// Deve conter ao menos os atributos: ID (sequencial), Nome, Data de Nascimento
// A classe deve conter um método estático para controlar a sequência dos IDs.
// A classe deve estar devidamente encapsulada.
// O atributo ID não deve possuir um método "set".

@Data
public class Aluno {

    @Setter(AccessLevel.NONE)private Integer id;
    private String nome;
    private Date dataNascimento;
    private static Integer proximoId = 1;

    public Aluno(String nome, Date dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.id = sequenciadorId();
    }



    public static Integer sequenciadorId() {
        return proximoId++;
    }
}
