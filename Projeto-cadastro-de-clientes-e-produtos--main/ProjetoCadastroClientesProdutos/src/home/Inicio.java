package home;

import javax.swing.*;
import java.awt.*;

public class Inicio extends JFrame {
    public Inicio() {
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new GridBagLayout());

        JPanel campo = new JPanel();
        JLabel welcome = new JLabel("Bem vindo!");
        welcome.setFont(new Font("Segoe UI", Font.BOLD, 24));
        campo.add(welcome);

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
        this.add(campo, new GridBagConstraints());
        this.setVisible(true);
    }

    public static void main(String[]args) {
        new Inicio();
    }
}
