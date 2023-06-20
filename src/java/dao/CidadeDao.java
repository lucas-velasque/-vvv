
package dao;

import com.mysql.jdbc.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Cidade;

public class CidadeDao {
    private static final String URL = "jdbc:mysql://localhost:3306/bancoDeDados";
    private static final String USUARIO = "admin";
    private static final String SENHA = "1234";

    public void criarCidade(Cidade cidade) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "INSERT INTO cidade (codigo, nome, identificador) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, cidade.getCodigo());
            statement.setString(2, cidade.getNome());
            statement.setString(3, cidade.getIdentificador());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Cidade buscarCidadePorCodigo(int codigo) {
        Cidade cidade = null;

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT * FROM cidade WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, codigo);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String identificador = resultSet.getString("identificador");
                cidade = new Cidade(codigo, nome, identificador);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cidade;
    }

    public void atualizarCidade(Cidade cidade) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "UPDATE cidade SET nome = ?, identificador = ? WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, cidade.getNome());
            statement.setString(2, cidade.getIdentificador());
            statement.setInt(3, cidade.getCodigo());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarCidade(int codigo) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "DELETE FROM cidade WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, codigo);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cidade> listarCidades() {
        List<Cidade> cidades = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT * FROM cidade";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                String nome = resultSet.getString("nome");
                String identificador = resultSet.getString("identificador");
                Cidade cidade = new Cidade(codigo, nome, identificador);
                cidades.add(cidade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cidades;
    }
}

