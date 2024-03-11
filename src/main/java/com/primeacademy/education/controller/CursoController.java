package com.primeacademy.education.controller;

import com.primeacademy.education.model.Aluno;
import com.primeacademy.education.model.Curso;
import com.primeacademy.education.service.CursoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;


    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    /**
     * Criação
     */
    @PostMapping
    public Curso post(@RequestBody Curso curso) throws Exception {
        return cursoService.salvar(curso);
    }

    /**
     * Buscar todos
     */
    @GetMapping
    public List<Curso> get() {
        return cursoService.buscarTodos();
    }

    /**
     * Adicionar aluno a um curso
     */
    @PostMapping("{id}/add-aluno")
    public Curso postAluno(@PathVariable Integer id, @RequestBody Aluno aluno) throws Exception {
        return cursoService.adicionarAluno(id, aluno.getId());
    }

    /**
     *  Busca por ID
     */
    @GetMapping("{id}")
    public Curso getId(@PathVariable Integer id) throws Exception {
        return cursoService.buscarPorId(id);
    }


}
