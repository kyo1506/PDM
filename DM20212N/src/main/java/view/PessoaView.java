package view;

import controller.PessoaController;
import controller.EstadoController;
import model.bean.Pessoa;
import model.bean.Estado;

import javax.swing.*;

public class PessoaView {
    static PessoaController pessoaController = new PessoaController();
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
        Long estado = Long.parseLong(JOptionPane.showInputDialog("ESTADO"));
        pessoaController.inserir(new Pessoa(nome, idade, estadoController.buscar(estado)));
        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
    }

    static void buscar() {
        Long id = Long.parseLong(JOptionPane.showInputDialog("ID"));
        JOptionPane.showMessageDialog(null, pessoaController.buscar(id));
    }

    static void listar() {
        JOptionPane.showMessageDialog(null, pessoaController.listar());
    }

    static void alterar() {
        Long id = Long.parseLong(JOptionPane.showInputDialog("ID"));
        Pessoa pessoa = pessoaController.buscar(id);

        String nome = JOptionPane.showInputDialog("NOME", pessoa.getNome());
        int idade = Integer.parseInt(JOptionPane.showInputDialog("IDADE", pessoa.getIdade()));
        Long estado = Long.parseLong(JOptionPane.showInputDialog("ESTADO", pessoa.getEstado().getId()));

        Estado buscarEstado = estadoController.buscar(estado);

        pessoa.setNome(nome);
        pessoa.setIdade(idade);
        pessoa.setEstado(buscarEstado);

        pessoaController.inserir(pessoa);

        JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
    }

    static void excluir() {
        Long id = Long.parseLong(JOptionPane.showInputDialog("ID"));
        try{
            pessoaController.excluir(id);
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "ID da pessoa informado não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
