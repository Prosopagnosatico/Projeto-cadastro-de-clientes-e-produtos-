package home;

import javax.swing.*;
import java.awt.*;
import cliente.*;
import java.lang.*;
import java.awt.event.*;

public class cadastroCliente extends JFrame {
    private JTextField nomeCliente, emailCliente, idadeCliente, telefoneCliente, identficadorCliente, ruaCliente,
            cidadeCliente, cepCliente;
    private JPasswordField senhaCliente, confirmarSenhaCliente;
    private JComboBox<String> estadoCliente, statusCliente, nivelCliente;
    private JRadioButton cpfCliente, cnpjCliente, femininoCliente, masculinoCliente, outrosCliente;
    private JButton botaocadastrarCliente;

    public cadastroCliente() {

        this.setSize(600, 400);
        setMinimumSize(new Dimension(600, 350));
        this.setLocationRelativeTo((Component) null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Cadastro de cliente");

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

        Cliente cliente = new Cliente();

        JPanel painelGeral = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        painelGeral.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));
        painelGeral.add(barraMenu);

        c.insets = new Insets(4, 8, 4, 8);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.WEST;

        JLabel tituloCliente = new JLabel("Cadastro de cliente");
        tituloCliente.setFont(new Font("Segoe UI", Font.BOLD, 24));
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 4;
        c.insets = new Insets(5, 200, 20, 0);
        painelGeral.add(tituloCliente, c);

        c.gridwidth = 1;
        c.insets = new Insets(6, 8, 6, 8);

        nomeCliente = new JTextField(15);
        emailCliente = new JTextField(15);
        idadeCliente = new JTextField(3);
        senhaCliente = new JPasswordField(15);
        confirmarSenhaCliente = new JPasswordField(15);
        telefoneCliente = new JTextField(15);
        String[] estados = { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB",
                "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" };
        estadoCliente = new JComboBox<>(estados);
        String[] status = { "Ativo", "Inativo" };
        statusCliente = new JComboBox<>(status);
        String[] nivel = { "Normal", "Especial", "VIP" };
        nivelCliente = new JComboBox<>(nivel);
        ruaCliente = new JTextField(15);
        cidadeCliente = new JTextField(15);
        cepCliente = new JTextField(15);

        adicionarComponente(painelGeral, c, 3, "Idade: ", idadeCliente, "Status: ", statusCliente);
        adicionarComponente(painelGeral, c, 4, "Telefone:", telefoneCliente, "Rua: ", ruaCliente);
        adicionarComponente(painelGeral, c, 5, "Cidade:", cidadeCliente, "CEP:", cepCliente);
        adicionarComponente(painelGeral, c, 6, "Nivel", nivelCliente, "Estado: ", estadoCliente);
        adicionarUmComponente(painelGeral, c, 1, "Nome:", nomeCliente);
        adicionarUmComponente(painelGeral, c, 2, "E-mail:", emailCliente);

        JPanel painelIdentificacao = new JPanel();
        cpfCliente = new JRadioButton("CPF");
        cnpjCliente = new JRadioButton("CNPJ");
        ButtonGroup grupoIdentificacao = new ButtonGroup();
        grupoIdentificacao.add(cpfCliente);
        grupoIdentificacao.add(cnpjCliente);
        painelIdentificacao.add(cpfCliente);
        painelIdentificacao.add(cnpjCliente);

        JPanel painelGenero = new JPanel();
        masculinoCliente = new JRadioButton("Masculino");
        femininoCliente = new JRadioButton("Feminino");
        outrosCliente = new JRadioButton("outros");
        ButtonGroup grupoGenero = new ButtonGroup();
        grupoGenero.add(masculinoCliente);
        grupoGenero.add(femininoCliente);
        grupoGenero.add(outrosCliente);
        painelGenero.add(masculinoCliente);
        painelGenero.add(femininoCliente);
        painelGenero.add(outrosCliente);
        componenteLabel(painelGeral, c, 7, "Genero: ", "Tipo de identificação: ");
        componenteCampo(painelGeral, c, 8, painelGenero, painelIdentificacao);

        JPanel painelBotoes = new JPanel();
        botaocadastrarCliente = new JButton("Cadastrar");
        botaocadastrarCliente.setBackground(new Color(52, 152, 219)); // azul
        botaocadastrarCliente.setForeground(Color.WHITE);
        botaocadastrarCliente.setPreferredSize(new Dimension(150, 30));

