package somativa.telas;


import javax.swing.*;
import java.awt.*;

public class Resultados extends JFrame {
    private JLabel labelVitoriasJogador;
    private JLabel labelVitoriasComputador;
    private JLabel labelEmpates;

    public Resultados() {
        setTitle("Resultados");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        labelVitoriasJogador = new JLabel("Vitórias do jogador: 0");
        labelVitoriasComputador = new JLabel("Vitórias do computador: 0");
        labelEmpates = new JLabel("Empates: 0");

        labelVitoriasJogador.setFont(new Font("Arial", Font.BOLD, 16));
        labelVitoriasComputador.setFont(new Font("Arial", Font.BOLD, 16));
        labelEmpates.setFont(new Font("Arial", Font.BOLD, 16));

        labelVitoriasJogador.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelVitoriasComputador.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelEmpates.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Espaçamento
        panel.add(labelVitoriasJogador);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Espaçamento
        panel.add(labelVitoriasComputador);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Espaçamento
        panel.add(labelEmpates);

        add(panel);
    }

    public void atualizarResultados(int vitoriasJogador, int vitoriasComputador, int empates) {
        labelVitoriasJogador.setText("Vitórias do jogador: " + vitoriasJogador);
        labelVitoriasComputador.setText("Vitórias do computador: " + vitoriasComputador);
        labelEmpates.setText("Empates: " + empates);
    }
}
