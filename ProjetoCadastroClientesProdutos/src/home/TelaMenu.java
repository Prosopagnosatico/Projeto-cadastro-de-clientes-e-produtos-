package home;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.ArrayList;

public class TelaMenu extends JFrame {

    // Referência ao bloco selecionado
    private JPanel blocoSelecionado = null;

    // Listas com todos os blocos
    private final java.util.List<JPanel> blocosCliente = new ArrayList<>();
    private final java.util.List<JPanel> blocosProduto = new ArrayList<>();

    public TelaMenu() {
        super("Menu Administrador");
        setSize(800, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // ------- TOPO COM BOTÃO SAIR --------
        JPanel topo = new JPanel(new BorderLayout());
        topo.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        JButton btnSair = new JButton("Sair");
        btnSair.setPreferredSize(new Dimension(70, 30));
        btnSair.addActionListener(e -> dispose());
        topo.add(btnSair, BorderLayout.EAST);

        add(topo, BorderLayout.NORTH);

        // ----- ABAS -----
        JTabbedPane abas = new JTabbedPane();
        abas.setFont(new Font("Arial", Font.BOLD, 14));

        abas.addTab("Cliente", criarAbaCliente());
        abas.addTab("Produto", criarAbaProduto());

        add(abas, BorderLayout.CENTER);

        setVisible(true);
    }

    // ============================================================
    // ========================== ABA CLIENTE ======================
    // ============================================================
    private JPanel criarAbaCliente() {

        JPanel painel = new JPanel(new BorderLayout());
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Barra de pesquisa
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

        // Lista de clientes
        JPanel listaClientes = new JPanel();
        listaClientes.setLayout(new BoxLayout(listaClientes, BoxLayout.Y_AXIS));

        for (int i = 0; i < 3; i++) {
            JPanel bloco = criarBlocoCliente(listaClientes);
            blocosCliente.add(bloco);
            listaClientes.add(bloco);
            listaClientes.add(Box.createVerticalStrut(10));
        }

        painel.add(new JScrollPane(listaClientes), BorderLayout.CENTER);

        // RODAPÉ
        JPanel rodape = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton btnCadastrar = new JButton("Cadastrar Cliente");
        btnCadastrar.setPreferredSize(new Dimension(180, 40));
        btnCadastrar.addActionListener(e -> cadastrarClienteSelecionado());

        JButton btnAdicionar = new JButton("Adicionar Cliente");
        btnAdicionar.setPreferredSize(new Dimension(180, 40));
        btnAdicionar.addActionListener(e -> {
            JPanel novo = criarBlocoCliente(listaClientes);
            blocosCliente.add(novo);
            listaClientes.add(novo);
            listaClientes.add(Box.createVerticalStrut(10));
            listaClientes.revalidate();
        });

        JButton btnDuplicados = new JButton("Verificar duplicados");
        btnDuplicados.setPreferredSize(new Dimension(200, 40));
        btnDuplicados.addActionListener(e -> verificarDuplicadosClientes());

        rodape.add(btnCadastrar);
        rodape.add(btnAdicionar);
        rodape.add(btnDuplicados);

        painel.add(rodape, BorderLayout.SOUTH);

        return painel;
    }

    private JPanel criarBlocoCliente(JPanel lista) {

        JPanel bloco = new JPanel(new BorderLayout());
        bloco.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        bloco.setBackground(Color.WHITE);
        bloco.setPreferredSize(new Dimension(500, 100));

        bloco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                selecionarBloco(bloco);
            }
        });

        JPanel campos = new JPanel();
        campos.setLayout(new BoxLayout(campos, BoxLayout.Y_AXIS));

        JTextField nome = new JTextField();
        nome.setBorder(BorderFactory.createTitledBorder("Nome"));
        nome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) { selecionarBloco(bloco); }
        });

        JTextField nivel = new JTextField();
        nivel.setBorder(BorderFactory.createTitledBorder("Status / Nível"));
        nivel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) { selecionarBloco(bloco); }
        });

        campos.add(nome);
        campos.add(nivel);
        bloco.add(campos, BorderLayout.CENTER);

        JPanel botoes = new JPanel(new GridLayout(3, 1, 5, 5));

        JButton excluir = new JButton("Excluir");
        excluir.addActionListener(e -> {
            lista.remove(bloco);
            lista.revalidate();
            lista.repaint();
        });

        JButton inativar = new JButton("Inativar");
        inativar.addActionListener(e -> nivel.setText("Inativo"));

        JButton editar = new JButton("Editar");
        editar.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Modo edição já está ativo.")
        );

        botoes.add(excluir);
        botoes.add(inativar);
        botoes.add(editar);
        bloco.add(botoes, BorderLayout.EAST);

        return bloco;
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
            JTextField nome =
                    (JTextField) ((JPanel) bloco.getComponent(0)).getComponent(0);

            bloco.setVisible(nome.getText().toLowerCase().contains(texto.toLowerCase()));
        }
    }

    private void verificarDuplicadosClientes() {

        ArrayList<String> nomes = new ArrayList<>();
        ArrayList<String> duplicados = new ArrayList<>();

        for (JPanel bloco : blocosCliente) {

            JTextField nome =
                    (JTextField) ((JPanel) bloco.getComponent(0)).getComponent(0);

            String n = nome.getText().trim();

            if (n.isEmpty()) continue;

            if (nomes.contains(n)) duplicados.add(n);
            else nomes.add(n);
        }

        if (duplicados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum cliente duplicado encontrado.");
        } else {
            JOptionPane.showMessageDialog(this,
                    "Clientes duplicados encontrados: " + duplicados);
        }
    }

    private void cadastrarClienteSelecionado() {

        if (blocoSelecionado == null) {
            JOptionPane.showMessageDialog(this, "Nenhum bloco selecionado.");
            return;
        }

        JPanel campos = (JPanel) blocoSelecionado.getComponent(0);

        JTextField nome = (JTextField) campos.getComponent(0);
        JTextField nivel = (JTextField) campos.getComponent(1);

        if (nome.getText().isEmpty() || nivel.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos.");
            return;
        }

        JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!");

        nome.setText("");
        nivel.setText("");
    }

    // ============================================================
    // ========================== ABA PRODUTO ======================
    // ============================================================
    private JPanel criarAbaProduto() {

        JPanel painel = new JPanel(new BorderLayout());
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel listaProdutos = new JPanel();
        listaProdutos.setLayout(new BoxLayout(listaProdutos, BoxLayout.Y_AXIS));

        for (int i = 0; i < 3; i++) {
            JPanel bloco = criarBlocoProduto(listaProdutos);
            blocosProduto.add(bloco);
            listaProdutos.add(bloco);
            listaProdutos.add(Box.createVerticalStrut(10));
        }

        painel.add(new JScrollPane(listaProdutos), BorderLayout.CENTER);

        JPanel rodape = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton btnCadastrar = new JButton("Cadastrar Produto");
        btnCadastrar.setPreferredSize(new Dimension(180, 40));
        btnCadastrar.addActionListener(e -> cadastrarProdutoSelecionado());

        JButton btnAdicionar = new JButton("Adicionar Produto");
        btnAdicionar.setPreferredSize(new Dimension(180, 40));
        btnAdicionar.addActionListener(e -> {
            JPanel novo = criarBlocoProduto(listaProdutos);
            blocosProduto.add(novo);
            listaProdutos.add(novo);
            listaProdutos.add(Box.createVerticalStrut(10));
            listaProdutos.revalidate();
        });

        rodape.add(btnCadastrar);
        rodape.add(btnAdicionar);
        painel.add(rodape, BorderLayout.SOUTH);

        return painel;
    }

    private JPanel criarBlocoProduto(JPanel lista) {

        JPanel bloco = new JPanel(new BorderLayout());
        bloco.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        bloco.setBackground(Color.WHITE);
        bloco.setPreferredSize(new Dimension(500, 170));

        bloco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                selecionarBloco(bloco);
            }
        });

        JPanel campos = new JPanel();
        campos.setLayout(new BoxLayout(campos, BoxLayout.Y_AXIS));

        JTextField nome = new JTextField();
        nome.setBorder(BorderFactory.createTitledBorder("Nome do Produto"));
        nome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) { selecionarBloco(bloco); }
        });

        JTextField preco = new JTextField();
        preco.setBorder(BorderFactory.createTitledBorder("Preço"));
        preco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) { selecionarBloco(bloco); }
        });

        JTextField categoria = new JTextField();
        categoria.setBorder(BorderFactory.createTitledBorder("Categoria"));
        categoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) { selecionarBloco(bloco); }
        });

        JTextField fornecedor = new JTextField();
        fornecedor.setBorder(BorderFactory.createTitledBorder("Fornecedor"));
        fornecedor.setMaximumSize(new Dimension(300, 40));
        fornecedor.setPreferredSize(new Dimension(300, 40));
        fornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) { selecionarBloco(bloco); }
        });

        JPanel fornecedorWrap = new JPanel(new BorderLayout());
        fornecedorWrap.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        fornecedorWrap.add(fornecedor);

        campos.add(nome);
        campos.add(preco);
        campos.add(categoria);
        campos.add(fornecedorWrap);

        bloco.add(campos, BorderLayout.CENTER);

        JPanel botoes = new JPanel(new GridLayout(2, 1, 5, 5));

        JButton excluir = new JButton("Excluir");
        excluir.addActionListener(e -> {
            lista.remove(bloco);
            lista.revalidate();
            lista.repaint();
        });

        JButton editar = new JButton("Editar");
        editar.addActionListener(e -> JOptionPane.showMessageDialog(this, "Modo edição ativado."));

        botoes.add(excluir);
        botoes.add(editar);
        bloco.add(botoes, BorderLayout.EAST);

        return bloco;
    }

    private void cadastrarProdutoSelecionado() {

        if (blocoSelecionado == null) {
            JOptionPane.showMessageDialog(this, "Nenhum bloco selecionado.");
            return;
        }

        JPanel campos = (JPanel) blocoSelecionado.getComponent(0);

        JTextField nome = (JTextField) campos.getComponent(0);
        JTextField preco = (JTextField) campos.getComponent(1);
        JTextField categoria = (JTextField) campos.getComponent(2);

        JPanel fornecedorWrap = (JPanel) campos.getComponent(3);
        JTextField fornecedor = (JTextField) fornecedorWrap.getComponent(0);

        if (nome.getText().isEmpty() ||
                preco.getText().isEmpty() ||
                categoria.getText().isEmpty() ||
                fornecedor.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Preencha todos os campos.");
            return;
        }

        JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso!");

        nome.setText("");
        preco.setText("");
        categoria.setText("");
        fornecedor.setText("");
    }

    // ============================================================
    // ========================== MAIN =============================
    // ============================================================
    public static void main(String[] args) {
        SwingUtilities.invokeLater(TelaMenu::new);
    }
}
