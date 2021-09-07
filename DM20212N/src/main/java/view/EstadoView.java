package view;

import controller.EstadoController;
import model.bean.Estado;

import javax.swing.*;
import java.util.List;

public class EstadoView {
    static EstadoController estadoController = new EstadoController();
    public static void mostrarTela() {

        int ops = Integer.parseInt(JOptionPane.showInputDialog("1 - INSERIR, 2 - BUSCAR POR ID, 3 - LISTAR, 4 - ALTERAR, 5 - EXCLUIR, 6 - SAIR"));

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
            case 6:
                return;
            default:
                break;
        }
    }

    static void inserir() {
        String nome = JOptionPane.showInputDialog("NOME");
        String sigla = JOptionPane.showInputDialog("SIGLA");
        estadoController.inserir(new Estado(nome, sigla));
        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
    }

    static void buscar() {
        Long id = Long.parseLong(JOptionPane.showInputDialog("ID"));
        JOptionPane.showMessageDialog(null,  estadoController.buscar(id));
    }

    static void listar() {
        JOptionPane.showMessageDialog(null, estadoController.listar());
    }

    static void alterar() {
        Long id = Long.parseLong(JOptionPane.showInputDialog("ID"));
        Estado estado = estadoController.buscar(id);

        String nome = JOptionPane.showInputDialog("NOME", estado.getNome());
        String sigla = JOptionPane.showInputDialog("SIGLA", estado.getSigla());

        estado.setNome(nome);
        estado.setSigla(sigla);

        estadoController.inserir(estado);
    }

    static void excluir() {
        Long id = Long.parseLong(JOptionPane.showInputDialog("ID"));
        try{
            estadoController.excluir(id);
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Id do estado informado não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
