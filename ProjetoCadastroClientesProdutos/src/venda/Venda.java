package venda;

import cliente.Cliente;
import conexao.Conexao;
import produto.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

public class Venda {
    private Date data;
    private double lucro;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getLucro() {
        return lucro;
    }

    public void setLucro(double lucro) {
        this.lucro = lucro;
    }

    public double calcularLucro(double precoUnitario, double custoProducao){
        Venda venda = new Venda();
        double lucro = precoUnitario - custoProducao;
        venda.setLucro(lucro);
        return venda.getLucro();
    }

   public void registrarVenda(Produto produto, Cliente cliente){
       String sql = "UPDATE usuario SET venda_id = ? WHERE id = ?";

       try {
           Connection conn = Conexao.getConnection();
           PreparedStatement pstm = conn.prepareStatement(sql);

           pstm.setInt(1, produto.getIdProd());
           pstm.setInt(2, cliente.getId());

           pstm.executeUpdate();
           pstm.close();
           conn.close();

       } catch (Exception e) {
           e.printStackTrace();
       }
   }
    public void registrarVendaLote(double precoLote){
        String sql = "UPDATE vendas SET precoLote = ?";

        try {
            Connection conn = Conexao.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setDouble(1, precoLote);

            pstm.executeUpdate();
            pstm.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
