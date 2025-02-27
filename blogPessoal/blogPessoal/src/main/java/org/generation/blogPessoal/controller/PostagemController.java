package org.generation.blogPessoal.controller;

import org.generation.blogPessoal.model.Postagem;
import org.generation.blogPessoal.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {

    @Autowired
    private PostagemRepository repository;

    // Método para buscar todas as postagens
    @GetMapping
    public ResponseEntity<List<Postagem>> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    // Método para buscar postagem por ID
    @GetMapping("/{id}")
    public ResponseEntity<Postagem> getById(@PathVariable long id){
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }

    // Método para buscar postagem por título
    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<Postagem>> getByTitulo(@PathVariable String titulo){
        return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
    }
    // Método para cadastrar postagem
    @PostMapping
    public ResponseEntity<Postagem> postPostagem(@RequestBody Postagem postagem){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
    }
    // Método para atualizar postagem
    @PutMapping
    public ResponseEntity<Postagem> putPostagem(@RequestBody Postagem postagem){
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
    }

    // Método para deletar postagem
    @DeleteMapping("/{id}")
    public void deletePostagem(@PathVariable long id){
        repository.deleteById(id);
    }
}
