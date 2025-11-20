package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    public static Connection getConnection(){
        try{
            String url = "jdbc:mysql://localhost:3306/cliente_e_produto";
            String user = "root";
            String pass = "";

            return DriverManager.getConnection(url, user, pass);
        }
        catch(Exception e){
            throw new RuntimeException("Erro ao conectar ao DB: " + e.getMessage());
        }
    }
}
