import view.PessoaView;
import view.EstadoView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int ops = Integer.parseInt(JOptionPane.showInputDialog("1 - Pessoa, 2 - Estado, 3 - Sair"));
        switch (ops)
        {
            case 1:
                PessoaView.mostrarTela();
                break;
            case 2:
                EstadoView.mostrarTela();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                break;
        }
    }
}
