package dao;

import com.mysql.jdbc.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Navio;

public class NavioDao {
    private static final String URL = "jdbc:mysql://localhost:3306/bancoDeDados";
    private static final String USUARIO = "admin";
    private static final String SENHA = "1234";

    public void criarNavio(Navio navio) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "INSERT INTO navio (codigo) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, navio.getCodigo());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Navio buscarNavioPorCodigo(int codigo) {
        Navio navio = null;

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT * FROM navio WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, codigo);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                navio = new Navio(codigo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return navio;
    }

    public void atualizarNavio(Navio navio) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "UPDATE navio SET codigo = ? WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, navio.getCodigo());
            statement.setInt(2, navio.getCodigo());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarNavio(int codigo) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "DELETE FROM navio WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, codigo);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Navio> listarNavios() {
        List<Navio> navios = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT * FROM navio";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                Navio navio = new Navio(codigo);
                navios.add(navio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return navios;
    }
}
