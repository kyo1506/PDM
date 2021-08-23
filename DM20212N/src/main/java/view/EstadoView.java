package view;

import controller.EstadoController;
import model.bean.Estado;

import javax.swing.*;
import java.util.List;

public class EstadoView {
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
        String sigla = JOptionPane.showInputDialog("SIGLA");
        estadoController.inserir(new Estado(nome, sigla));
    }

    static void buscar() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Estado estado = estadoController.buscar(id);
        JOptionPane.showMessageDialog(null, estado.toString());
    }

    static void listar() {
        List<Estado> estadoList = estadoController.listar();
        estadoList.forEach(estado -> JOptionPane.showMessageDialog(null, estado.toString()));
    }

    static void alterar() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Estado estado = estadoController.buscar(id);

        String nome = JOptionPane.showInputDialog("NOME", estado.getNome());
        String sigla = JOptionPane.showInputDialog("SIGLA", estado.getSigla());

        estado.setNome(nome);
        estado.setSigla(sigla);

        estadoController.inserir(estado);
    }

    static void excluir() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        estadoController.excluir(id);
    }
}
