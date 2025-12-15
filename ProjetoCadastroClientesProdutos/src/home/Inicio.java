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
        this.add(campo, new GridBagConstraints());
        this.setVisible(true);
    }

    public static void main(String[]args) {
        new Inicio();
    }
}
