package com.primeacademy.education.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dataNascimento;
    private static Integer proximoId = 1;

    //Construtor
    public Aluno(String nome, Date dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    // Método sequenciador de Id
    public static Integer sequenciadorId() {
        return proximoId++;
    }

    // Método responsável pela inclusão
    public static Aluno inserir(Aluno aluno) {
        aluno.id = sequenciadorId();
        ALUNOS_CADASTRADOS.add(aluno);
        return aluno;
    }
    // Método que busca aluno por id
    public static Aluno buscarPorId(Integer id) throws Exception {
        for (Aluno aluno : ALUNOS_CADASTRADOS) {
            if (aluno.getId().equals(id)) {
                return aluno;
            }
        }
        throw new Exception("Aluno não encontrado");
    }
}
