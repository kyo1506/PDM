package Controller;

import Model.Bean.Pessoa;
import Model.DAO.PessoaDAO;

import java.util.List;

public class PessoaController {
    PessoaDAO pesDao = new PessoaDAO();

    public void inserir (Pessoa p) {
        pesDao.insert(p);
    }

    public Pessoa buscar (int id)
    {
        return pesDao.getById(id);
    }

    public List<Pessoa> listar () {
        return pesDao.list();
    }

    public void alterar (Pessoa p) {
        pesDao.update(p);
    }

    public void excluir (int id) {
        pesDao.delete(id);
    }
}
