package home;

import cliente.GerenciaCliente;
import cliente.EnderecoDAO;
import cliente.Cliente;
import cliente.Endereco;

import javax.swing.*;
import java.awt;
import java.util.Objects;

public class TelaPerfil extends JFrame {

    private JTextField txtNome, txtTelefone, txtCPF, txtGenero;
    private JTextField txtEstado, txtCidade, txtRua, txtNumero;
    private JTextField txtEmail, txtStatus, txtNivel;
    private JTextArea txtObservacoes;

    private GerenciaCliente gerCliente = new GerenciaCliente();
    private EnderecoDAO enderecoDAO = new EnderecoDAO();
    private int clienteId;

    public TelaPerfil(int clienteId) {
        super("Perfil do cliente.Cliente");
        this.clienteId = clienteId;
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel topo = new JPanel(new BorderLayout());
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(e -> dispose());
        JButton btnPerfil = new JButton("👤");
        topo.add(btnVoltar, BorderLayout.WEST);
        topo.add(btnPerfil, BorderLayout.EAST);
        add(topo, BorderLayout.NORTH);

        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        painel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        txtNome = criarCampo("Nome");
        txtTelefone = criarCampo("Telefone");
        txtCPF = criarCampo("CPF");
        txtGenero = criarCampo("Gênero");
        txtEstado = criarCampo("Estado");
        txtCidade = criarCampo("Cidade");
        txtRua = criarCampo("Rua");
        txtNumero = criarCampo("Número");
        txtEmail = criarCampo("Email");
        txtStatus = criarCampo("Status");
        txtNivel = criarCampo("Nível");
        txtObservacoes = new JTextArea();
        txtObservacoes.setBorder(BorderFactory.createTitledBorder("Observações"));
        txtObservacoes.setEditable(false);
        txtObservacoes.setLineWrap(true);
        txtObservacoes.setWrapStyleWord(true);

        JPanel l1 = new JPanel(new GridLayout(1,2,20,0)); l1.add(txtNome); l1.add(txtCPF); painel.add(l1);
        painel.add(Box.createVerticalStrut(10));
        JPanel l2 = new JPanel(new GridLayout(1,3,20,0)); l2.add(txtTelefone); l2.add(txtGenero); l2.add(txtEmail); painel.add(l2);
        painel.add(Box.createVerticalStrut(10));
        JPanel l3 = new JPanel(new GridLayout(1,4,20,0)); l3.add(txtEstado); l3.add(txtCidade); l3.add(txtRua); l3.add(txtNumero); painel.add(l3);
        painel.add(Box.createVerticalStrut(10));
        JPanel l4 = new JPanel(new GridLayout(1,3,20,0)); l4.add(txtStatus); l4.add(txtNivel); panelAddEmpty(l4); painel.add(l4); // ajuste visual
        painel.add(Box.createVerticalStrut(10));
        painel.add(new JScrollPane(txtObservacoes));

        add(new JScrollPane(painel), BorderLayout.CENTER);

        JPanel rodape = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.addActionListener(e -> {
            int ok = JOptionPane.showConfirmDialog(this, "Excluir cliente?", "Confirma", JOptionPane.YES_NO_OPTION);
            if (ok == JOptionPane.YES_OPTION) {
                gerCliente.excluir(clienteId);
                dispose();
            }
        });
        JButton btnInativar = new JButton("Inativar");
        btnInativar.addActionListener(e -> {
            gerCliente.inativar(clienteId);
            carregarDados();
        });
        JButton btnEditar = new JButton("Editar");
        btnEditar.addActionListener(e -> {
            // Se você tiver sua tela de edição, abra-a aqui. Ex.: new TelaEditarCliente(clienteId).setVisible(true);
            JOptionPane.showMessageDialog(this, "Tela de edição será criada.");
        });

        rodape.add(btnExcluir); rodape.add(btnInativar); rodape.add(btnEditar);
        add(rodape, BorderLayout.SOUTH);

        carregarDados();
    }

    private void panelAddEmpty(JPanel p) {
        p.add(new JLabel()); // placeholder para alinhar
    }

    private JTextField criarCampo(String titulo) {
        JTextField txt = new JTextField();
        txt.setBorder(BorderFactory.createTitledBorder(titulo));
        txt.setEditable(false);
        return txt;
    }

    private void carregarDados() {
        Cliente c = gerCliente.buscarPorId(clienteId);
        if (c == null) {
            JOptionPane.showMessageDialog(this, "cliente.Cliente não encontrado.");
            dispose();
            return;
        }
        txtNome.setText(Objects.toString(c.getNome(), ""));
        txtTelefone.setText(Objects.toString(c.getTelefone(), ""));
        txtCPF.setText(Objects.toString(c.getIdentificador(), ""));
        txtGenero.setText(Objects.toString(c.getGen(), ""));
        txtEmail.setText(Objects.toString(c.getEmail(), ""));
        txtStatus.setText(Objects.toString(c.getStatus(), ""));
        txtNivel.setText(Objects.toString(c.getNivel(), ""));

        // endereco
        Endereco e = new EnderecoDAO().buscarPorClienteId(clienteId);
        if (e != null) {
            txtRua.setText(Objects.toString(e.getRua(), ""));
            txtCidade.setText(Objects.toString(e.getCidade(), ""));
            txtEstado.setText(Objects.toString(e.getEstado(), ""));
            txtNumero.setText(""); // se você armazenar número, adapte
        } else {
            txtRua.setText("");
            txtCidade.setText("");
            txtEstado.setText("");
            txtNumero.setText("");
        }

        txtObservacoes.setText("");
    }
}
