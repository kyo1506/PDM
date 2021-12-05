package com.dio.live.live.controller;

import com.dio.live.live.entity.Autor;
import com.dio.live.live.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AutorController {

    @Autowired
    AutorService autorService;

    @PostMapping(value = "/autor/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createAutor(@RequestBody Autor autor) {
        return  autorService.createAutor(autor);
    }

    @DeleteMapping(value = "/autor/delete/{idAutor}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteAutor(@PathVariable("idAutor") Long idAutor) {
        return autorService.deleteAutor(idAutor);
    }

    @GetMapping(value = "/autor/details/{idAutor}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAutor(@PathVariable("idAutor") Long idAutor) {
            return autorService.getAutor(idAutor);
    }

    @GetMapping(value = "/autor/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAutores() {
        return autorService.getAutores();
    }

    @PutMapping(value = "/autor/update/{idAutor}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateAutor(@PathVariable("idAutor") Long idAutor, @RequestBody Autor autor) {
        return autorService.updateAutor(autor, idAutor);
    }
}
