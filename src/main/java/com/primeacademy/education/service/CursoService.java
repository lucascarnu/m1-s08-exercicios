package com.primeacademy.education.service;

import com.primeacademy.education.model.Aluno;
import com.primeacademy.education.model.Curso;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final AlunoService alunoService;

    public CursoService(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    private void validarCampoObrigatorio(String valor, String mensagemErro) throws Exception {
        if (valor == null || valor.isBlank()) {
            throw new Exception(mensagemErro);
        }
    }

    private boolean validar(Curso curso) throws Exception {
        validarCampoObrigatorio(curso.getNome(), "Nome é obrigatório");
        validarCampoObrigatorio(String.valueOf(curso.getDescricao()), "Descrição é obrigatória");

        if (curso.getCargaHoraria() == null || curso.getCargaHoraria() <= 30) {
            throw new Exception("Carga horária não informada ou menor que 0");
        }

        return true;
    }

    public Curso salvar(Curso curso) throws Exception {
        if (validar(curso)) {
            return Curso.inserir(curso);
        }
        return null;
    }

    public Curso buscarPorId(Integer id) throws Exception {
        return Curso.buscarPorId(id);
    }

    public static List<Curso> buscarTodos() {
        return Curso.getCURSOS_CADASTRADOS();
    }

    public Curso adicionarAluno(Integer id, Integer alunoId) throws Exception {
        Curso curso = buscarPorId(id);
        Aluno aluno = alunoService.buscarPorId(alunoId);
        Curso.adicionarAluno(curso, aluno);
        return curso;
    }
}

