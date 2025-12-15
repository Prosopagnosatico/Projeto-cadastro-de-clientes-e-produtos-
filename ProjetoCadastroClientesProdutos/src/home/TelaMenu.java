package home;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.lang.*;
import cliente.*;
import produto.*;

public class TelaMenu extends JFrame {

    private JPanel blocoSelecionado = null;

    private final java.util.List<JPanel> blocosCliente = new ArrayList<>();
    private final java.util.List<JPanel> blocosProduto = new ArrayList<>();

    public TelaMenu() {
        super("Menu do Sistema");
        setSize(850, 680);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel topo = new JPanel(new BorderLayout());
        topo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton btnSair = new JButton("Sair");
        btnSair.setBackground(new Color(52, 152, 219));
        btnSair.setForeground(Color.WHITE);
        btnSair.setPreferredSize(new Dimension(100, 30));
        btnSair.addActionListener(e -> dispose()); // fecha a tela
        topo.add(btnSair, BorderLayout.EAST);

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

        add(topo, BorderLayout.NORTH);

        JTabbedPane abas = new JTabbedPane();
        abas.setFont(new Font("Arial", Font.BOLD, 14));

        abas.addTab("Cliente", criarAbaCliente());
        abas.addTab("Produto", criarAbaProduto());

        add(abas, BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel criarAbaCliente() {

        JPanel painel = new JPanel(new BorderLayout());
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel barraPesquisa = new JPanel(new BorderLayout());

        JTextField txtPesquisa = new JTextField();
        txtPesquisa.setBorder(BorderFactory.createTitledBorder("Pesquisar..."));

        txtPesquisa.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) { filtrarClientes(txtPesquisa.getText()); }
            public void removeUpdate(DocumentEvent e) { filtrarClientes(txtPesquisa.getText()); }
            public void insertUpdate(DocumentEvent e) { filtrarClientes(txtPesquisa.getText()); }
        });

        barraPesquisa.add(txtPesquisa, BorderLayout.CENTER);
        painel.add(barraPesquisa, BorderLayout.NORTH);

        JPanel listaClientes = new JPanel();
        listaClientes.setLayout(new BoxLayout(listaClientes, BoxLayout.Y_AXIS));

        carregarClientes(listaClientes);

        painel.add(new JScrollPane(listaClientes), BorderLayout.CENTER);

        JPanel rodape = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton btnCadastrar = new JButton("Cadastrar Cliente");
        btnCadastrar.setBackground(new Color(52, 152, 219));
        btnCadastrar.setForeground(Color.WHITE);
        btnCadastrar.setPreferredSize(new Dimension(180, 40));
        btnCadastrar.addActionListener(e -> {
            new cadastroCliente();
        });

        JButton btnDuplicados = new JButton("Verificar duplicados");
        btnDuplicados.setBackground(new Color(52, 152, 219));
        btnDuplicados.setForeground(Color.WHITE);
        btnDuplicados.setPreferredSize(new Dimension(180, 40));
        btnDuplicados.addActionListener(e -> verificarDuplicadosClientes());

        rodape.add(btnCadastrar);
        rodape.add(btnDuplicados);

        painel.add(rodape, BorderLayout.SOUTH);

