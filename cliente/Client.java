package cliente;

import conexao.conexao;
import java.sql.*;

public class enderecoDAO {

    public endereco buscarPorClienteId(int clienteId) {
        String sql = "SELECT * FROM enderecos WHERE cliente_id = ?";

        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, clienteId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                endereco e = new endereco();
                e.setId(rs.getInt("id"));
                e.setCliente_id(rs.getInt("cliente_id"));
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
}
