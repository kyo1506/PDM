package controller;

import model.bean.Aluno;
import model.dao.AlunoDAO;

import java.util.List;

public class AlunoController {
    AlunoDAO alunoDAO = new AlunoDAO();

    public void inserir (Aluno aluno) {
        alunoDAO.insertOrUpdate(aluno);
    }

    public Aluno buscar (int id)
    {
        return alunoDAO.getById(id);
    }

    public List<Aluno> listar () {
        return alunoDAO.list();
    }

    public void excluir (int id) {
        alunoDAO.delete(id);
    }
}
