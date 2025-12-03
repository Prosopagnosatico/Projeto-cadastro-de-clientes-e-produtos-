package produto;

import conexao.Conexao;

import java.sql.Connection;

public class GerenciaProduto {
    private Connection conn;

    void gerenciaProduto() {
        conn = Conexao.getConnection();
    }
}
