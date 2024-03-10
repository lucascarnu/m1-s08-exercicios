package com.primeacademy.education.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Aluno {

    @Setter(AccessLevel.NONE)private Integer id;

    //Utilize um atributo estático e privado para o armazenamento dos alunos cadastrados
    //Getter adicionado à lista. Utilizado pelo método buscarTodos() 
    @Getter private static final List<Aluno> ALUNOS_CADASTRADOS = new ArrayList<>();

    private String nome;
    private Date dataNascimento;
    private static Integer proximoId = 1;

    // Construtor (cada aluno instanciado é cadastrado com um Id novo
    public Aluno(String nome, Date dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.id = sequenciadorId();
    }

    // Método sequenciador de Id
    public static Integer sequenciadorId() {
        return proximoId++;
    }

    // Método responsável pela inclusão
    public static Aluno inserir(Aluno aluno) {
        aluno.id = proximoId++;
        ALUNOS_CADASTRADOS.add(aluno);
        return aluno;
    }


}
