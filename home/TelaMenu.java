package home;

import cliente.Cliente;
import cliente.ClienteDAO;
import cliente.EnderecoDAO;
import produto.Produto;
import produto.ProdutoDAO;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaMenu extends JFrame {

    private ClienteDAO clienteDAO = new ClienteDAO();
    private ProdutoDAO produtoDAO = new ProdutoDAO();
    private EnderecoDAO enderecoDAO = new EnderecoDAO();

    public TelaMenu() {
        super("Menu");

        setSize(900, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // BOTÃO SAIR
        JButton btnSair = new JButton("Sair");
        btnSair.addActionListener(e -> dispose());

        JPanel topo = new JPanel(new BorderLayout());
        topo.add(btnSair, BorderLayout.EAST);
        add(topo, BorderLayout.NORTH);

        // ABAS
        JTabbedPane abas = new JTabbedPane();
        abas.addTab("Clientes", painelClientes());
        abas.addTab("Produtos", painelProdutos());

        add(abas, BorderLayout.CENTER);
        setVisible(true);
    }

    // ===========================================================
    // CLIENTES
    // ===========================================================
    private JPanel painelClientes() {

        JPanel geral = new JPanel(new BorderLayout());

        // LISTA
        JPanel lista = new JPanel();
        lista.setLayout(new BoxLayout(lista, BoxLayout.Y_AXIS));

        carregarClientes(lista);

        JScrollPane scroll = new JScrollPane(lista);

        // RODAPE
        JButton btnAdd = new JButton("Cadastrar Cliente");
        btnAdd.addActionListener(e -> new cadastroCliente());

        JPanel rodape = new JPanel();
        rodape.add(btnAdd);

        geral.add(scroll, BorderLayout.CENTER);
        geral.add(rodape, BorderLayout.SOUTH);

        return geral;
    }

    private void carregarClientes(JPanel lista) {

        lista.removeAll();

        List<Cliente> clientes = clienteDAO.listarTodos();

        for (Cliente c : clientes) {
            JPanel bloco = criarBlocoCliente(c);
            lista.add(bloco);
            lista.add(Box.createVerticalStrut(10));
        }

        lista.revalidate();
        lista.repaint();
    }

    private JPanel criarBlocoCliente(Cliente c) {

        JPanel bloco = new JPanel(new BorderLayout());
        bloco.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        bloco.setBackground(Color.WHITE);

        JPanel campos = new JPanel();
        campos.setLayout(new BoxLayout(campos, BoxLayout.Y_AXIS));

        JLabel nome = new JLabel("Nome: " + c.getNome());
        JLabel status = new JLabel("Status: " + c.getStatus());
        JLabel nivel = new JLabel("Nível: " + c.getNivel());

        campos.add(nome);
        campos.add(status);
        campos.add(nivel);

        bloco.add(campos, BorderLayout.CENTER);

        // botões
        JPanel botoes = new JPanel(new GridLayout(1, 3));

        JButton btnPerfil = new JButton("Perfil");
        btnPerfil.addActionListener(e -> new TelaPerfil(c.getId()));

        JButton btnEditar = new JButton("Editar");
        btnEditar.addActionListener(e -> new TelaEditarCliente(c.getId()));

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.addActionListener(e -> {
            int op = JOptionPane.showConfirmDialog(null,
                    "Excluir " + c.getNome() + "?",
                    "Confirmar",
                    JOptionPane.YES_NO_OPTION);

            if (op == JOptionPane.YES_OPTION) {
                clienteDAO.excluir(c.getId());
                JOptionPane.showMessageDialog(null, "Cliente removido.");
                dispose();
                new TelaMenu();
            }
        });

        botoes.add(btnPerfil);
        botoes.add(btnEditar);
        botoes.add(btnExcluir);

        bloco.add(botoes, BorderLayout.EAST);

        return bloco;
    }

    // ===========================================================
    // PRODUTOS
    // ===========================================================
    private JPanel painelProdutos() {

        JPanel geral = new JPanel(new BorderLayout());

        JPanel lista = new JPanel();
        lista.setLayout(new BoxLayout(lista, BoxLayout.Y_AXIS));

        carregarProdutos(lista);

        JScrollPane scroll = new JScrollPane(lista);

        JButton btnAdd = new JButton("Cadastrar Produto");
        btnAdd.addActionListener(e -> new cadastroProduto());

        JPanel rodape = new JPanel();
        rodape.add(btnAdd);

        geral.add(scroll, BorderLayout.CENTER);
        geral.add(rodape, BorderLayout.SOUTH);

        return geral;
    }

    private void carregarProdutos(JPanel lista) {

        lista.removeAll();

        List<Produto> produtos = produtoDAO.listarTodos();

        for (Produto p : produtos) {
            JPanel bloco = criarBlocoProduto(p);
            lista.add(bloco);
            lista.add(Box.createVerticalStrut(10));
        }

        lista.revalidate();
        lista.repaint();
    }

    private JPanel criarBlocoProduto(Produto p) {

        JPanel bloco = new JPanel(new BorderLayout());
        bloco.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        bloco.setBackground(Color.WHITE);

        JPanel campos = new JPanel();
        campos.setLayout(new BoxLayout(campos, BoxLayout.Y_AXIS));

        campos.add(new JLabel("Produto: " + p.getNomeProd()));
        campos.add(new JLabel("Preço: " + p.getPrecoUnitario()));
        campos.add(new JLabel("Categoria: " + p.getCategoria()));

        bloco.add(campos, BorderLayout.CENTER);

        JPanel botoes = new JPanel(new GridLayout(1, 2));

        JButton btnEditar = new JButton("Editar");
        btnEditar.addActionListener(e -> new TelaEditarProduto(p.getId()));

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.addActionListener(e -> {
            int op = JOptionPane.showConfirmDialog(null,
                    "Excluir produto?",
                    "Confirmar",
                    JOptionPane.YES_NO_OPTION);

            if (op == JOptionPane.YES_OPTION) {
                produtoDAO.excluir(p.getId());
                JOptionPane.showMessageDialog(null, "Produto removido.");
                dispose();
                new TelaMenu();
            }
        });

        botoes.add(btnEditar);
        botoes.add(btnExcluir);

        bloco.add(botoes, BorderLayout.EAST);

        return bloco;
    }

    // MAIN
    public static void main(String[] args) {
        new TelaMenu();
    }
}
