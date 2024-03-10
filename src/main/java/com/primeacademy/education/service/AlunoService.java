package com.primeacademy.education.service;

import com.primeacademy.education.model.Aluno;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private void validarCampoObrigatorio(Object valor, String mensagemErro) throws Exception {
        if (valor == null) {
            throw new Exception(mensagemErro);
        }
    }

    private boolean validar(Aluno aluno) throws Exception {
        validarCampoObrigatorio(aluno.getNome(), "Nome é obrigatório");
        validarCampoObrigatorio(aluno.getDataNascimento(), "Data de nascimento é obrigatório");

        return true;
    }

    public Aluno salvar(Aluno aluno) throws Exception {
        if (validar(aluno)) {
            return Aluno.inserir(aluno);
        }
        return null;
    }

    public static List<Aluno> buscarTodos() {
        return Aluno.getALUNOS_CADASTRADOS();
    }
}

