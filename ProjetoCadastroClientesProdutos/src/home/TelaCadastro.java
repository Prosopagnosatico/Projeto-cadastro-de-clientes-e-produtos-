package home;

import javax.swing.*;
import java.awt.*;

public class TelaCadastro extends JFrame {

    public TelaCadastro() {
        super("Tela de Cadastro Usuário");
        setSize(550, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6, 6, 6, 6);
        c.fill = GridBagConstraints.HORIZONTAL;

        // ============================
        // TÍTULO
        // ============================
        JLabel titulo = new JLabel("Cadastro de Usuário");
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 4;
        panel.add(titulo, c);

        c.gridwidth = 1;

        // ============================
        // NOME
        // ============================
        c.gridy++;
        c.gridx = 0;
        panel.add(new JLabel("Nome:"), c);

        JTextField campoNome = new JTextField(20);
        c.gridx = 1;
        c.gridwidth = 3;
        panel.add(campoNome, c);
        c.gridwidth = 1;

        // ============================
        // CPF / CNPJ
        // ============================
        c.gridy++;
        c.gridx = 0;
        panel.add(new JLabel("CPF / CNPJ:"), c);

        JTextField campoCpfCnpj = new JTextField(15);
        c.gridx = 1;
        panel.add(campoCpfCnpj, c);

        JCheckBox cbCpf = new JCheckBox("CPF");
        JCheckBox cbCnpj = new JCheckBox("CNPJ");

        ButtonGroup grupoDoc = new ButtonGroup();
        grupoDoc.add(cbCpf);
        grupoDoc.add(cbCnpj);

        c.gridx = 2;
        panel.add(cbCpf, c);

        c.gridx = 3;
        panel.add(cbCnpj, c);

        // ============================
        // DATA DE NASCIMENTO + SEXO
        // ============================
        c.gridy++;
        c.gridx = 0;
        panel.add(new JLabel("Data de nasc:"), c);

        JTextField campoData = new JTextField(10);
        c.gridx = 1;
        panel.add(campoData, c);

        c.gridx = 2;
        panel.add(new JLabel("Sexo:"), c);

        JPanel sexoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        JRadioButton rbMasc = new JRadioButton("M");
        JRadioButton rbFem = new JRadioButton("F");
        JRadioButton rbOutro = new JRadioButton("Outros");

        ButtonGroup grupoSexo = new ButtonGroup();
        grupoSexo.add(rbMasc);
        grupoSexo.add(rbFem);
        grupoSexo.add(rbOutro);

        sexoPanel.add(rbMasc);
        sexoPanel.add(rbFem);
        sexoPanel.add(rbOutro);

        c.gridx = 3;
        panel.add(sexoPanel, c);

        // ============================
        // EMAIL
        // ============================
        c.gridy++;
        c.gridx = 0;
        panel.add(new JLabel("Email:"), c);

        JTextField campoEmail = new JTextField(20);
        c.gridx = 1;
        c.gridwidth = 3;
        panel.add(campoEmail, c);
        c.gridwidth = 1;

        // ============================
        // ESTADO + CIDADE
        // ============================
        c.gridy++;
        c.gridx = 0;
        panel.add(new JLabel("Estado:"), c);

        String[] estados = {
                "Selecione", "AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MT","MS",
                "MG","PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO"
        };
        JComboBox<String> campoEstado = new JComboBox<>(estados);
        c.gridx = 1;
        panel.add(campoEstado, c);

        c.gridx = 2;
        panel.add(new JLabel("Cidade:"), c);

        JTextField campoCidade = new JTextField(10);
        c.gridx = 3;
        panel.add(campoCidade, c);

        // ============================
        // RUA
        // ============================
        c.gridy++;
        c.gridx = 0;
        panel.add(new JLabel("Rua:"), c);

        JTextField campoRua = new JTextField(20);
        c.gridx = 1;
        c.gridwidth = 3;
        panel.add(campoRua, c);
        c.gridwidth = 1;

        // ============================
        // SENHA + CONFIRMAR
        // ============================
        c.gridy++;
        c.gridx = 0;
        panel.add(new JLabel("Senha:"), c);

        JPasswordField campoSenha = new JPasswordField(15);
        c.gridx = 1;
        panel.add(campoSenha, c);

        c.gridx = 2;
        panel.add(new JLabel("Confirmar senha:"), c);

        JPasswordField campoConfSenha = new JPasswordField(15);
        c.gridx = 3;
        panel.add(campoConfSenha, c);

        // ============================
        // BOTÃO Cadastrar-se (CENTRALIZADO)
        // ============================
        JButton btnCadastrar = new JButton("Cadastrar-se");

        c.gridy++;
        c.gridx = 0;
        c.gridwidth = 4;

        JPanel painelCadastrar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelCadastrar.add(btnCadastrar);

        panel.add(painelCadastrar, c);

        c.gridwidth = 1;

        // ============================
        // "Já tem uma conta?" + LOGIN
        // ============================
        JLabel lblConta = new JLabel("Já tem uma conta?");
        JButton btnLogin = new JButton("Login");

        c.gridy++;
        c.gridx = 0;
        panel.add(lblConta, c);

        c.gridx = 1;
        panel.add(btnLogin, c);

        // ============================
        // Botão SAIR
        // ============================
        JButton btnSair = new JButton("Sair");
        c.gridx = 3;
        panel.add(btnSair, c);

        // ============================
        // AÇÕES DOS BOTÕES
        // ============================
        btnCadastrar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                    "Cadastro realizado!",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        btnSair.addActionListener(e -> System.exit(0));

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TelaCadastro::new);
    }
}