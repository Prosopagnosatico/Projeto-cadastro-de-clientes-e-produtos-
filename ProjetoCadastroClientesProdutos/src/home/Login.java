package home;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {



    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;

    public Login() {

        super("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50)); // Padding

        JLabel titleLabel = new JLabel("Login");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createVerticalStrut(20));

        addInputField(mainPanel, "Email:", emailField = new JTextField(20));
        addInputField(mainPanel, "Senha:", passwordField = new JPasswordField(20));

        mainPanel.add(Box.createVerticalStrut(15));

        loginButton = new JButton("Fazer Login");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setPreferredSize(new Dimension(150, 30));
        loginButton.setMaximumSize(loginButton.getPreferredSize());
        mainPanel.add(loginButton);
        mainPanel.add(Box.createVerticalStrut(15));


        JPanel registerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        registerPanel.add(new JLabel("Não tem uma conta ainda?"));

        registerButton = new JButton("Cadastrar");
        registerPanel.add(registerButton);
        registerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainPanel.add(registerPanel);

        add(mainPanel);
        pack();
        setLocationRelativeTo(null);

        addListeners();
    }

    private void addInputField(JPanel parent, String labelText, JTextComponent field) {

        JPanel fieldPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        fieldPanel.add(new JLabel(labelText));

        field.setPreferredSize(new Dimension(200, 25));
        fieldPanel.add(field);

        fieldPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        parent.add(fieldPanel);
        parent.add(Box.createVerticalStrut(5));
    }

    private void addListeners() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                JOptionPane.showMessageDialog(Login.this,
                        "Tentativa de Login:\nEmail: " + email + "\nSenha: " + password,
                        "Login", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Login.this,
                        "Redirecionando para o Cadastro...",
                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        /*Usar depois quando tiver a tela do arthur
        //Conexao do botao logar para a tela menu
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new telaMenu().setVisible(true);
                dispose();
            }
        });
        */

        //Conexao do botao cadastrar para a tela de cadastro
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new cadastroCliente().setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }
}