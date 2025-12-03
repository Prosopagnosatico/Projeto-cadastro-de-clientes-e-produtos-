package cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import usuario.Usuario;

public class GerenciaCliente {
    private Connection conn;

    void gerenciaCliente() {
        conn = Conexao.getConnection();
    }

    ;

    //Método de criação de cliente
    public void criarCliente(Cliente cliente) {
        String sql = "INSERT INTO clientes(nome, idade, email, telefone, genero, identificador, status, observacao, nivel)" +
                "VALUES (?, ?, ? ,?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmtClientes = conn.prepareStatement(sql);
            stmtClientes.setString(1, cliente.getNome());
            stmtClientes.setInt(2, cliente.getIdade());
            stmtClientes.setString(3, cliente.getEmail());
            stmtClientes.setString(4, cliente.getTelefone());
            stmtClientes.setString(5, cliente.getGen());
            stmtClientes.setString(6, cliente.getIdentificador());
            stmtClientes.setString(7, cliente.getStatus2());
            stmtClientes.setString(8, cliente.getObservacao());
            stmtClientes.setString(9, cliente.getNivel2());
            stmtClientes.executeUpdate();
            stmtClientes.close();

            String sqlEndereco = "INSERT INTO endereco(rua, cidade, estado, cep) VALUES (?, ?, ?, ?)";
            PreparedStatement stmtEndereco = conn.prepareStatement(sql);
            stmtEndereco.setString(1, cliente.getRua());
            stmtEndereco.setString(2, cliente.getCidade());
            stmtEndereco.setString(3, cliente.getEstado2());
            stmtEndereco.setString(4, cliente.getCep());
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
                cliente.setIdade(rs.getInt("idade"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setGen(rs.getString("genero"));
                cliente.setIdentificador(rs.getString("identificador"));
                cliente.setStatus2(rs.getString("status"));
                cliente.setObservacao(rs.getString("observacao"));
                cliente.setNivel2(rs.getString("nivel"));
                lista.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    //Método para atualizar dados do cliente
    public void atualizarCliente(Cliente cliente){
        String sql = "UPDATE clientes SET nome = ?, idade = ?, email = ?, telefone = ?, genero = ?, identificador = ?, status = ?, observacao = ?,  nivel = ? WHERE id = ?";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,cliente.getNome());
            stmt.setInt(2,cliente.getIdade());
            stmt.setString(3,cliente.getEmail());
            stmt.setString(4,cliente.getTelefone());
            stmt.setString(5,cliente.getGen());
            stmt.setString(6,cliente.getIdentificador());
            stmt.setString(7,cliente.getStatus2());
            stmt.setString(8,cliente.getObservacao());
            stmt.setString(9,cliente.getNivel2());
            stmt.setInt(10, cliente.getId());
            stmt.executeUpdate();
            stmt.close();

            String sqlEndereco = "UPDATE endereco SET rua = ?, cidade = ?, estado = ?, cep = ? WHERE cliente_id = ?";
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

    //Método para excluir um cliente
    public void excluir(int id){
        String sql = "DELETE FROM clientes WHERE id = ?";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


