package home;

import javax.swing.*;
import java.awt.*;

import cliente.GerenciaCliente;
import produto.*;
import java.lang.*;
import java.awt.event.*;

public class cadastroProduto extends JFrame{
    private JTextField nomeProduto, precoUnitarioProduto, precoLoteProduto, custoProducaoProduto, categoriaProduto, fornecedorProduto, descricaoProduto;
    private JComboBox<String> tamanhoProduto; 
    private JButton botaoCadastrarProduto;

    public cadastroProduto(){
        setTitle("cadastro de produto");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel painelProduto = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        painelProduto.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

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

        c.insets = new Insets(4,8,4,8);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.WEST;

        
        JLabel titulo = new JLabel("Cadastro de produto");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 4;
        c.insets = new Insets(5, 0, 20, 0);
        painelProduto.add(titulo, c);

        c.gridwidth = 1; 
        c.insets = new Insets(6, 8, 6, 8);

        nomeProduto = new JTextField(20);
        precoUnitarioProduto = new JTextField(8);
        precoLoteProduto = new JTextField(8);
        custoProducaoProduto = new JTextField(8);
        categoriaProduto = new JTextField(20);
        String[] tamanhos = {"PP", "P", "M", "G", "GG"};
        tamanhoProduto = new JComboBox<String>(tamanhos);
        fornecedorProduto = new JTextField(20);
        descricaoProduto = new JTextField(250);
        descricaoProduto.setPreferredSize(new Dimension(200, 100));

        adicionarComponente(painelProduto, c, 2, "Preço unitário:", precoUnitarioProduto, "Preço do lote: ", precoLoteProduto, 0, 0);
        adicionarComponente(painelProduto, c, 4, "Custo de produção:", custoProducaoProduto, "Categoria", categoriaProduto, 0, 0.5);
        adicionarComponente(painelProduto, c, 6, "Tamanho do produto:", tamanhoProduto, "Fornecedor:", fornecedorProduto, 0, 0.5);
        adicionarUmComponente(painelProduto, c, 8, "Descrição:", descricaoProduto);
        adicionarUmComponente(painelProduto, c, 1, "Nome:", nomeProduto);


        JPanel painelBotaoProduto = new JPanel();
        botaoCadastrarProduto = new JButton("Cadastrar");
        botaoCadastrarProduto.setBackground(new Color(52, 152, 219)); // azul
        botaoCadastrarProduto.setForeground(Color.WHITE);
        botaoCadastrarProduto.setPreferredSize(new Dimension(150, 30));
        c.gridx = 0;
        c.gridy = 9;
        c.gridwidth = 5;
        c.anchor = GridBagConstraints.CENTER;
        painelBotaoProduto.add(botaoCadastrarProduto);
        painelProduto.add(painelBotaoProduto, c);
        botaoCadastrarProduto.addActionListener(e -> cadastrarProduto());      

        add(painelProduto);

        this.setVisible(true);
    }

          public void adicionarComponente(JPanel painelProduto, GridBagConstraints c, int linha, String labelText, JComponent campo, String labeltext2, JComponent campo2, double weightxcampo, double weightxCampo2){
            c.gridx = 0;

            c.gridy = linha;
            c.weightx = 0;
            painelProduto.add(new JLabel(labelText), c);

            c.gridx = 1;
            c.weightx = weightxcampo;
            painelProduto.add(campo, c);
            
            c.gridx = 2;
            painelProduto.add(new JLabel(labeltext2), c);

            c.gridx = 3;
            c.gridy = linha;
            c.weightx = weightxCampo2;
            painelProduto.add(campo2, c);
        }

            public void adicionarUmComponente(JPanel painelProduto, GridBagConstraints c, int linha, String labelText, JComponent campo){
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

        public void cadastrarProduto(){
            Produto produto = new Produto();
            
            produto.setNome(nomeProduto.getText());
            produto.setPrecoUnitario(Double.parseDouble(precoUnitarioProduto.getText()));
            produto.setPrecoLote(Double.parseDouble(precoLoteProduto.getText()));
            produto.setCustoProducao(Double.parseDouble(custoProducaoProduto.getText()));
            produto.setTamanho((String) tamanhoProduto.getSelectedItem());
            produto.setCategoria(categoriaProduto.getText());
            produto.setFornecedor(fornecedorProduto.getText());
            produto.setDescricao(descricaoProduto.getText());

            GerenciaProduto gerenciaProduto = new GerenciaProduto();
            gerenciaProduto.criarProduto(produto);

        }
    public static void main(String[] args) {
        new cadastroProduto();
    }
}
