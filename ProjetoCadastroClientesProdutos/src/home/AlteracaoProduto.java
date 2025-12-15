    package home;

    import produto.GerenciaProduto;
    import produto.Produto;

    import javax.swing.*;
    import java.awt.*;

    public class AlteracaoProduto extends JFrame {

        private JTextField CAMPO_NOME;
        private JTextField CAMPO_CATEGORIA;
        private JTextField CAMPO_PRECO_VENDA;
        private JTextField CAMPO_CUSTO_PRODUCAO;
        private JRadioButton RADIO_PRECO_LOTE_SIM;
        private JRadioButton RADIO_PRECO_LOTE_NAO;
        private JTextField CAMPO_PRECO_LOTE;
        private JTextField CAMPO_MARCA_FORNECEDORES;
        private JTextArea AREA_DESCRICAO;
        private JButton BOTAO_EXCLUIR;
        private JTextField campoNomeProduto;
        private JButton BOTAO_SALVAR_ALTERACOES;
        private JComboBox <String> tamanhoAlteracoes;

        public AlteracaoProduto() {

            this.setTitle("Alteração de Produto");
            this.setDefaultCloseOperation(3);
            this.setResizable(false);
            this.setLocationRelativeTo((Component)null);

            JPanel PAINEL_PRINCIPAL = new JPanel(new GridBagLayout());
            PAINEL_PRINCIPAL.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

            GridBagConstraints GBC = new GridBagConstraints();
            GBC.insets = new Insets(5, 5, 5, 5);
            GBC.fill = GridBagConstraints.HORIZONTAL;

            JLabel ROTULO_TITULO = new JLabel("Alteração de Produto");
            ROTULO_TITULO.setFont(new Font("SansSerif", Font.BOLD, 18));
            GBC.gridx = 0;
            GBC.gridy = 0;
            GBC.gridwidth = 6;
            GBC.anchor = GridBagConstraints.WEST;
            PAINEL_PRINCIPAL.add(ROTULO_TITULO, GBC);

            GBC.gridwidth = 1;


            GBC.gridx = 0; GBC.gridy = 1;
            GBC.anchor = GridBagConstraints.WEST;
            PAINEL_PRINCIPAL.add(new JLabel("Novo nome do produto:"), GBC);

            CAMPO_NOME = new JTextField();
            GBC.gridx = 1; GBC.gridy = 1;
            GBC.weightx = 1.0;
            PAINEL_PRINCIPAL.add(CAMPO_NOME, GBC);

            GBC.gridx = 2; GBC.gridy = 1;
            GBC.weightx = 0.0;
            PAINEL_PRINCIPAL.add(new JLabel("Categoria:"), GBC);

            CAMPO_CATEGORIA = new JTextField("", 10);
            GBC.gridx = 3; GBC.gridy = 1;
            PAINEL_PRINCIPAL.add(CAMPO_CATEGORIA, GBC);

            GBC.gridx = 4; GBC.gridy = 1;
            PAINEL_PRINCIPAL.add(new JLabel("Tamanho:"), GBC);

            String [] tamanho = {
                    "PP", "P", "M", "G", "GG"
            };
            tamanhoAlteracoes = new JComboBox<String>(tamanho);
            GBC.gridx = 5; GBC.gridy = 1;
            PAINEL_PRINCIPAL.add(tamanhoAlteracoes, GBC);

            GBC.gridx = 4; GBC.gridy = 2;
            PAINEL_PRINCIPAL.add(new JLabel("Nome antigo do produto:"), GBC);

            campoNomeProduto = new JTextField("", 5);
            GBC.gridx = 5; GBC.gridy = 2;
            PAINEL_PRINCIPAL.add(campoNomeProduto, GBC);

            GBC.gridx = 0; GBC.gridy = 2;
            PAINEL_PRINCIPAL.add(new JLabel("Preço:"), GBC);

            CAMPO_PRECO_VENDA = new JTextField();
            GBC.gridx = 1; GBC.gridy = 2;
            GBC.weightx = 1.0;
            PAINEL_PRINCIPAL.add(CAMPO_PRECO_VENDA, GBC);

            GBC.gridx = 2; GBC.gridy = 2;
            GBC.weightx = 0.0;
            PAINEL_PRINCIPAL.add(new JLabel("Custo da Produção:"), GBC);

            CAMPO_CUSTO_PRODUCAO = new JTextField();
            GBC.gridx = 3; GBC.gridy = 2;
            PAINEL_PRINCIPAL.add(CAMPO_CUSTO_PRODUCAO, GBC);

            GBC.gridx = 4; GBC.gridy = 2;

            GBC.gridx = 0; GBC.gridy = 3;
            PAINEL_PRINCIPAL.add(new JLabel("Preço por Lote:"), GBC);

            RADIO_PRECO_LOTE_SIM = new JRadioButton("Sim");
            RADIO_PRECO_LOTE_NAO = new JRadioButton("Não");
            ButtonGroup GRUPO_LOTE = new ButtonGroup();
            GRUPO_LOTE.add(RADIO_PRECO_LOTE_SIM);
            GRUPO_LOTE.add(RADIO_PRECO_LOTE_NAO);
            RADIO_PRECO_LOTE_SIM.setSelected(true);

            JPanel PAINEL_RADIO_LOTE = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
            PAINEL_RADIO_LOTE.add(RADIO_PRECO_LOTE_SIM);
            PAINEL_RADIO_LOTE.add(RADIO_PRECO_LOTE_NAO);

            GBC.gridx = 1; GBC.gridy = 3;
            PAINEL_PRINCIPAL.add(PAINEL_RADIO_LOTE, GBC);

            CAMPO_PRECO_LOTE = new JTextField("");
            GBC.gridx = 2; GBC.gridy = 3;
            GBC.weightx = 0.5;
            PAINEL_PRINCIPAL.add(CAMPO_PRECO_LOTE, GBC);

            GBC.gridx = 0; GBC.gridy = 4;
            PAINEL_PRINCIPAL.add(new JLabel("Marca/Fornecedores:"), GBC);

            CAMPO_MARCA_FORNECEDORES = new JTextField("");
            GBC.gridx = 1; GBC.gridy = 4;
            GBC.gridwidth = 3;
            PAINEL_PRINCIPAL.add(CAMPO_MARCA_FORNECEDORES, GBC);

            GBC.gridwidth = 1;

            GBC.gridx = 0; GBC.gridy = 5;
            PAINEL_PRINCIPAL.add(new JLabel("Descrição:"), GBC);

            AREA_DESCRICAO = new JTextArea(8, 20);
            JScrollPane SCROLL_DESCRICAO = new JScrollPane(AREA_DESCRICAO);

            GBC.gridx = 1; GBC.gridy = 5;
            GBC.gridwidth = 5;
            GBC.gridheight = 3;
            GBC.weighty = 1.0;
            PAINEL_PRINCIPAL.add(SCROLL_DESCRICAO, GBC);

            GBC.gridwidth = 1;
            GBC.gridheight = 1;
            GBC.weighty = 0.0;

            GBC.gridx = 0; GBC.gridy = 8;
            GBC.weightx = 1.0;
            GBC.fill = GridBagConstraints.HORIZONTAL;
            PAINEL_PRINCIPAL.add(Box.createHorizontalGlue(), GBC);

            BOTAO_EXCLUIR = new JButton("Excluir");
            GBC.gridx = 4; GBC.gridy = 8;
            GBC.weightx = 0.0;
            GBC.fill = GridBagConstraints.NONE;
            GBC.anchor = GridBagConstraints.EAST;
            PAINEL_PRINCIPAL.add(BOTAO_EXCLUIR, GBC);
            BOTAO_EXCLUIR.addActionListener(e-> excluirProduto());


            BOTAO_SALVAR_ALTERACOES = new JButton("Salvar Alterações");
            GBC.gridx = 5; GBC.gridy = 8;
            GBC.anchor = GridBagConstraints.EAST;
            PAINEL_PRINCIPAL.add(BOTAO_SALVAR_ALTERACOES, GBC);
            BOTAO_SALVAR_ALTERACOES.addActionListener(e -> alterarProduto());

            this.getContentPane().add(PAINEL_PRINCIPAL);
            this.pack();

            this.setVisible(true);

            // --- 12. CHAMADA PARA CARREGAR DADOS (SIMULAÇÃO) ---
            CARREGAR_DADOS_PRODUTO_EXISTENTE();
        }

        // Simula o carregamento de dados de um produto que já existe no sistema
        private void CARREGAR_DADOS_PRODUTO_EXISTENTE() {
            System.out.println("Produto existente carregado e pronto para alteração.");
        }

        // Método para adicionar as ações aos botões

            public void alterarProduto(){
                try {
                    GerenciaProduto gerenciaProduto = new GerenciaProduto();

                    // Pegar ID do produto pelo nome antigo
                    int idOriginal = gerenciaProduto.pegarIdProduto(campoNomeProduto.getText());
                    if(idOriginal == -1){
                        JOptionPane.showMessageDialog(AlteracaoProduto.this, "Produto não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    Produto produto = new Produto();
                    produto.setIdProd(idOriginal);
                    produto.setNome(CAMPO_NOME.getText());
                    produto.setCategoria(CAMPO_CATEGORIA.getText());
                    produto.setPrecoUnitario(Double.parseDouble(CAMPO_PRECO_VENDA.getText()));
                    produto.setCustoProducao(Double.parseDouble(CAMPO_CUSTO_PRODUCAO.getText()));
                    produto.setPrecoLote(Double.parseDouble(CAMPO_PRECO_LOTE.getText()));
                    produto.setFornecedor(CAMPO_MARCA_FORNECEDORES.getText());
                    produto.setDescricao(AREA_DESCRICAO.getText());
                    produto.setTamanho((String) tamanhoAlteracoes.getSelectedItem());

                    gerenciaProduto.atualizarProduto(produto);

                    JOptionPane.showMessageDialog(AlteracaoProduto.this, "Alterações salvas com sucesso!");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(AlteracaoProduto.this, "Preencha corretamente os campos numéricos.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }

            public void excluirProduto(){
                int confirm = JOptionPane.showConfirmDialog(AlteracaoProduto.this,
                        "Tem certeza que deseja excluir permanentemente este produto?",
                        "CONFIRMAR EXCLUSÃO", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    // LÓGICA DE EXCLUSÃO: Chamar o ProdutoDAO.excluir(id)
                    JOptionPane.showMessageDialog(AlteracaoProduto.this, "Produto Excluído.", "AÇÃO: EXCLUIR", JOptionPane.INFORMATION_MESSAGE);
                    AlteracaoProduto.this.dispose();
                }

            }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                new AlteracaoProduto();
            });
        }
    }