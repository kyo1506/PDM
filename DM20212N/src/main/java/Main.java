import view.AlunoView;
import view.EstadoView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int ops = Integer.parseInt(JOptionPane.showInputDialog("1 - Aluno, 2 - Estado, 3 - Sair"));
        switch (ops)
        {
            case 1:
                AlunoView.mostrarTela();
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
