package usuario;
import conexao.Conexao;
import usuario.Usuario;
import java.sql.*;

public class GerenciaUsuario {
    private Connection conn;
    public GerenciaUsuario() {
        conn = Conexao.getConnection();
    }

    Usuario usuario = new Usuario();

    //Método de cadastro
    public void cadastro(Usuario usuario){
        String sql = "INSERT INTO usuario(nome, idade, email, telefone, genero, identificador, senha)" +
                "VALUES (?, ?, ? ,?, ?, ?, ?)";
        try {
            PreparedStatement stmtUsuario = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmtUsuario.setString(1, usuario.getNome());
            stmtUsuario.setInt(2,usuario.getIdade());
            stmtUsuario.setString(3, usuario.getEmail());
            stmtUsuario.setString(4, usuario.getTelefone());
            stmtUsuario.setString(5, usuario.getGen());
            stmtUsuario.setString(6, usuario.getIdentificador());
            stmtUsuario.setString(7, usuario.getSenha1());
            stmtUsuario.executeUpdate();

            ResultSet rs = stmtUsuario.getGeneratedKeys();
            int id = 0;
            if (rs.next()) {
                id = rs.getInt(1);
            }
            stmtUsuario.close();

            String sqlEnderecoUsuario = "INSERT INTO enderecosusuario(rua, cidade, estado, idUsuario) VALUES (?, ?, ?, ?)";
            PreparedStatement stmtEnderecoUsuario = conn.prepareStatement(sqlEnderecoUsuario);
            stmtEnderecoUsuario.setString(1, usuario.getRua());
            stmtEnderecoUsuario.setString(2,usuario.getCidade());
            stmtEnderecoUsuario.setString(3, usuario.getEstado2());
            stmtEnderecoUsuario.setInt(4, id);
            stmtEnderecoUsuario.executeUpdate();
            stmtEnderecoUsuario.close();
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

