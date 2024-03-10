package com.primeacademy.education.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Curso {

    //Utilize um atributo estático e privado para o armazenamento dos alunos cadastrados
    //Getter adicionado à lista. Utilizado pelo método buscarTodos()
    @Getter private static final List<Curso> CURSOS_CADASTRADOS = new ArrayList<>();

    @Setter(AccessLevel.NONE)private Integer id;
    private String nome;
    private String descricao;
    private Integer cargaHoraria;
    // Experimentando outra forma de sequenciar Ids
    private static final AtomicInteger proximoId = new AtomicInteger(1);

    public Curso(String nome, String descricao, Integer cargaHoraria) {
        this.id = sequenciadorId();
        this.nome = nome;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
    }

    //Método sequenciador com diferente implementação
    private static Integer sequenciadorId() {
        return proximoId.getAndIncrement();
    }

    // Método responsável pela inclusão
    public static Curso inserir(Curso curso) {
        curso.id = sequenciadorId();
        CURSOS_CADASTRADOS.add(curso);
        return curso;
    }
}
