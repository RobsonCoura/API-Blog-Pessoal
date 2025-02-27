package org.generation.blogPessoal.controller;

import org.generation.blogPessoal.model.Tema;
import org.generation.blogPessoal.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/temas")
public class TemaController {

    // Injeção de dependência
    @Autowired
    private TemaRepository repository;

    // Metodo para buscar todos os temas
    @GetMapping
    public ResponseEntity<List<Tema>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    // Metodo para buscar tema por ID
    @GetMapping("/{id}")
    public ResponseEntity<Tema> getById(@PathVariable long id) {
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }

    // Metodo para buscar tema por nome
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Tema>> getByName(@PathVariable String nome) {
        return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(nome));
    }

    // Metodo para cadastrar tema
    @PostMapping
    public ResponseEntity<Tema> postTema(@RequestBody Tema tema) {
        return ResponseEntity.status(201).body(repository.save(tema));
    }

    // Metodo para atualizar tema
    @PutMapping
    public ResponseEntity<Tema> putTema(@RequestBody Tema tema) {
        return ResponseEntity.status(200).body(repository.save(tema));
    }

    // Metodo para deletar tema
    @DeleteMapping("/{id}")
    public void deleteTema(@PathVariable long id) {
        repository.deleteById(id);
    }
}
