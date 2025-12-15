package home;

import usuario.*;

import javax.swing.*;
import java.awt.*;

public class TelaCadastro extends JFrame {

    private JTextField campoNome, campoIdade, campoEmail, campoCpfCnpj, campoCidade, campoRua, campoTelefone;
    private JPasswordField campoSenha, campoConfSenha;
    private JComboBox<String> campoEstado;
    private JButton btnCadastrar;
    private JCheckBox cbCpf, cbCnpj;
    private JRadioButton rbMasc, rbFem, rbOutro;

    public TelaCadastro() {
        super("Tela de Cadastro Usuário");
        setSize(550, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6, 6, 6, 6);
        c.fill = GridBagConstraints.HORIZONTAL;

        JMenuBar barraMenu = new JMenuBar();

        JMenu menuInicio = new JMenu("Inicio");
        JMenuItem itemInicio = new JMenuItem("Inicio");
        JMenuItem itemCadastroUsuario = new JMenuItem("Cadastrar-se");
        JMenuItem itemLogar = new JMenuItem("Logar");
        JMenuItem itemCadastroCliente = new JMenuItem("Cadastro de cliente");
        JMenuItem itemCadastroProduto = new JMenuItem("Cadastro de produto");
        JMenuItem itemClientes = new JMenuItem("Menu clientes");

        menuInicio.add(itemInicio);
        menuInicio.add(itemCadastroUsuario);
        menuInicio.add(itemCadastroCliente);
        menuInicio.add(itemLogar);
        menuInicio.add(itemClientes);
        menuInicio.add(itemCadastroProduto);
        barraMenu.add(menuInicio);

        itemCadastroCliente.addActionListener(e ->{
            new TelaCadastro();
        });

        itemCadastroCliente.addActionListener(e -> {
            new cadastroCliente();
        });

        itemCadastroProduto.addActionListener(e -> {
            new cadastroProduto();
        });

        itemLogar.addActionListener(e -> {
            new Login().setVisible(true);;
        });

        itemInicio.addActionListener(e -> {
            new Inicio();
        });

        itemClientes.addActionListener(e -> {
            new TelaMenu();
        });

        setJMenuBar(barraMenu);

        JLabel titulo = new JLabel("Cadastro de Usuário");
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 4;
        panel.add(titulo, c);

        c.gridwidth = 1;

        c.gridy++;
        c.gridx = 0;
        panel.add(new JLabel("Nome:"), c);

        campoNome = new JTextField(20);
        c.gridx = 1;
        c.gridwidth = 3;
        panel.add(campoNome, c);
        c.gridwidth = 1;

        c.gridy++;
        c.gridx = 0;
        panel.add(new JLabel("CPF / CNPJ:"), c);

        campoCpfCnpj = new JTextField(15);
        c.gridx = 1;
        panel.add(campoCpfCnpj, c);

        cbCpf = new JCheckBox("CPF");
        cbCnpj = new JCheckBox("CNPJ");

        ButtonGroup grupoDoc = new ButtonGroup();
        grupoDoc.add(cbCpf);
        grupoDoc.add(cbCnpj);

        c.gridx = 2;
        panel.add(cbCpf, c);

        c.gridx = 3;
        panel.add(cbCnpj, c);

        c.gridy++;
        c.gridx = 0;
        panel.add(new JLabel("Idade:"), c);

        campoIdade = new JTextField(10);
        c.gridx = 1;
        panel.add(campoIdade, c);

        c.gridx = 2;
        panel.add(new JLabel("Sexo:"), c);

        JPanel sexoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
         rbMasc = new JRadioButton("M");
         rbFem = new JRadioButton("F");
         rbOutro = new JRadioButton("Outros");

        ButtonGroup grupoSexo = new ButtonGroup();
        grupoSexo.add(rbMasc);
        grupoSexo.add(rbFem);
        grupoSexo.add(rbOutro);

        sexoPanel.add(rbMasc);
        sexoPanel.add(rbFem);
        sexoPanel.add(rbOutro);

        c.gridx = 3;
        panel.add(sexoPanel, c);

        c.gridy++;
        c.gridx = 0;
        panel.add(new JLabel("Email:"), c);

        campoEmail = new JTextField(20);
        c.gridx = 1;
        c.gridwidth = 3;
        panel.add(campoEmail, c);
        c.gridwidth = 1;

        c.gridy++;
        c.gridx = 0;
        panel.add(new JLabel("Estado:"), c);

        String[] estados = {
                "AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MT","MS",
                "MG","PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO"
        };
        campoEstado = new JComboBox<>(estados);
        c.gridx = 1;
        panel.add(campoEstado, c);

        c.gridx = 2;
        panel.add(new JLabel("Cidade:"), c);

        campoCidade = new JTextField(10);
        c.gridx = 3;
        panel.add(campoCidade, c);

        c.gridy++;
        c.gridx = 0;
        panel.add(new JLabel("Rua:"), c);

        campoRua = new JTextField(20);
        c.gridx = 1;
        c.gridwidth = 3;
        panel.add(campoRua, c);
        c.gridwidth = 1;

        c.gridy++;
        c.gridx = 0;
        panel.add(new JLabel("Senha:"), c);

        campoSenha = new JPasswordField(15);
        c.gridx = 1;
        panel.add(campoSenha, c);

        c.gridx = 2;
        panel.add(new JLabel("Confirmar senha:"), c);

        campoConfSenha = new JPasswordField(15);
        c.gridx = 3;
        panel.add(campoConfSenha, c);

        c.gridx = 0;
        c.gridy++;
        panel.add(new JLabel("Telefone:"), c);
        c.gridx = 1;
        c.gridwidth = 4;
        campoTelefone = new JTextField(15);
        panel.add(campoTelefone, c);

        btnCadastrar = new JButton("Cadastrar-se");

        c.gridy++;
        c.gridx = 0;
        c.gridwidth = 4;

        JPanel painelCadastrar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelCadastrar.add(btnCadastrar);

        panel.add(painelCadastrar, c);

        c.gridwidth = 1;

        JLabel lblConta = new JLabel("Já tem uma conta?");
        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(e -> logar());

        c.gridy++;
        c.gridx = 0;
        panel.add(lblConta, c);

        c.gridx = 1;
        panel.add(btnLogin, c);

        JButton btnSair = new JButton("Sair");
        c.gridx = 3;
        panel.add(btnSair, c);

        btnCadastrar.addActionListener(e -> cadastrarUsuario());

        btnSair.addActionListener(e -> System.exit(0));

        add(panel);
        setVisible(true);
    }