        return painel;
    }

    private JPanel criarBlocoCliente(Cliente cliente,JPanel lista) {

        JPanel bloco = new JPanel();
        bloco.setLayout(new BorderLayout());
        bloco.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        bloco.setBackground(Color.WHITE);
        bloco.setMaximumSize(new Dimension(Integer.MAX_VALUE, 150)); // altura flexível

        bloco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                selecionarBloco(bloco);


            }
        });

        JPanel campos = new JPanel(new GridLayout(3, 1, 5, 5));
        JLabel nome = new JLabel(cliente.getNome());
        nome.setBorder(BorderFactory.createTitledBorder("Nome"));

        JLabel status = new JLabel(cliente.getStatus());
        status.setBorder(BorderFactory.createTitledBorder("Status"));

        JLabel nivel = new JLabel(cliente.getNivel());
        nivel.setBorder(BorderFactory.createTitledBorder("Nível"));

        campos.add(nome);
        campos.add(status);
        campos.add(nivel);

        bloco.add(campos, BorderLayout.CENTER);

        // Botões
        JPanel botoes = new JPanel(new GridLayout(3, 1, 5, 5));
        botoes.setPreferredSize(new Dimension(120, 90));

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.addActionListener(e -> {
            GerenciaCliente gerenciaCliente =   new GerenciaCliente();
            gerenciaCliente.excluir(cliente.getId());

            lista.remove(bloco);
            lista.revalidate();
            lista.repaint();
        });

        JButton btnStatus = new JButton("Mudar status");
         btnStatus.addActionListener(e -> {
             GerenciaCliente gerenciaCliente = new GerenciaCliente();

             String statusAlterar = cliente.getStatus();

             if (statusAlterar.equals("Ativo")) {
                 gerenciaCliente.alterarStatus(cliente.getId(), "Inativo");
                 cliente.setStatus("Inativo");
                 status.setText("Inativo");
             } else if(statusAlterar.equals("Inativo")){
                 gerenciaCliente.alterarStatus(cliente.getId(), "Ativo");
                 cliente.setStatus("Ativo");
                 status.setText("Ativo");
             }

             carregarClientes(lista);
            });


        JButton btnEditar = new JButton("Editar");
        btnEditar.addActionListener(e -> {
            new AlteracaoCliente();
            dispose();
        });

        botoes.add(btnExcluir);
        botoes.add(btnStatus);
        botoes.add(btnEditar);

        bloco.add(botoes, BorderLayout.EAST);

        return bloco;
    }

    private void carregarClientes(JPanel listaClientes){
        GerenciaCliente gerenciaCliente = new GerenciaCliente();
        java.util.List<Cliente> clientes = gerenciaCliente.listarCliente();

        clientes.sort(Comparator.comparingInt(Cliente::getId).reversed());

        listaClientes.removeAll();
        blocosCliente.clear();

        for(Cliente c : clientes){
            JPanel bloco = criarBlocoCliente(c, listaClientes);
            blocosCliente.add(bloco);
            listaClientes.add(bloco);
            listaClientes.add(Box.createVerticalStrut(12));
        }

        listaClientes.revalidate();
        listaClientes.repaint();
    }


    private void selecionarBloco(JPanel bloco) {

        if (blocoSelecionado != null) {
            blocoSelecionado.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            blocoSelecionado.setBackground(Color.WHITE);
        }

        blocoSelecionado = bloco;

        bloco.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        bloco.setBackground(new Color(220, 240, 255));
    }

    private void filtrarClientes(String texto) {
        for (JPanel bloco : blocosCliente) {
            JPanel painelCampos = (JPanel) bloco.getComponent(0);
            JLabel nome;
            nome = (JLabel) painelCampos.getComponent(0);

            bloco.setVisible(nome.getText().toLowerCase().contains(texto.toLowerCase()));
        }
    }

    private void verificarDuplicadosClientes() {

        ArrayList<String> nomes = new ArrayList<>();
        ArrayList<String> duplicados = new ArrayList<>();

        for (JPanel bloco : blocosCliente) {

            JPanel campos = (JPanel) bloco.getComponent(0);
            JTextField nome = (JTextField) campos.getComponent(0);
            String n = nome.getText().trim();

            if (!n.isEmpty()) {
                if (nomes.contains(n)) duplicados.add(n);
                else nomes.add(n);
            }
        }

        if (duplicados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum cliente duplicado encontrado.");
        } else {
            JOptionPane.showMessageDialog(this,
                    "Clientes duplicados encontrados: " + duplicados);
        }
    }

    private JPanel criarAbaProduto() {

        JPanel painel = new JPanel(new BorderLayout());
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel listaProdutos = new JPanel();
        listaProdutos.setLayout(new BoxLayout(listaProdutos, BoxLayout.Y_AXIS));

        carregarProdutos(listaProdutos);

        painel.add(new JScrollPane(listaProdutos), BorderLayout.CENTER);

        JPanel rodape = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton btnCadastrar = new JButton("Cadastrar Produto");
        btnCadastrar.setPreferredSize(new Dimension(180, 40));
        btnCadastrar.addActionListener(e -> {
            System.out.println("Tela de cadastro de produto ainda será criada.");
        });

        rodape.add(btnCadastrar);
        painel.add(rodape, BorderLayout.SOUTH);

        return painel;
    }

    private JPanel criarBlocoProduto(Produto produto, JPanel lista) {

        JPanel bloco = new JPanel(new BorderLayout());
        bloco.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        bloco.setBackground(Color.WHITE);
        bloco.setMaximumSize(new Dimension(Integer.MAX_VALUE, 180));

        bloco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                selecionarBloco(bloco);
            }
        });

        JPanel campos = new JPanel();
        campos.setLayout(new BoxLayout(campos, BoxLayout.Y_AXIS));

        JLabel nome = new JLabel(produto.getNome());
        nome.setBorder(BorderFactory.createTitledBorder("Nome"));

        JLabel preco = new JLabel(String.valueOf(produto.getPrecoUnitario()));
        preco.setBorder(BorderFactory.createTitledBorder("Preço Unitário"));

        JLabel categoria = new JLabel(produto.getCategoria());
        categoria.setBorder(BorderFactory.createTitledBorder("Categoria"));

        JLabel fornecedor = new JLabel(produto.getFornecedor());
        fornecedor.setBorder(BorderFactory.createTitledBorder("Fornecedor"));

        campos.add(nome);
        campos.add(preco);
        campos.add(categoria);
        campos.add(fornecedor);

        bloco.add(campos, BorderLayout.CENTER);

        JPanel botoes = new JPanel(new GridLayout(2, 1, 5, 5));

        JButton excluir = new JButton("Excluir");
        excluir.addActionListener(e -> {
            GerenciaProduto gerenciaProduto = new GerenciaProduto();
            gerenciaProduto.excluir(produto.getIdProd());

            lista.remove(bloco);
            lista.revalidate();
            lista.repaint();
        });

        JButton editar = new JButton("Editar");
        editar.addActionListener(e -> {
            // futura tela de edição
        });

        botoes.add(excluir);
        botoes.add(editar);

        bloco.add(botoes, BorderLayout.EAST);

        return bloco;
    }

    private void carregarProdutos(JPanel listaProdutos){
        GerenciaProduto gerenciaProduto = new GerenciaProduto();
        java.util.List<Produto> produtos = gerenciaProduto.listarProduto();

        produtos.sort(Comparator.comparingInt(Produto::getIdProd).reversed());

        listaProdutos.removeAll();
        blocosProduto.clear();

        for (Produto p : produtos) {
            JPanel bloco = criarBlocoProduto(p, listaProdutos);
            blocosProduto.add(bloco);
            listaProdutos.add(bloco);
            listaProdutos.add(Box.createVerticalStrut(12));
        }

        listaProdutos.revalidate();
        listaProdutos.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TelaMenu::new);
    }
}