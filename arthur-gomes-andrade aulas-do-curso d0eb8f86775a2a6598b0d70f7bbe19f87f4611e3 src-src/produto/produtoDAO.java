package produto;

import conexao.Conexao;
import model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public List<Produto> listarTodos() {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT id, nomeProd, precoUnitario, precoLote, custoProducao, categoria, tamanhho, fornecedores, descricao FROM produtos";
        try (Connection c = Conexao.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setNomeProd(rs.getString("nomeProd"));
                p.setPrecoUnitario(rs.getDouble("precoUnitario"));
                p.setPrecoLote(rs.getDouble("precoLote"));
                p.setCustoProducao(rs.getDouble("custoProducao"));
                p.setCategoria(rs.getString("categoria"));
                p.setTamanhho(rs.getDouble("tamanhho"));
                p.setFornecedores(rs.getString("fornecedores"));
                p.setDescricao(rs.getString("descricao"));
                lista.add(p);
            }
        } catch (SQLException ex) { throw new RuntimeException(ex); }
        return lista;
    }

    public Produto findById(int id) {
        String sql = "SELECT id, nomeProd, precoUnitario, precoLote, custoProducao, categoria, tamanhho, fornecedores, descricao FROM produtos WHERE id = ?";
        try (Connection c = Conexao.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Produto p = new Produto();
                    p.setId(rs.getInt("id"));
                    p.setNomeProd(rs.getString("nomeProd"));
                    p.setPrecoUnitario(rs.getDouble("precoUnitario"));
                    p.setPrecoLote(rs.getDouble("precoLote"));
                    p.setCustoProducao(rs.getDouble("custoProducao"));
                    p.setCategoria(rs.getString("categoria"));
                    p.setTamanhho(rs.getDouble("tamanhho"));
                    p.setFornecedores(rs.getString("fornecedores"));
                    p.setDescricao(rs.getString("descricao"));
                    return p;
                }
            }
        } catch (SQLException ex) { throw new RuntimeException(ex); }
        return null;
    }

    public int inserir(Produto p) {
        String sql = "INSERT INTO produtos(nomeProd, precoUnitario, precoLote, custoProducao, categoria, tamanhho, fornecedores, descricao) VALUES(?,?,?,?,?,?,?,?)";
        try (Connection c = Conexao.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, p.getNomeProd());
            ps.setDouble(2, p.getPrecoUnitario());
            ps.setDouble(3, p.getPrecoLote());
            ps.setDouble(4, p.getCustoProducao());
            ps.setString(5, p.getCategoria());
            ps.setDouble(6, p.getTamanhho());
            ps.setString(7, p.getFornecedores());
            ps.setString(8, p.getDescricao());
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) return keys.getInt(1);
            }
        } catch (SQLException ex) { throw new RuntimeException(ex); }
        return -1;
    }

    public void atualizar(Produto p) {
        String sql = "UPDATE produtos SET nomeProd=?, precoUnitario=?, precoLote=?, custoProducao=?, categoria=?, tamanhho=?, fornecedores=?, descricao=? WHERE id=?";
        try (Connection c = Conexao.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, p.getNomeProd());
            ps.setDouble(2, p.getPrecoUnitario());
            ps.setDouble(3, p.getPrecoLote());
            ps.setDouble(4, p.getCustoProducao());
            ps.setString(5, p.getCategoria());
            ps.setDouble(6, p.getTamanhho());
            ps.setString(7, p.getFornecedores());
            ps.setString(8, p.getDescricao());
            ps.setInt(9, p.getId());
            ps.executeUpdate();
        } catch (SQLException ex) { throw new RuntimeException(ex); }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM produtos WHERE id=?";
        try (Connection c = Conexao.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) { throw new RuntimeException(ex); }
    }
}

