package produto;

import conexao.conexao;
import java.sql.*;

public class UsuarioDAO {

    public usuario login(String identificador, String senha) {
        String sql = "SELECT * FROM usuario WHERE identificador = ? AND senha = ?";

        try (Connection conn = conexao.getConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, identificador);
                stmt.setString(2, senha);

                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    usuario u = new usuario();
                    u.setId(rs.getInt("id"));
                    u.setNome(rs.getString("nome"));
                    u.setIdade(rs.getInt("idade"));
                    u.setEmail(rs.getString("email"));
                    u.setTelefone(rs.getString("telefone"));
                    u.setGenero(rs.getString("genero"));
                    u.setIdentificador(rs.getString("identificador"));
                    u.setSenha(rs.getString("senha"));
                    return u;
                }

            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao autenticar usuário: " + e.getMessage());
        }

        return null;
    }
}
