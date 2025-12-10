package home;

import model.Cliente;

import javax.swing.*;
import java.awt;

public class TelaCadastroCliente extends JFrame {

    private JTextField txtNome, txtIdade, txtEmail, txtTelefone, txtGenero, txtIdentificador, txtStatus, txtNivel;
    private dao.GerenciaClienteDAO dao = new dao.GerenciaClienteDAO();

    public TelaCadastroCliente() {
        super("Cadastrar cliente.Cliente");
        setSize(500, 450);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        txtNome = criarCampo("Nome");
        txtIdade = criarCampo("Idade");
        txtEmail = criarCampo("Email");
        txtTelefone = criarCampo("Telefone");
        txtGenero = criarCampo("Gênero");
        txtIdentificador = criarCampo("CPF/CNPJ");
        txtStatus = criarCampo("Status");
        txtNivel = criarCampo("Nível (Normal/Especial/VIP)");

        add(txtNome); add(txtIdade); add(txtEmail); add(txtTelefone);
        add(txtGenero); add(txtIdentificador); add(txtStatus); add(txtNivel);

        JPanel rodape = new JPanel(new FlowLayout());
        JButton salvar = new JButton("Salvar");
        salvar.addActionListener(e -> salvar());
        JButton cancelar = new JButton("Cancelar");
        cancelar.addActionListener(e -> dispose());
        rodape.add(salvar); rodape.add(cancelar);
        add(rodape);
    }

    private JTextField criarCampo(String titulo) {
        JTextField t = new JTextField();
        t.setBorder(BorderFactory.createTitledBorder(titulo));
        t.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        return t;
    }

    private void salvar() {
        try {
            Cliente c = new Cliente();
            c.setNome(txtNome.getText());
            c.setIdade(Integer.parseInt(txtIdade.getText()));
            c.setEmail(txtEmail.getText());
            c.setTelefone(txtTelefone.getText());
            c.setGenero(txtGenero.getText());
            c.setIdentificador(txtIdentificador.getText());
            c.setStatus(txtStatus.getText());
            c.setNivel(txtNivel.getText());
            dao.inserir(c);
            JOptionPane.showMessageDialog(this, "cliente.Cliente cadastrado!");
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        }
    }
}
