import View.Pessoa.ManterPessoa;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int ops = Integer.parseInt(JOptionPane.showInputDialog("1 - Pessoa, 2 - Pet, 3 - PessoaPet"));
        if (ops == 1) ManterPessoa.mostrarTela();
    }
}
