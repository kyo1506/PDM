package controller;

import model.bean.Livro;
import model.dao.LivroDAO;

import java.util.List;

public class LivroController {
    LivroDAO livroDAO = new LivroDAO();

    public void insertOrUpdate (Livro livro) {
        livroDAO.insertOrUpdate(livro);
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
}
