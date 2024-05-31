package somativa.telas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class Login extends JFrame {

    private JTextField userField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;
    private JLabel messageLabel;

    public Login() {
        setTitle("Tela de Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        userField = new JTextField(15);
        passwordField = new JPasswordField(15);
        loginButton = new JButton("Login");
        registerButton = new JButton("Cadastrar");
        messageLabel = new JLabel();

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Usuário:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(userField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Senha:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(loginButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(registerButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(messageLabel, gbc);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText().trim();
                String password = new String(passwordField.getPassword()).trim();

                System.out.println("Username: " + username); // Debugging
                System.out.println("Password: " + password); // Debugging

                try {
                    Scanner scanner = new Scanner(new File("users.txt"));
                    boolean found = false;
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine().trim();
                        System.out.println("Line from file: " + line); // Debugging
                        String[] parts = line.split(",");
                        if (parts.length == 2 && parts[0].trim().equals(username) && parts[1].trim().equals(password)) {
                            messageLabel.setText("Login bem-sucedido!");
                            Principal();
                            found = true;
                            break;
                        }
                    }
                    scanner.close();
                    if (!found) {
                        messageLabel.setText("Usuário ou senha incorretos.");
                    }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                    messageLabel.setText("Arquivo de usuários não encontrado.");
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Register().setVisible(true);
            }
        });
    }


    private void Principal() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Principal().setVisible(true);
            }
        });
        dispose(); // Fecha a tela de login atual
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
}