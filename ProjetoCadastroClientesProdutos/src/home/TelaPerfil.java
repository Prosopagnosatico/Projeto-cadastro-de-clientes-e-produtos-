package home;

import javax.swing.*;
import java.awt.*;

public class TelaPerfil extends JFrame {

    // Campos do perfil (não editáveis)
    private JTextField txtNome;
    private JTextField txtCpf;
    private JTextField txtEndereco;
    private JTextField txtTelefone;
    private JTextField txtEmail;
    private JTextField txtStatus;
    private JTextField txtNivel;
    private JTextArea txtObservacoes;

    public TelaPerfil() {
        super("Perfil do Cliente");
        setSize(700, 650);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // ===================== CABEÇALHO =====================
        JPanel topo = new JPanel(new BorderLayout());
        topo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton btnSair = new JButton("Sair");
        btnSair.setPreferredSize(new Dimension(80, 35));
        btnSair.addActionListener(e -> dispose());

        topo.add(btnSair, BorderLayout.EAST);
        add(topo, BorderLayout.NORTH);

        // ===================== PAINEL PRINCIPAL =====================
        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        painel.setBorder(BorderFactory.createEmptyBorder(15, 25, 15, 25));

        // ---------- Nome ----------
        txtNome = criarCampo("Nome do Cliente");

        // ---------- CPF ----------
        txtCpf = criarCampo("CPF");

        // ---------- Endereço ----------
        txtEndereco = criarCampo("Endereço");

        // ---------- Telefone ----------
        txtTelefone = criarCampo("Telefone");

        // ---------- Email ----------
        txtEmail = criarCampo("E-mail");

        // ---------- Status ----------
        txtStatus = criarCampo("Status");

        // ---------- Nível ----------
        txtNivel = criarCampo("Nível (Normal / Especial / VIP)");

        // ---------- Observações ----------
        txtObservacoes = new JTextArea();
        txtObservacoes.setBorder(BorderFactory.createTitledBorder("Observações"));
        txtObservacoes.setLineWrap(true);
        txtObservacoes.setWrapStyleWord(true);
        txtObservacoes.setEditable(false);
        txtObservacoes.setPreferredSize(new Dimension(300, 120));

        painel.add(txtNome);
        painel.add(Box.createVerticalStrut(10));
        painel.add(txtCpf);
        painel.add(Box.createVerticalStrut(10));
        painel.add(txtEndereco);
        painel.add(Box.createVerticalStrut(10));
        painel.add(txtTelefone);
        painel.add(Box.createVerticalStrut(10));
        painel.add(txtEmail);
        painel.add(Box.createVerticalStrut(10));
        painel.add(txtStatus);
        painel.add(Box.createVerticalStrut(10));
        painel.add(txtNivel);
        painel.add(Box.createVerticalStrut(15));
        painel.add(txtObservacoes);

        add(new JScrollPane(painel), BorderLayout.CENTER);

        // ===================== RODAPÉ =====================
        JPanel rodape = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setPreferredSize(new Dimension(150, 40));
        btnVoltar.addActionListener(e -> {
            // placeholder
            System.out.println("Tela principal será aberta futuramente.");
            dispose();
        });

        rodape.add(btnVoltar);

        add(rodape, BorderLayout.SOUTH);

        setVisible(true);
    }

    // ===================== MÉTODO PARA CRIAR CAMPOS =====================
    private JTextField criarCampo(String titulo) {
        JTextField campo = new JTextField();
        campo.setBorder(BorderFactory.createTitledBorder(titulo));
        campo.setEditable(false);
        campo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
        return campo;
    }

    // ===================== MAIN =====================
    public static void main(String[] args) {
        SwingUtilities.invokeLater(TelaPerfil::new);
    }
}