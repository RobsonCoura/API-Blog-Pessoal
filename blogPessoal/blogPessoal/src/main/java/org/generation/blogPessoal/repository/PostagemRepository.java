package org.generation.blogPessoal.repository;

import org.generation.blogPessoal.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {

    // Método para buscar postagem por título
    public List<Postagem> findAllByTituloContainingIgnoreCase(String titulo);
}
