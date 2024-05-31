package somativa.telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Principal extends JFrame {
    private Resultados resultadosFrame;
    private PedraPapelTesoura jogo;

    public Principal() {
        setTitle("Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        resultadosFrame = new Resultados();

        JPanel panel = new JPanel(new GridLayout(3, 1));

        JButton button1 = new JButton("Jogar");
        JButton button2 = new JButton("Ver Resultados");
        JButton button3 = new JButton("Sair");

        // Adicionando ActionListener para cada botão
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Abre o jogo Pedra, Papel e Tesoura
                abrirJogo();
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Abre a janela de resultados
                abrirResultados();
            }
        });

        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Fecha o aplicativo
                System.exit(0);
            }
        });

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);

        add(panel);
    }

    // Método para abrir o jogo Pedra, Papel e Tesoura
    private void abrirJogo() {
        if (jogo == null || !jogo.isVisible()) {
            jogo = new PedraPapelTesoura(resultadosFrame);
            jogo.setVisible(true);
        }
    }

    // Método para abrir a janela de resultados
    private void abrirResultados() {
        if (!resultadosFrame.isVisible()) {
            resultadosFrame.setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
}
