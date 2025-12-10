package cliente;

import conexao.Conexao;
import java.sql.*;

public class EnderecoDAO {

    public Endereco buscarPorClienteId(int clienteId) {
        String sql = "SELECT * FROM enderecos WHERE cliente_id = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, clienteId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Endereco e = new Endereco();
                e.setId(rs.getInt("id"));
                e.setClienteId(rs.getInt("cliente_id"));
                e.setRua(rs.getString("rua"));
                e.setCidade(rs.getString("cidade"));
                e.setEstado(rs.getString("estado"));
                e.setCep(rs.getString("cep"));
                return e;
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar endereço: " + e.getMessage());
        }

        return null;
    }

    public void cadastrar(Endereco e) {
        String sql = "INSERT INTO enderecos (cliente_id, rua, cidade, estado, cep) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, e.getClienteId());
            stmt.setString(2, e.getRua());
            stmt.setString(3, e.getCidade());
            stmt.setString(4, e.getEstado());
            stmt.setString(5, e.getCep());

            stmt.executeUpdate();

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao cadastrar endereço: " + ex.getMessage());
        }
    }
}
