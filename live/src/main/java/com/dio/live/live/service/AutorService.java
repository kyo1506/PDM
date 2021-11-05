package com.dio.live.live.service;

import com.dio.live.live.entity.Autor;
import com.dio.live.live.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
        if(autorRepository.findById(autorSalvo.getId()).isPresent()) {
            return ResponseEntity.accepted().body("Autor criado com sucesso");
        } else
            return ResponseEntity.unprocessableEntity().body("Falha ao criar o autor");
    }

    public ResponseEntity<Object> updateAutor(Autor model, Long idAutor) {
        if(autorRepository.findById(idAutor).isPresent()){
            Autor autor = autorRepository.findById(idAutor).get();
            autor.setNome(model.getNome());
            Autor autorSalvo = autorRepository.save(autor);
            if(autorRepository.findById(idAutor).isPresent())
                return ResponseEntity.accepted().body("Autor atualizado com sucesso");
            else
                return ResponseEntity.badRequest().body("Falha ao atualizar o autor");
        } else
            return ResponseEntity.unprocessableEntity().body("Autor não encontrado");
    }

    public ResponseEntity<Object> deleteAutor(Long idAutor) {
        if(autorRepository.findById(idAutor).isPresent()){
            if(autorRepository.getById(idAutor).getLivros().size() == 0) {
                autorRepository.deleteById(idAutor);
                if (autorRepository.findById(idAutor).isPresent()) {
                    return ResponseEntity.unprocessableEntity().body("Falha ao deletar o autor especificado");
                } else
                    return ResponseEntity.ok().body("Autor deletado com sucesso");
            } else
                return ResponseEntity.unprocessableEntity().body("Falha ao deletar, por favor, delete os livros associados ao autor especificado");
        } else
            return ResponseEntity.unprocessableEntity().body("Autor não encontrado");
    }

    public List<Autor> getAutores(){
        return autorRepository.findAll();
    }

    public Optional<Autor> getAutor(Long idAutor){
        return autorRepository.findById(idAutor);
    }
}
