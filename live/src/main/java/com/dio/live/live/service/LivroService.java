package com.dio.live.live.service;

import com.dio.live.live.entity.Livro;
import com.dio.live.live.repository.LivroRepository;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    @Autowired
    LivroRepository livroRepository;

    public ResponseEntity<Object> createLivro(Livro model) {
        Livro livro = new Livro();
        livro.setNome(model.getNome());
        Livro livroSalvo = livroRepository.save(livro);
        if (livroRepository.findById(livroSalvo.getId()).isPresent()) return ResponseEntity.ok().build();
        else return ResponseEntity.unprocessableEntity().build();
    }
    @Transactional
    public ResponseEntity<Object> updateLivro(Livro livro, Long idLivro) {
        if(livroRepository.findById(idLivro).isPresent()) {
            Livro novoLivro = livroRepository.findById(idLivro).get();
            novoLivro.setNome(livro.getNome());
            Livro livroSalvo = livroRepository.save(novoLivro);
            if(livroRepository.findById(livroSalvo.getId()).isPresent()) return  ResponseEntity.ok().build();
            else return ResponseEntity.unprocessableEntity().build();
        } else return ResponseEntity.unprocessableEntity().build();
    }
    public ResponseEntity<Object> deleteLivro(Long idLivro) {
        if (livroRepository.findById(idLivro).isPresent()) {
            livroRepository.deleteById(idLivro);
            if (livroRepository.findById(idLivro).isPresent()) return ResponseEntity.unprocessableEntity().build();
            else return ResponseEntity.ok().build();
        } else return ResponseEntity.badRequest().build();
    }
    public ResponseEntity<Object> getLivros(){
        List<Livro> livrosList = livroRepository.findAll();
        if (!livrosList.isEmpty()) {
            List<JSONObject> returnList = new ArrayList<>();

            for (Livro livro : livrosList) {
                JSONObject entity = new JSONObject();
                entity.put("id", livro.getId());
                entity.put("nome", livro.getNome());
                returnList.add(entity);
            }

            return new ResponseEntity<>(returnList, HttpStatus.OK);
        }else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    public ResponseEntity<Object> getLivro(Long idLivro){
        Optional<Livro> livro = livroRepository.findById(idLivro);
        if (livro.isPresent()){
            JSONObject returnObject = new JSONObject();
            returnObject.put("id", livro.get().getId());
            returnObject.put("nome", livro.get().getNome());

            return new ResponseEntity<>(returnObject, HttpStatus.OK);
        }else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
