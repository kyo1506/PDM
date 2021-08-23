package view;

import controller.AlunoController;
import controller.EstadoController;
import model.bean.Aluno;

import javax.swing.*;
import java.util.List;

public class AlunoView {
    static AlunoController alunoController = new AlunoController();
    static EstadoController estadoController = new EstadoController();
    public static void mostrarTela() {

        int ops = Integer.parseInt(JOptionPane.showInputDialog("1 - INSERIR, 2 - BUSCAR POR ID, 3 - LISTAR, 4 - ALTERAR, 5 - EXCLUIR"));

        switch (ops)
        {
            case 1:
                inserir();
                break;
            case 2:
                buscar();
                break;
            case 3:
                listar();
                break;
            case 4:
                alterar();
                break;
            case 5:
                excluir();
                break;
            default:
                break;
        }
    }

    static void inserir() {
        String nome = JOptionPane.showInputDialog("NOME");
        int idade = Integer.parseInt(JOptionPane.showInputDialog("IDADE"));
        int estado = Integer.parseInt(JOptionPane.showInputDialog("ESTADO"));
        alunoController.inserir(new Aluno(nome, idade, estadoController.buscar(estado)));
    }

    static void buscar() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Aluno aluno = alunoController.buscar(id);
        JOptionPane.showMessageDialog(null, aluno.toString());
    }

    static void listar() {
        List<Aluno> alunosList = alunoController.listar();
        alunosList.forEach(aluno -> JOptionPane.showMessageDialog(null, aluno.toString()));
    }

    static void alterar() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Aluno aluno = alunoController.buscar(id);

        String nome = JOptionPane.showInputDialog("NOME", aluno.getNome());
        int idade = Integer.parseInt(JOptionPane.showInputDialog("IDADE", aluno.getIdade()));
        String estado = JOptionPane.showInputDialog("ESTADO", aluno.getEstado());

        aluno.setNome(nome);
        aluno.setIdade(idade);

        alunoController.inserir(aluno);
    }

    static void excluir() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        alunoController.excluir(id);
    }
}
