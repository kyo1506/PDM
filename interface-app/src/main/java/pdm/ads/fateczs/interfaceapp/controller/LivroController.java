package pdm.ads.fateczs.interfaceapp.controller;

import pdm.ads.fateczs.interfaceapp.model.bean.Livro;
import pdm.ads.fateczs.interfaceapp.model.dao.LivroDAO;

import java.util.List;

public class LivroController {
    LivroDAO livroDAO = new LivroDAO();
    public void insertLivro (Livro livro) {
        livroDAO.insertLivro(livro);
    }
    public void updateLivro (Livro livro) {
        livroDAO.updateLivro(livro);
    }
    public Livro getById (Long id)
    {
        return livroDAO.getById(id);
    }
    public List<Livro> listAll () {
        return livroDAO.listAll();
    }
    public void deleteById (Long id) {
        livroDAO.deleteById(id);
    }
    public void removeAutor (Long livroId, Long autorId) {
        livroDAO.removeAutor(livroId, autorId);
    }
    public void adicionarAutor (Long livroId, Long autorId) {
        livroDAO.adicionarAutor(livroId, autorId);
    }
}
