package com.dio.live.live.service;

import com.dio.live.live.entity.Autor;
import com.dio.live.live.repository.AutorRepository;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AutorService {
    @Autowired
    AutorRepository autorRepository;

    public ResponseEntity<Object> createAutor(Autor model)  {
        Autor autor = new Autor();
        autor.setNome(model.getNome());
        autor.setLivros(model.getLivros());
        Autor autorSalvo = autorRepository.save(autor);
        if (autorRepository.findById(autorSalvo.getId()).isPresent()) return ResponseEntity.ok().build();
        else return ResponseEntity.unprocessableEntity().build();
    }
    public ResponseEntity<Object> updateAutor(Autor model, Long idAutor) {
        if(autorRepository.findById(idAutor).isPresent()){
            Autor autor = autorRepository.findById(idAutor).get();
            autor.setNome(model.getNome());
            autor.setLivros(model.getLivros());
            Autor autorSalvo = autorRepository.save(autor);
            if(autorRepository.findById(autorSalvo.getId()).isPresent()) return ResponseEntity.ok().build();
            else return ResponseEntity.badRequest().build();
        } else return ResponseEntity.unprocessableEntity().build();
    }
    public ResponseEntity<Object> deleteAutor(Long idAutor) {
        if(autorRepository.findById(idAutor).isPresent()){
            autorRepository.deleteById(idAutor);
            if (autorRepository.findById(idAutor).isPresent()) return ResponseEntity.unprocessableEntity().build();
            else return ResponseEntity.ok().build();
        } else return ResponseEntity.unprocessableEntity().build();
    }
    public ResponseEntity<Object> getAutores(){
        List<Autor> autoresList = autorRepository.findAll();
        if (!autoresList.isEmpty()){
            List<JSONObject> returnList = new ArrayList<>();

            for (Autor autor : autoresList) {
                JSONObject entity = new JSONObject();
                entity.put("id", autor.getId());
                entity.put("nome", autor.getNome());
                entity.put("livros", autor.getLivros());
                returnList.add(entity);
            }

            return new ResponseEntity<>(returnList, HttpStatus.OK);
        }else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    public ResponseEntity<Object> getAutor(Long idAutor){
        Optional<Autor> autor = autorRepository.findById(idAutor);
        if (autor.isPresent()){
            JSONObject returnObject = new JSONObject();
            returnObject.put("id", autor.get().getId());
            returnObject.put("nome", autor.get().getNome());
            returnObject.put("livros", autor.get().getLivros());

            return new ResponseEntity<>(returnObject, HttpStatus.OK);
        }else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
