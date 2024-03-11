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
    @Getter
    @Setter(AccessLevel.NONE)
    private static final List<Curso> CURSOS_CADASTRADOS = new ArrayList<>();

    @Setter(AccessLevel.NONE)private Integer id;
    private String nome;
    private String descricao;
    private Integer cargaHoraria;
    // Experimentando outra forma de sequenciar Ids
    private static final AtomicInteger proximoId = new AtomicInteger(1);

    @Setter(AccessLevel.NONE)
    private List<Aluno> alunos = new ArrayList<>();


    public Curso(String nome, String descricao, Integer cargaHoraria) {
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

    public static void adicionarAluno(Curso curso, Aluno aluno) {
        curso.getAlunos().add(aluno);
    }

    public static Curso buscarPorId(Integer id) throws Exception {
        for (Curso curso : CURSOS_CADASTRADOS) {
            if (curso.getId().equals(id)) {
                return curso;
            }
        }
        throw new Exception("Curso não encontrado");
    }
}
