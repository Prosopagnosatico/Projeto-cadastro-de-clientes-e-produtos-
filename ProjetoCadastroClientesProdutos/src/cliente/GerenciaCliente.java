package cliente;

import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import cliente.Cliente;

public class GerenciaCliente {
    private Conexao conexao = new Conexao();
    Connection conn = conexao.getConnection();

    Cliente cliente = new Cliente();

    //Método de criação de cliente
    public void criarCliente(Cliente cliente) {
        String sql = "INSERT INTO clientes(nome, idade, email, telefone, genero, identificador, status, nivel)" +
                "VALUES (?, ?, ? ,?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmtClientes = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmtClientes.setString(1, cliente.getNome());
            stmtClientes.setInt(2, cliente.getIdade());
            stmtClientes.setString(3, cliente.getEmail());
            stmtClientes.setString(4, cliente.getTelefone());
            stmtClientes.setString(5, cliente.getGen());
            stmtClientes.setString(6, cliente.getIdentificador());
            stmtClientes.setString(7, cliente.getStatus());
            stmtClientes.setString(8, cliente.getNivel());
            stmtClientes.executeUpdate();

            ResultSet rs = stmtClientes.getGeneratedKeys();
            int clienteId = 0;
            if (rs.next()) {
                clienteId = rs.getInt(1);
            }
            stmtClientes.close();

            String sqlEndereco = "INSERT INTO enderecos (rua, cidade, estado, cep, cliente_id) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmtEndereco = conn.prepareStatement(sqlEndereco);
            stmtEndereco.setString(1, cliente.getRua());
            stmtEndereco.setString(2, cliente.getCidade());
            stmtEndereco.setString(3, cliente.getEstado2());
            stmtEndereco.setString(4, cliente.getCep());
            stmtEndereco.setInt(5, clienteId);
            stmtEndereco.executeUpdate();
            stmtEndereco.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Método de listar clientes
    public List<Cliente> listarCliente(){
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setStatus(rs.getString("status"));
                cliente.setNivel(rs.getString("nivel"));
                lista.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    //Método para atualizar dados do cliente
    public void atualizarCliente(Cliente cliente){
        String sql = "UPDATE clientes SET nome = ?, idade = ?, email = ?, telefone = ?, genero = ?, identificador = ?, status = ?, nivel = ? WHERE id = ?";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,cliente.getNome());
            stmt.setInt(2,cliente.getIdade());
            stmt.setString(3,cliente.getEmail());
            stmt.setString(4,cliente.getTelefone());
            stmt.setString(5,cliente.getGen());
            stmt.setString(6,cliente.getIdentificador());
            stmt.setString(7,cliente.getStatus());
            stmt.setString(8,cliente.getNivel());
            stmt.setInt(9, cliente.getId());
            stmt.executeUpdate();
            stmt.close();

            String sqlEndereco = "UPDATE enderecos SET rua = ?, cidade = ?, estado = ?, cep = ? WHERE cliente_id = ?";
            PreparedStatement stmtEndereco = conn.prepareStatement(sqlEndereco);
            stmtEndereco.setString(1, cliente.getRua());
            stmtEndereco.setString(2, cliente.getCidade());
            stmtEndereco.setString(3,cliente.getEstado2());
            stmtEndereco.setString(4, cliente.getCep());
            stmtEndereco.setInt(5, cliente.getId());
            stmtEndereco.executeUpdate();
            stmtEndereco.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void alterarStatus(int id, String status){
        String sql = "UPDATE clientes SET status = ? WHERE id = ?";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, status);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            stmt.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    //Método para excluir um cliente
    public void excluir(int id){
        String sql = "DELETE FROM clientes WHERE id = ?";
        try{
            String sqlEndereco = "DELETE FROM enderecos WHERE cliente_id = ?";
            PreparedStatement stmtEndereco = conn.prepareStatement(sqlEndereco);
            stmtEndereco.setInt(1, id);
            stmtEndereco.executeUpdate();
            stmtEndereco.close();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}


