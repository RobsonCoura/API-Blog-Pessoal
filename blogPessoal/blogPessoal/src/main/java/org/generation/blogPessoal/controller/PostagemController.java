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
    
}
