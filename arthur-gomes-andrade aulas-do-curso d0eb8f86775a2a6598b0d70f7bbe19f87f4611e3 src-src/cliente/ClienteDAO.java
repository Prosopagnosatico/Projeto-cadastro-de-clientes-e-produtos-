package cliente;

import conexao.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public List<Cliente> listarTodos() {
        List<Cliente> lista = new ArrayList<>();

        String sql = "SELECT * FROM cliente";

        try (Connection c = Conexao.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Cliente cli = new Cliente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("telefone"),
                        rs.getString("identificador"),
                        rs.getString("genero"),
                        rs.getString("email"),
                        rs.getString("status"),
                        rs.getString("nivel")
                );

                lista.add(cli);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public Cliente buscarPorId(int id) {

        String sql = "SELECT * FROM cliente WHERE id = ?";

        try (Connection c = Conexao.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Cliente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("telefone"),
                        rs.getString("identificador"),
                        rs.getString("genero"),
                        rs.getString("email"),
                        rs.getString("status"),
                        rs.getString("nivel")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void excluir(int id) {

        String sql = "DELETE FROM cliente WHERE id = ?";

        try (Connection c = Conexao.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Cliente c) {

        String sql = "UPDATE cliente SET nome=?, telefone=?, identificador=?, genero=?, email=?, status=?, nivel=? WHERE id=?";

        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getNome());
            ps.setString(2, c.getTelefone());
            ps.setString(3, c.getIdentificador());
            ps.setString(4, c.getGenero());
            ps.setString(5, c.getEmail());
            ps.setString(6, c.getStatus());
            ps.setString(7, c.getNivel());
            ps.setInt(8, c.getId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
