package controller;

import model.bean.Autor;
import model.dao.AutorDAO;

import java.util.List;

public class AutorController {
    AutorDAO autorDAO = new AutorDAO();

    public void insertOrUpdate (Autor pessoa) {
        autorDAO.insertOrUpdate(pessoa);
    }

    public Autor findById (Long id)
    {
        return autorDAO.getById(id);
    }

    public List<Autor> listAll () {
        return autorDAO.listAll();
    }

    public void deleteById (Long id) {
        autorDAO.deleteByID(id);
    }
}
