package home;

import javax.swing.*;
import java.awt.*;

public class AlteracaoCliente extends JFrame {

    private JTextField nomeField;
    private JTextField dataNascimentoField;
    private JTextField telefoneField;
    private JTextField cpfField;
    private JRadioButton generoMascButton;
    private JRadioButton generoFemButton;
    private JTextField emailField;
    private JTextField ruaField;
    private JTextField cidadeField;
    private JComboBox<String> estadoComboBox;
    private JComboBox<String> statusComboBox;
    private JComboBox<String> nivelComboBox;
    private JTextArea observacoesArea;
    private JButton cancelarButton;
    private JButton salvarButton;

    public AlteracaoCliente() {
        super("Edição de Cliente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Edição de Cliente");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(titleLabel, gbc);

        gbc.gridwidth = 1;

        gbc.gridx = 0; gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(new JLabel("Nome:"), gbc);

        nomeField = new JTextField();
        gbc.gridx = 1; gbc.gridy = 1;
        gbc.weightx = 1.0;
        mainPanel.add(nomeField, gbc);

        gbc.gridx = 2; gbc.gridy = 1;
        gbc.weightx = 0.0; // Remove o peso
        mainPanel.add(new JLabel("Data de Nascimento:"), gbc);

        dataNascimentoField = new JTextField(10);
        gbc.gridx = 3; gbc.gridy = 1;
        mainPanel.add(dataNascimentoField, gbc);


        gbc.gridx = 0; gbc.gridy = 2;
        mainPanel.add(new JLabel("Telefone:"), gbc);

        telefoneField = new JTextField();
        gbc.gridx = 1; gbc.gridy = 2;
        gbc.weightx = 1.0;
        mainPanel.add(telefoneField, gbc);

        gbc.gridx = 2; gbc.gridy = 2;
        gbc.weightx = 0.0;
        mainPanel.add(new JLabel("CPF/CNPJ:"), gbc);

        cpfField = new JTextField(10);
        gbc.gridx = 3; gbc.gridy = 2;
        mainPanel.add(cpfField, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        mainPanel.add(new JLabel("Email:"), gbc);

        emailField = new JTextField();
        gbc.gridx = 1; gbc.gridy = 3;
        gbc.weightx = 1.0;
        mainPanel.add(emailField, gbc);

        gbc.gridx = 2; gbc.gridy = 3;
        gbc.weightx = 0.0;
        mainPanel.add(new JLabel("Gênero:"), gbc);

        generoMascButton = new JRadioButton("M");
        generoFemButton = new JRadioButton("F");
        ButtonGroup generoGroup = new ButtonGroup();
        generoGroup.add(generoMascButton);
        generoGroup.add(generoFemButton);
        generoMascButton.setSelected(true);

        JPanel generoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        generoPanel.add(generoMascButton);
        generoPanel.add(generoFemButton);

        gbc.gridx = 3; gbc.gridy = 3;
        mainPanel.add(generoPanel, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        mainPanel.add(new JLabel("Estado:"), gbc);

        String[] estados = {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA",
                "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RO", "RR",
                "SC", "SP", "SE", "TO" };
        estadoComboBox = new JComboBox<>(estados);
        estadoComboBox.setSelectedItem("");
        gbc.gridx = 1; gbc.gridy = 4;
        gbc.weightx = 1.0;
        mainPanel.add(estadoComboBox, gbc);

        gbc.gridx = 2; gbc.gridy = 4;
        gbc.weightx = 0.0;
        mainPanel.add(new JLabel("Cidade:"), gbc);

        cidadeField = new JTextField();
        gbc.gridx = 3; gbc.gridy = 4;
        mainPanel.add(cidadeField, gbc);

        gbc.gridx = 0; gbc.gridy = 5;
        mainPanel.add(new JLabel("Rua:"), gbc);

        ruaField = new JTextField();
        gbc.gridx = 1; gbc.gridy = 5;
        gbc.gridwidth = 3;
        mainPanel.add(ruaField, gbc);

        gbc.gridwidth = 1;

        gbc.gridx = 0; gbc.gridy = 6;
        mainPanel.add(new JLabel("Status:"), gbc);

        String[] status = {"Ativo", "Inativo"};
        statusComboBox = new JComboBox<>(status);
        statusComboBox.setSelectedItem("");
        gbc.gridx = 1; gbc.gridy = 6;
        mainPanel.add(statusComboBox, gbc);

        gbc.gridx = 2; gbc.gridy = 6;
        mainPanel.add(new JLabel("Nível:"), gbc);

        String[] niveis = {"Normal", "Especial", "VIP"};
        nivelComboBox = new JComboBox<>(niveis);
        nivelComboBox.setSelectedItem("");
        gbc.gridx = 3; gbc.gridy = 6;
        mainPanel.add(nivelComboBox, gbc);


        cancelarButton = new JButton("Cancelar");
        gbc.gridx = 2; gbc.gridy = 9;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(cancelarButton, gbc);


        salvarButton = new JButton("Salvar");
        gbc.gridx = 3; gbc.gridy = 9;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(salvarButton, gbc);

        add(mainPanel);
        pack();
        setLocationRelativeTo(null);

        addListeners();
    }

    private void addListeners() {
        salvarButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Dados Alterados do Cliente Salvos",
                    "Ação", JOptionPane.INFORMATION_MESSAGE);

        });

        cancelarButton.addActionListener(e -> {
            dispose();
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AlteracaoCliente().setVisible(true);
        });
    }
}