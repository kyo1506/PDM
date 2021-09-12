package com.dio.live.live.controller;

import com.dio.live.live.entity.Livro;
import com.dio.live.live.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LivroController {

    @Autowired
    LivroService livroService;

    @PostMapping("/livro/create")
    public ResponseEntity<Object> createLivro(@RequestBody Livro livro){
        return livroService.createLivro(livro);
    }

    @GetMapping("/livro/all")
    public List<Livro> getLivros(){
        return livroService.getLivros();
    }

    @GetMapping("/livro/details/{idLivro}")
    public Optional<Livro> getLivro(@PathVariable("idLivro") Long idLivro) {
        return  livroService.getLivro(idLivro);
    }

    @PutMapping("/livro/update/{idLivro}")
    public ResponseEntity<Object> updateLivro(@PathVariable("idLivro") Long idLivro, @RequestBody Livro livro){
        return livroService.updateLivro(livro, idLivro);
    }

    @DeleteMapping("livro/delete/{idLivro}")
    public ResponseEntity<Object> deleteLivro(@PathVariable("idLivro") Long idLivro) {
        return livroService.deleteLivro(idLivro);
    }
}
