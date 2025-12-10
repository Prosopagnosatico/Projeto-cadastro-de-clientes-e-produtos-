package produto;

import conexao.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Produto {

    // CADASTRAR (compatível com sua tela que chama criarProduto)
    public int criarProduto(Produto p) {
        String sql = "INSERT INTO produtos (nomeProd, precoUnitario, precoLote, custoProducao, categoria, tamanhho, fornecedores, descricao) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
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
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar produto: " + e.getMessage(), e);
        }
        return -1;
    }

    // LISTAR TODOS
    public List<Produto> listarTodos() {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM produtos ORDER BY nomeProd ASC";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
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
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar produtos: " + e.getMessage(), e);
        }
        return lista;
    }

    public Produto buscarPorId(int id) {
        String sql = "SELECT * FROM produtos WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
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
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar produto: " + e.getMessage(), e);
        }
        return null;
    }

    public void atualizar(Produto p) {
        String sql = "UPDATE produtos SET nomeProd=?, precoUnitario=?, precoLote=?, custoProducao=?, categoria=?, tamanhho=?, fornecedores=?, descricao=? WHERE id=?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
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
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar produto: " + e.getMessage(), e);
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM produtos WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir produto: " + e.getMessage(), e);
        }
    }
}
