package somativa.telas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Register extends JFrame {

    private JTextField newUserField;
    private JPasswordField newPasswordField;
    private JButton registerButton;

    public Register() {
        setTitle("Cadastro");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        newUserField = new JTextField(15);
        newPasswordField = new JPasswordField(15);
        registerButton = new JButton("Cadastrar");

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Novo Usuário:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(newUserField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Nova Senha:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(newPasswordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(registerButton, gbc);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newUser = newUserField.getText().trim();
                String newPassword = new String(newPasswordField.getPassword()).trim();

                if (!newUser.isEmpty() && !newPassword.isEmpty()) {
                    try {
                        BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true));
                        writer.write(newUser + "," + newPassword);
                        writer.newLine();
                        writer.close();
                        JOptionPane.showMessageDialog(Register.this, "Usuário cadastrado com sucesso!");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(Register.this, "Erro ao cadastrar usuário.");
                    }
                } else {
                    JOptionPane.showMessageDialog(Register.this, "Por favor, insira um nome de usuário e senha.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Register().setVisible(true);
            }
        });
    }
}
