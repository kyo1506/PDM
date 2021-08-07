package View.Pessoa;

import Controller.PessoaController;
import Model.Bean.Pessoa;

import javax.swing.*;
import java.util.List;

public class ManterPessoa {
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
        float altura = Float.parseFloat(JOptionPane.showInputDialog("ALTURA"));
        String genero = JOptionPane.showInputDialog("GENERO");
        float peso = Float.parseFloat(JOptionPane.showInputDialog("PESO"));
        Pessoa pesEntrada = new Pessoa(nome, idade, altura, genero, peso);
        PessoaController contPes = new PessoaController();
        contPes.inserir(pesEntrada);
    }

    static void buscar() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        PessoaController contPes = new PessoaController();
        Pessoa pesSaida = contPes.buscar(id);
        JOptionPane.showMessageDialog(null,"Pessoa = " + pesSaida.toString());
    }

    static void listar() {
        PessoaController contPes = new PessoaController();
        List<Pessoa> listaP = contPes.listar();
        listaP.forEach(pesL -> JOptionPane.showMessageDialog(null, pesL.toString()));
    }

    static void alterar() {
        PessoaController contPes = new PessoaController();
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Pessoa pesSaida = contPes.buscar(id);

        String nome = JOptionPane.showInputDialog("NOME", pesSaida.getNome());
        int idade = Integer.parseInt(JOptionPane.showInputDialog("IDADE", pesSaida.getIdade()));
        float altura = Float.parseFloat(JOptionPane.showInputDialog("ALTURA", pesSaida.getAltura()));
        String genero = JOptionPane.showInputDialog("GENERO", pesSaida.getGenero());
        float peso = Float.parseFloat(JOptionPane.showInputDialog("PESO", pesSaida.getPeso()));

        pesSaida.setNome(nome);
        pesSaida.setIdade(idade);
        pesSaida.setAltura(altura);
        pesSaida.setGenero(genero);
        pesSaida.setPeso(peso);

        contPes.alterar(pesSaida);
    }

    static void excluir() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        PessoaController contPes = new PessoaController();
        contPes.excluir(id);
    }
}
