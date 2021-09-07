import view.PessoaView;
import view.EstadoView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int ops;
        do{
            ops =Integer.parseInt(JOptionPane.showInputDialog("1 - Pessoa, 2 - Estado, 3 - Sair"));

            switch (ops) {
                case 1 -> PessoaView.mostrarTela();
                case 2 -> EstadoView.mostrarTela();
                case 3 -> System.exit(0);
                default -> {
                }
            }
        }while(true);
    }
}
