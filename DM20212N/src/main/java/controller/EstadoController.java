package controller;

import model.bean.Estado;
import model.dao.EstadoDAO;

import java.util.List;

public class EstadoController {
    EstadoDAO estadoDAO = new EstadoDAO();

    public void inserir (Estado estado) {
        estadoDAO.insertOrUpdate(estado);
    }

    public Estado buscar (int id)
    {
        return estadoDAO.getById(id);
    }

    public List<Estado> listar () {
        return estadoDAO.list();
    }

    public void excluir (int id) {
        estadoDAO.delete(id);
    }
}
