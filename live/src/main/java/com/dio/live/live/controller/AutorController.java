package com.dio.live.live.controller;

import com.dio.live.live.entity.Autor;
import com.dio.live.live.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AutorController {

    @Autowired
    AutorService autorService;

    @PostMapping("/autor/create")
    public ResponseEntity<Object> createAutor(@RequestBody Autor autor) {
        return  autorService.createAutor(autor);
    }

    @DeleteMapping("/autor/delete/{idAutor}")
    public ResponseEntity<Object> deleteAutor(@PathVariable("idAutor") Long idAutor) {
        return autorService.deleteAutor(idAutor);
    }

    @GetMapping("/autor/details/{idAutor}")
    public Optional<Autor> getAutor(@PathVariable("idAutor") Long idAutor) {
            return autorService.getAutor(idAutor);
    }

    @GetMapping("/autor/all")
    public List<Autor> getRoles() {
        return autorService.getAutores();
    }

    @PutMapping("/autor/update/{idAutor}")
    public ResponseEntity<Object> updateRole(@PathVariable("idAutor") Long idAutor, @RequestBody Autor autor) {
        return autorService.updateAutor(autor, idAutor);
    }
}
