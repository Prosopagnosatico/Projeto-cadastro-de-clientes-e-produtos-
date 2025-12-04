package promocao;

import conexao.Conexao;
import promocao.*;
import usuario.Usuario;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GerenciaPromocao {
    private Connection conn;

    public GerenciaPromocao(Connection conn) {
        conn = Conexao.getConnection();
    }

    //Método para criar promoção
    public void cadastro(Promocao promocao){
        String sql = "INSERT INTO promocao(precoPromo, dataInicio, dataFim)" +
                "VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setDouble(1, promocao.getPrecoPromo());
            stmt.setDate(2, Date.valueOf(promocao.getDataInicio()));
            stmt.setDate(3, Date.valueOf(promocao.getDataFim()));
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Método deletar promoção

}
