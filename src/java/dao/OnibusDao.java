package dao;

import com.mysql.jdbc.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Onibus;

public class OnibusDao {
    private static final String URL = "jdbc:mysql://localhost:3306/bancoDeDados";
    private static final String USUARIO = "admin";
    private static final String SENHA = "1234";

    public void criarOnibus(Onibus onibus) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "INSERT INTO onibus (codigo) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, onibus.getCodigo());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Onibus buscarOnibusPorCodigo(int codigo) {
        Onibus onibus = null;

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT * FROM onibus WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, codigo);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                onibus = new Onibus(codigo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return onibus;
    }

    public void atualizarOnibus(Onibus onibus) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "UPDATE onibus SET codigo = ? WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, onibus.getCodigo());
            statement.setInt(2, onibus.getCodigo());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarOnibus(int codigo) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "DELETE FROM onibus WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, codigo);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Onibus> listarOnibus() {
        List<Onibus> onibusList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT * FROM onibus";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                Onibus onibus = new Onibus(codigo);
                onibusList.add(onibus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return onibusList;
    }
}

