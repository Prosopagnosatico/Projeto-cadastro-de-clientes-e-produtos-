package usuario;
import conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MetodosUsuario {
    private Connection conn;
    public MetodosUsuario() {
        conn = Conexao.getConnection();
    }

    //Método de cadastro
    public void cadastro(Usuario usuario){
        String sql = "INSERT INTO usuario(nome, idade, email, telefone, genero, identificador)" +
                "VALUES (?, ?, ? ,?, ?, ?)";
        try {
            PreparedStatement stmtUsuario = conn.prepareStatement(sql);
            stmtUsuario.setString(1, usuario.getNome());
            stmtUsuario.setInt(2,usuario.getIdade());
            stmtUsuario.setString(3, usuario.getEmail());
            stmtUsuario.setString(4, usuario.getTelefone());
            stmtUsuario.setString(5, usuario.getGen());
            stmtUsuario.setString(6, usuario.getIdentificador());
            stmtUsuario.executeUpdate();
            stmtUsuario.close();

            String sqlEndereco = "INSERT INTO endereco(rua, cidade, estado, cep) VALUES (?, ?, ?, ?)";
            PreparedStatement stmtEndereco = conn.prepareStatement(sql);
            stmtEndereco.setString(1, usuario.getNome());
            stmtEndereco.setInt(2,usuario.getIdade());
            stmtEndereco.setString(3, usuario.getEmail());
            stmtEndereco.setString(4, usuario.getTelefone());
            stmtEndereco.setString(5, usuario.getGen());
            stmtEndereco.setString(6, usuario.getIdentificador());
            stmtEndereco.executeUpdate();
            stmtEndereco.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Método de login
    public boolean Login(String email, String senha){
        String sql = "SELECT COUNT(*) WHERE email = ?, senha = ?";

        try{
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, email);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()){
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}

