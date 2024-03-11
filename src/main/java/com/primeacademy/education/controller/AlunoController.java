package com.primeacademy.education.controller;

import com.primeacademy.education.model.Aluno;
import com.primeacademy.education.service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;


    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    /**
     * Criação
     */
    @PostMapping
    public Aluno post(@RequestBody Aluno aluno) throws Exception {
        return alunoService.salvar(aluno);
    }

    /**
     * Buscar todos
     */
    @GetMapping
    public List<Aluno> get() {
        return alunoService.buscarTodos();
    }
}
