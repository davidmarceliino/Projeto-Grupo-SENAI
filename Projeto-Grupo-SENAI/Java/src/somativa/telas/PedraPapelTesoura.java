package somativa.telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PedraPapelTesoura extends JFrame {
    private Resultados resultadosFrame;
    private int vitoriasJogador = 0;
    private int vitoriasComputador = 0;
    private int empates = 0;

    public PedraPapelTesoura(Resultados resultadosFrame) {
        this.resultadosFrame = resultadosFrame;

        setTitle("Pedra, Papel, Tesoura");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 1));

        JLabel titulo = new JLabel("Escolha: Pedra, Papel ou Tesoura", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));

        JButton pedraButton = new JButton("Pedra");
        JButton papelButton = new JButton("Papel");
        JButton tesouraButton = new JButton("Tesoura");
        JButton voltarButton = new JButton("Voltar");

        pedraButton.setFont(new Font("Arial", Font.PLAIN, 14));
        papelButton.setFont(new Font("Arial", Font.PLAIN, 14));
        tesouraButton.setFont(new Font("Arial", Font.PLAIN, 14));
        voltarButton.setFont(new Font("Arial", Font.PLAIN, 14));

        pedraButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jogar("Pedra");
            }
        });

        papelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jogar("Papel");
            }
        });

        tesouraButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jogar("Tesoura");
            }
        });

        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a janela do jogo e volta para o principal
            }
        });

        panel.add(titulo);
        panel.add(pedraButton);
        panel.add(papelButton);
        panel.add(tesouraButton);
        panel.add(voltarButton);

        add(panel);
    }

    private void jogar(String escolhaJogador) {
        String escolhaComputador = gerarEscolhaComputador();
        String resultado;

        if (escolhaJogador.equals(escolhaComputador)) {
            empates++;
            resultado = "Empate!";
        } else if ((escolhaJogador.equals("Pedra") && escolhaComputador.equals("Tesoura")) ||
                   (escolhaJogador.equals("Papel") && escolhaComputador.equals("Pedra")) ||
                   (escolhaJogador.equals("Tesoura") && escolhaComputador.equals("Papel"))) {
            vitoriasJogador++;
            resultado = "Você venceu!";
        } else {
            vitoriasComputador++;
            resultado = "Computador venceu!";
        }

        // Atualiza os resultados na classe Resultados
        if (resultadosFrame != null) {
            resultadosFrame.atualizarResultados(vitoriasJogador, vitoriasComputador, empates);
        }

        // Exibe o resultado
        JOptionPane.showMessageDialog(this,
                "Sua escolha: " + escolhaJogador + "\nEscolha do computador: " + escolhaComputador + "\n" + resultado,
                "Resultado",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private String gerarEscolhaComputador() {
        // Gera uma escolha aleatória para o computador
        int numeroAleatorio = (int) (Math.random() * 3);
        switch (numeroAleatorio) {
            case 0:
                return "Pedra";
            case 1:
                return "Papel";
            default:
                return "Tesoura";
        }
    }
}