        c.gridx = 0;
        c.gridy = 9;
        painelBotoes.add(botaocadastrarCliente);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(painelBotoes, BorderLayout.SOUTH);

        botaocadastrarCliente.addActionListener(e -> cadastrarCliente());

        add(painelGeral);

        pack();
        setVisible(true);

    }

    public void adicionarComponente(JPanel painelGeral, GridBagConstraints c, int linha, String lableText,
            JComponent campo, String labelText2, JComponent campo2) {
        c.gridx = 0;
        c.gridy = linha;
        c.weightx = 0;
        painelGeral.add(new JLabel(lableText), c);

        c.gridx = 1;
        c.weightx = 2.5;
        painelGeral.add(campo, c);

        c.gridx = 2;
        c.weightx = 0;
        painelGeral.add(new JLabel(labelText2), c);

        c.gridx = 3;
        c.gridy = linha;
        c.weightx = 2;
        painelGeral.add(campo2, c);
    }

    public void componenteLabel(JPanel painelgeral, GridBagConstraints c, int linha, String lableText,
            String lableText2) {
        c.gridx = 0;
        c.gridy = linha;
        c.weightx = 0.1;
        painelgeral.add(new JLabel(lableText), c);

        c.gridx = 2;
        painelgeral.add(new JLabel(lableText2), c);
    }

    public void componenteCampo(JPanel painelgeral, GridBagConstraints c, int linha, JComponent campo,
            JComponent campo2) {
        c.gridx = 0;
        c.gridy = linha;
        c.weightx = 0.5;
        painelgeral.add(campo, c);

        c.gridx = 2;
        painelgeral.add(campo2, c);
    }

    public void adicionarUmComponente(JPanel painelProduto, GridBagConstraints c, int linha, String labelText,
            JComponent campo) {
        c.gridx = 0;

        c.gridy = linha;
        c.weightx = 0.1;
        painelProduto.add(new JLabel(labelText), c);

        c.gridx = 1;
        c.gridy = linha;
        c.weightx = 0.5;
        c.gridwidth = 3;
        painelProduto.add(campo, c);
    }

    public void cadastrarCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome(nomeCliente.getText());
        cliente.setEmail(emailCliente.getText());
        cliente.setIdade(Integer.parseInt(idadeCliente.getText()));
        cliente.setTelefone(telefoneCliente.getText());
        cliente.setEstado2((String) estadoCliente.getSelectedItem());
        cliente.setRua(ruaCliente.getText());
        cliente.setCidade(cidadeCliente.getText());
        cliente.setCep(cepCliente.getText());
        cliente.setNivel((String) nivelCliente.getSelectedItem());
        cliente.setStatus((String) statusCliente.getSelectedItem());

        String generos = "";
        if (masculinoCliente.isSelected()) {
            generos = "Masculino";
            cliente.setGen(generos);
        } else if (femininoCliente.isSelected()) {
            generos = "Feminino";
            cliente.setGen(generos);
        } else if (outrosCliente.isSelected()) {
            generos = "Outros";
            cliente.setGen(generos);
        }

        String tipoA = "";
        if (cpfCliente.isSelected()) {
            tipoA = "CPF";
        } else if (cnpjCliente.isSelected()) {
            tipoA = "CNPJ";
        }
        cliente.setTipo(tipoA);

        if (cpfCliente.isSelected()) {
            String cpf = JOptionPane.showInputDialog(this, "Digite seu CPF:");
            cliente.setIdentificador(cpf);
        } else if (cnpjCliente.isSelected()) {
            String cnpj = JOptionPane.showInputDialog(this, "Digite seu CNPJ:");
            cliente.setIdentificador(cnpj);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um valor valido");
        }

        GerenciaCliente gerenciaCliente = new GerenciaCliente();

        gerenciaCliente.criarCliente(cliente);

        JOptionPane.showMessageDialog(this,
                "Cliente cadastrado \n" +
                        "nome: " + cliente.getNome() + "\n" +
                        "email: " + cliente.getEmail() + "\n" +
                        "idade: " + cliente.getIdade() + "\n" +
                        "telefone: " + cliente.getTelefone() + "\n" +
                        "estado: " + cliente.getEstado2() + "\n" +
                        "genero: " + cliente.getGen() + "\n" +
                        "tipo: " + cliente.getTipo() + "\n" +
                        "identificador: " + cliente.getIdentificador() + "\n" +
                        cliente.getStatus());
    }

    public static void main(String[] args) {
        new cadastroCliente();
    }
}
