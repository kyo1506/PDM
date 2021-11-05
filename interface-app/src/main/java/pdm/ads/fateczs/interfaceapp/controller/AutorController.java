package pdm.ads.fateczs.interfaceapp.controller;

import pdm.ads.fateczs.interfaceapp.model.bean.Autor;
import pdm.ads.fateczs.interfaceapp.model.dao.AutorDAO;

import java.util.List;

public class AutorController {
    AutorDAO autorDAO = new AutorDAO();
    public void insertAutor (Autor autor) {
        autorDAO.insertAutor(autor);
    }
    public void updateAutor (Autor autor) {
        autorDAO.updateAutor(autor);
    }
    public Autor getById (Long id)
    {
        return autorDAO.getById(id);
    }
    public List<Autor> listAll () {
        return autorDAO.listAll();
    }
    public void deleteById (Long id) {
        autorDAO.deleteByID(id);
    }
    public void removerLivro (Long livroId, Long autorId) {
        autorDAO.removerLivro(livroId, autorId);
    }
    public void adicionarLivro (Long livroId, Long autorId) {
        autorDAO.adicionarLivro(livroId, autorId);
    }
}
