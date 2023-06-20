package dao;

import com.mysql.jdbc.MySQLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.PontoDeVenda;

public class PontoDeVendaDao {
    private static final String URL = "jdbc:mysql://localhost:3306/bancoDeDados";
    private static final String USUARIO = "admin";
    private static final String SENHA = "1234";

    public void criarPontoDeVenda(PontoDeVenda pontoDeVenda) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "INSERT INTO ponto_de_venda (codigo, nome, cnpj, endereco, telefone) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, pontoDeVenda.getCodigo());
            statement.setString(2, pontoDeVenda.getNome());
            statement.setString(3, pontoDeVenda.getCnpj());
            statement.setString(4, pontoDeVenda.getEndereco());
            statement.setInt(5, pontoDeVenda.getTelefone());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PontoDeVenda buscarPontoDeVendaPorCodigo(int codigo) {
        PontoDeVenda pontoDeVenda = null;

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT * FROM ponto_de_venda WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, codigo);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String cnpj = resultSet.getString("cnpj");
                String endereco = resultSet.getString("endereco");
                int telefone = resultSet.getInt("telefone");
                pontoDeVenda = new PontoDeVenda(codigo, nome, cnpj, endereco, telefone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pontoDeVenda;
    }

    public void atualizarPontoDeVenda(PontoDeVenda pontoDeVenda) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "UPDATE ponto_de_venda SET nome = ?, cnpj = ?, endereco = ?, telefone = ? WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, pontoDeVenda.getNome());
            statement.setString(2, pontoDeVenda.getCnpj());
            statement.setString(3, pontoDeVenda.getEndereco());
            statement.setInt(4, pontoDeVenda.getTelefone());
            statement.setInt(5, pontoDeVenda.getCodigo());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarPontoDeVenda(int codigo) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "DELETE FROM ponto_de_venda WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, codigo);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<PontoDeVenda> listarPontosDeVenda() {
       
        List<PontoDeVenda> pontosDeVenda = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT * FROM ponto_de_venda";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                String nome = resultSet.getString("nome");
                String cnpj = resultSet.getString("cnpj");
                String endereco = resultSet.getString("endereco");
                int telefone = resultSet.getInt("telefone");
                PontoDeVenda pontoDeVenda = new PontoDeVenda(codigo, nome, cnpj, endereco, telefone);
                pontosDeVenda.add(pontoDeVenda);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pontosDeVenda;
    }
}

