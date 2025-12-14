package home;
import javax.swing.*;
import java.awt.*;

public class TelaPerfil extends JFrame {

    private JTextField txtNome, txtDataNasc, txtTelefone, txtCPF, txtGenero;
    private JTextField txtEstado, txtCidade, txtRua, txtNumero;
    private JTextField txtEmail, txtStatus, txtNivel;
    private JTextArea txtObservacoes;

    public TelaPerfil() {
        super("Perfil do Cliente");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

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

        JPanel topo = new JPanel(new BorderLayout());
        topo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBackground(new Color(52, 152, 219));
        btnVoltar.setForeground(Color.WHITE);

        btnVoltar.setPreferredSize(new Dimension(80, 35));
        btnVoltar.addActionListener(e -> dispose());

        JButton btnPerfil = new JButton("👤");
        btnPerfil.setBackground(new Color(52, 152, 219));
        btnPerfil.setForeground(Color.WHITE);
        btnPerfil.setPreferredSize(new Dimension(60, 35));
        btnPerfil.setFocusable(false);

        topo.add(btnVoltar, BorderLayout.WEST);
        topo.add(btnPerfil, BorderLayout.EAST);

        add(topo, BorderLayout.NORTH);

        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        painel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JPanel linha1 = new JPanel(new GridLayout(1, 2, 20, 0));
        txtNome = criarCampo("Nome");

        txtDataNasc = criarCampo("Data de Nascimento");
        linha1.add(txtNome);
        linha1.add(txtDataNasc);
        painel.add(linha1);
        painel.add(Box.createVerticalStrut(10));

        JPanel linha2 = new JPanel(new GridLayout(1, 3, 20, 0));
        txtTelefone = criarCampo("Telefone");
        txtCPF = criarCampo("CPF");
        txtGenero = criarCampo("Gênero");
        linha2.add(txtTelefone);
        linha2.add(txtCPF);
        linha2.add(txtGenero);
        painel.add(linha2);
        painel.add(Box.createVerticalStrut(10));

        JPanel linha3 = new JPanel(new GridLayout(1, 4, 20, 0));
        txtEstado = criarCampo("Estado");
        txtCidade = criarCampo("Cidade");
        txtRua = criarCampo("Rua");
        txtNumero = criarCampo("Número");
        linha3.add(txtEstado);
        linha3.add(txtCidade);
        linha3.add(txtRua);
        linha3.add(txtNumero);
        painel.add(linha3);
        painel.add(Box.createVerticalStrut(10));

        JPanel linha4 = new JPanel(new GridLayout(1, 3, 20, 0));
        txtEmail = criarCampo("Email");
        txtStatus = criarCampo("Status");
        txtNivel = criarCampo("Nível");
        linha4.add(txtEmail);
        linha4.add(txtStatus);
        linha4.add(txtNivel);
        painel.add(linha4);
        painel.add(Box.createVerticalStrut(15));

        JPanel blocoObs = new JPanel(new BorderLayout(15, 0));

        txtObservacoes = new JTextArea();
        txtObservacoes.setBorder(BorderFactory.createTitledBorder("Observações"));
        txtObservacoes.setEditable(false);
        txtObservacoes.setLineWrap(true);
        txtObservacoes.setWrapStyleWord(true);

        JScrollPane scrollObs = new JScrollPane(txtObservacoes);
        scrollObs.setPreferredSize(new Dimension(450, 180));

        blocoObs.add(scrollObs, BorderLayout.CENTER);

        JPanel lateral = new JPanel();
        lateral.setLayout(new BoxLayout(lateral, BoxLayout.Y_AXIS));

        JButton btnCompras = new JButton("Compras");
        btnCompras.setBackground(new Color(52, 152, 219));
        btnCompras.setForeground(Color.WHITE);
        btnCompras.setPreferredSize(new Dimension(180, 40));
        btnCompras.addActionListener(e ->
                System.out.println("Tela de compras ainda será criada."));

        JButton btnRegistro = new JButton("Registro de alterações");
        btnRegistro.setBackground(new Color(52, 152, 219));
        btnRegistro.setForeground(Color.WHITE);
        btnRegistro.setPreferredSize(new Dimension(180, 40));
        btnRegistro.addActionListener(e ->
                System.out.println("Tela de registro será criada futuramente."));

         txtNome.setEnabled(false);
        txtCPF.setEnabled(false);
        txtCidade.setEnabled(false);
        txtDataNasc.setEnabled(false);
        txtEmail.setEnabled(false);
        txtEstado.setEnabled(false);
        txtGenero.setEnabled(false);
        txtNivel.setEnabled(false);
        txtNumero.setEnabled(false);
        txtObservacoes.setEnabled(false);
        txtRua.setEnabled(false);
        txtStatus.setEnabled(false);
        txtTelefone.setEnabled(false);

        lateral.add(btnCompras);
        lateral.add(Box.createVerticalStrut(15));
        lateral.add(btnRegistro);

        blocoObs.add(lateral, BorderLayout.EAST);
        painel.add(blocoObs);
        painel.add(Box.createVerticalStrut(20));

        add(painel, BorderLayout.CENTER);

        JPanel rodape = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setPreferredSize(new Dimension(150, 40));

        JButton btnInativar = new JButton("Inativar");
        btnInativar.setPreferredSize(new Dimension(150, 40));

        JButton btnEditar = new JButton("Editar");
        btnEditar.setPreferredSize(new Dimension(150, 40));
        btnEditar.addActionListener(e -> {
            System.out.println("Tela de edição será criada futuramente.");
        });

        rodape.add(btnExcluir);
        rodape.add(btnInativar);
        rodape.add(btnEditar);

        add(rodape, BorderLayout.SOUTH);

        setVisible(true);
    }

    private JTextField criarCampo(String titulo) {
        JTextField campo = new JTextField();
        campo.setBorder(BorderFactory.createTitledBorder(titulo));
        campo.setEditable(false);
        campo.setPreferredSize(new Dimension(200, 60));
        return campo;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TelaPerfil::new);
    }
}