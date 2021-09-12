package com.dio.live.live.service;

import com.dio.live.live.entity.Livro;
import com.dio.live.live.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    @Autowired
    LivroRepository livroRepository;

    public ResponseEntity<Object> createLivro(Livro model) {
        Livro livro = new Livro();

        livro.setNome(model.getNome());
        livro.setAutores(model.getAutores());

        Livro livroSalvo = livroRepository.save(livro);
        if (livroRepository.findById(livroSalvo.getId()).isPresent())
            return ResponseEntity.ok("Livro criado com sucesso");
        else return ResponseEntity.unprocessableEntity().body("Falha ao criar o livro especificado");
    }

    @Transactional
    public ResponseEntity<Object> updateLivro(Livro livro, Long idLivro) {
        if(livroRepository.findById(idLivro).isPresent()) {
            Livro novoLivro = livroRepository.findById(idLivro).get();
            novoLivro.setNome(livro.getNome());
            novoLivro.setAutores(livro.getAutores());
            Livro livroSalvo = livroRepository.save(novoLivro);
            if(livroRepository.findById(livroSalvo.getId()).isPresent())
                return  ResponseEntity.accepted().body("Livro atualizado com sucesso");
            else return ResponseEntity.unprocessableEntity().body("Falha ao atualizar o livro especificado");
        } else return ResponseEntity.unprocessableEntity().body("Não foi possível encontrar o livro especificado");
    }

    public ResponseEntity<Object> deleteLivro(Long idLivro) {
        if (livroRepository.findById(idLivro).isPresent()) {
            livroRepository.deleteById(idLivro);
            if (livroRepository.findById(idLivro).isPresent())
                return ResponseEntity.unprocessableEntity().body("Falha ao deletar o livro especificado");
            else return ResponseEntity.ok().body("Sucesso ao deletar o livro especificado");
        } else return ResponseEntity.badRequest().body("Não foi possível encontrar o livro especificado");
    }

    public List<Livro> getLivros(){
        return livroRepository.findAll();
    }

    public Optional<Livro> getLivro(Long idLivro){
        return livroRepository.findById(idLivro);
    }
}