    //campoNome, campoData, campoEmail, campoCpfCnpj, campoCidade, campoRua;
    public void cadastrarUsuario(){
        Usuario usuario = new Usuario();
        usuario.setNome(campoNome.getText());
        usuario.setIdade(Integer.parseInt(campoIdade.getText()));
        usuario.setEmail(campoEmail.getText());
        usuario.setCidade(campoCidade.getText());
        usuario.setRua(campoRua.getText());
        usuario.setEstado2((String) campoEstado.getSelectedItem());
        usuario.setIdentificador(campoCpfCnpj.getText());
        usuario.setTelefone(campoTelefone.getText());
        String senha = new String(campoSenha.getPassword());
        usuario.setSenha1(senha);


        String generos = "";
        if (rbMasc.isSelected()) {
            generos = "Masculino";
            usuario.setGen(generos);
        } else if (rbFem.isSelected()) {
            generos = "Feminino";
            usuario.setGen(generos);
        } else if (rbOutro.isSelected()) {
            generos = "Outros";
            usuario.setGen(generos);
        }

        GerenciaUsuario gerenciaUsuario = new GerenciaUsuario();
        gerenciaUsuario.cadastro(usuario);

        new TelaMenu().setVisible(true);
        dispose();
    }

    public void logar(){
        new Login().setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TelaCadastro::new);
    }
}

