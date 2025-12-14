package home;


import javax.swing.*;
import java.awt.*;

public class TelaProduto extends JFrame {

    public TelaProduto(){
        setTitle("Tela do produto");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painelTelaProduto = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        painelTelaProduto.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        c.insets = new Insets(4,8,4,8);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.WEST;


        adicionarComponente(painelTelaProduto, c, 0, "Nome:", "Categoria:", "tamanho:");
        adicionarComponente(painelTelaProduto, c, 1, "Preço:", "Custo de produção:", "Preço por Lote");
        adicionarUmComponente(painelTelaProduto, c, 2, "Marca / Fronecedor:");

        add(painelTelaProduto);
        setVisible(true);

    }

    public void adicionarComponente(JPanel painelTelaProduto, GridBagConstraints c, int linha, String labelText , String labelText2, String labelText3){
        c.gridx = 0;
        c.gridy = linha;
        c.weightx = 0.1;
        painelTelaProduto.add(new JLabel(labelText), c);

        c.gridx = 1;
        c.weightx = 0.1;
        painelTelaProduto.add(new JLabel(labelText2), c);

        c.gridx = 2;
        c.weightx = 0.1;
        painelTelaProduto.add(new JLabel(labelText3), c);


    }

    public void adicionarUmComponente(JPanel paineTelaProduto, GridBagConstraints c, int linha, String labelText){
        c.gridx = 0;
        c.gridy = linha;
        c.weightx = 0.1;
        paineTelaProduto.add(new JLabel(labelText), c);
    }

    public static void main(String[] args) {
        new TelaProduto();
    }

}