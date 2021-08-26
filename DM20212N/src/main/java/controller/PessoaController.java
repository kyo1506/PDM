package controller;

import model.bean.Pessoa;
import model.dao.PessoaDAO;

import java.util.List;

public class PessoaController {
    PessoaDAO pessoaDAO = new PessoaDAO();

    public void inserir (Pessoa pessoa) {
        pessoaDAO.insertOrUpdate(pessoa);
    }

    public Pessoa buscar (Long id)
    {
        return pessoaDAO.getById(id);
    }

    public List<Pessoa> listar () {
        return pessoaDAO.list();
    }

    public void excluir (Long id) {
        pessoaDAO.delete(id);
    }
}
