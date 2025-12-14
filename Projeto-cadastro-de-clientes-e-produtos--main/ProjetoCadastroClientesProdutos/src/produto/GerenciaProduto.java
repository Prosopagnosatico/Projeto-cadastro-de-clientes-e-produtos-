package produto;

import conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class GerenciaProduto {
    private Connection conn;

    public GerenciaProduto() {
        conn = Conexao.getConnection();
    }

    //Método para criar produto
    public void criarProduto(Produto produto){
        String sql = "INSERT INTO produtos(nomeProd, precoUnitario, precoLote, custoProducao, categoria, tamanhho, fornecedores, descricao)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement stmtProduto = conn.prepareStatement(sql);
            stmtProduto.setString(1, produto.getNome());
            stmtProduto.setDouble(2, produto.getPrecoUnitario());
            stmtProduto.setDouble(3, produto.getPrecoLote());
            stmtProduto.setDouble(4, produto.getCustoProducao());
            stmtProduto.setString(5, produto.getCategoria());
            stmtProduto.setString(6, produto.getTamanho());
            stmtProduto.setString(7, produto.getFornecedor());
            stmtProduto.setString(8, produto.getDescricao());
            stmtProduto.executeUpdate();
            stmtProduto.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Método de listar produto
    public List<Produto> listarProduto(){
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM produtos";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Produto produto = new Produto();
                produto.setIdProd(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setPrecoUnitario(rs.getDouble("precoUnitario"));
                produto.setPrecoLote(rs.getDouble("precoLote"));
                produto.setCustoProducao(rs.getDouble("custoProducao"));
                produto.setCategoria(rs.getString("categoria"));
                produto.setTamanho(rs.getString("tamanho"));
                produto.setFornecedor(rs.getString("fornecedor"));
                produto.setDescricao(rs.getString("descricao"));
                lista.add(produto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    };

    //Método para atualizar produto
    public void atualizarProduto(Produto produto){
        String sql = "UPDATE produtos SET nomeProd = ?, precoUnitario = ?, precoLote = ?, custoProducao = ?, categoria = ?, tamanho = ?, fornecedores = ?, descricao = ? WHERE id = ?";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,produto.getNome());
            stmt.setDouble(2,produto.getPrecoUnitario());
            stmt.setDouble(3,produto.getPrecoLote());
            stmt.setDouble(4,produto.getCustoProducao());
            stmt.setString(5,produto.getCategoria());
            stmt.setString(6,produto.getTamanho());
            stmt.setString(7,produto.getFornecedor());
            stmt.setString(8,produto.getDescricao());
            stmt.setInt(9, produto.getIdProd());
            stmt.execute();
            stmt.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public int pegarIdProduto(String produto){
        String sql = "SELECT id from produtos where nomeProd = ?";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,produto);

            ResultSet result = stmt.executeQuery();

             if(result.next()){
                 return result.getInt("id");
             }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return -1;
        }
    //Método para deletar produto
    public void excluir(int id){
        String sql = "DELETE FROM produtos WHERE id = ?";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Método para pesquisar produto pelo nome
    public List<Produto> buscarProduto(String nomeBuscado){
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM produtos WHERE nome LIKE ?";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nomeBuscado + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdProd(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setPrecoUnitario(rs.getDouble("precoUnitario"));
                produto.setPrecoLote(rs.getDouble("precoLote"));
                produto.setCustoProducao(rs.getDouble("custoProducao"));
                produto.setCategoria(rs.getString("categoria"));
                produto.setTamanho(rs.getString("tamanho"));
                produto.setFornecedor(rs.getString("fornecedor"));
                produto.setDescricao(rs.getString("descricao"));

                lista.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}