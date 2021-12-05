package com.dio.live.live.controller;

import com.dio.live.live.entity.Livro;
import com.dio.live.live.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LivroController {

    @Autowired
    LivroService livroService;

    @PostMapping(value = "/livro/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createLivro(@RequestBody Livro livro){
        return livroService.createLivro(livro);
    }

    @GetMapping(value = "/livro/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getLivros(){
        return livroService.getLivros();
    }

    @GetMapping(value = "/livro/details/{idLivro}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getLivro(@PathVariable("idLivro") Long idLivro) {
        return livroService.getLivro(idLivro);
    }

    @PutMapping(value = "/livro/update/{idLivro}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateLivro(@PathVariable("idLivro") Long idLivro, @RequestBody Livro livro){
        return livroService.updateLivro(livro, idLivro);
    }

    @DeleteMapping(value = "livro/delete/{idLivro}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteLivro(@PathVariable("idLivro") Long idLivro) {
        return livroService.deleteLivro(idLivro);
    }
}
