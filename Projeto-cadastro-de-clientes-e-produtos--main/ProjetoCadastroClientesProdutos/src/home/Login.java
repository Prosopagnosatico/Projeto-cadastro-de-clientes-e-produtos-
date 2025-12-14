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
        JMenuBar barraMenu = new JMenuBar();

        JMenu menuInicio = new JMenu("Inicio");
        JMenuItem itemCadastroCliente = new JMenuItem("Cadastro de cliente");
        JMenuItem itemCadastroProduto = new JMenuItem("Cadastro de produto");
        JMenuItem itemLogar = new JMenuItem("Logar");
        JMenuItem itemInicio = new JMenuItem("Inicio");
        JMenuItem itemClientes = new JMenuItem("Ver clientes");
       JMenuItem itemEditarClientes = new JMenuItem("Clientes e produtos ");

        menuInicio.add(itemInicio);
        menuInicio.add(itemCadastroCliente);
        menuInicio.add(itemLogar);
        menuInicio.add(itemEditarClientes);
        menuInicio.add(itemClientes);
        menuInicio.add(itemCadastroProduto);
        barraMenu.add(menuInicio);
        
         itemCadastroCliente.addActionListener(e -> {
            new cadastroCliente().setVisible(true);
            dispose();
        });

        itemCadastroProduto.addActionListener(e -> {
            new cadastroProduto().setVisible(true);
            dispose();
        });

        itemLogar.addActionListener(e -> {
            new Login().setVisible(true);
            dispose();
        });

        itemInicio.addActionListener(e -> {
            new Inicio().setVisible(true);
            dispose();
        });

        itemClientes.addActionListener(e -> {
            new TelaPerfil().setVisible(true);
            dispose();
        });

        itemEditarClientes.addActionListener(e -> {
            new TelaMenu().setVisible(true);
            dispose();
        });
        setJMenuBar(barraMenu);
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
        loginButton.setBackground(new Color(52, 152, 219));
        loginButton.setForeground(Color.WHITE);
        loginButton.setPreferredSize(new Dimension(150, 30));
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setPreferredSize(new Dimension(150, 30));
        loginButton.setMaximumSize(loginButton.getPreferredSize());
        mainPanel.add(loginButton);
        mainPanel.add(Box.createVerticalStrut(15));


        JPanel registerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        registerPanel.add(new JLabel("Não tem uma conta ainda?"));

        registerButton = new JButton("Cadastrar");
        registerButton.setBackground(new Color(52, 152, 219));
        registerButton.setForeground(Color.WHITE);
        registerButton.setPreferredSize(new Dimension(100, 30));
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

        //Conexao do botao logar para a tela menu
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaMenu().setVisible(true);
                dispose();
            }
        });
        

        //Conexao do botao cadastrar para a tela de cadastro
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaCadastro().setVisible(true);
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