package dao;


import com.mysql.jdbc.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Trem;

public class TremDao {
    private static final String URL = "jdbc:mysql://localhost:3306/bancoDeDados";
    private static final String USUARIO = "admin";
    private static final String SENHA = "1234";

    public void criarTrem(Trem trem) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "INSERT INTO trem (codigo) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, trem.getCodigo());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Trem buscarTremPorCodigo(int codigo) {
        Trem trem = null;

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT * FROM trem WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, codigo);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                trem = new Trem(codigo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return trem;
    }

    public void atualizarTrem(Trem trem) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "UPDATE trem SET codigo = ? WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, trem.getCodigo());
            statement.setInt(2, trem.getCodigo());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarTrem(int codigo) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "DELETE FROM trem WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, codigo);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Trem> listarTrens() {
        List<Trem> trens = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT * FROM trem";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                Trem trem = new Trem(codigo);
                trens.add(trem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return trens;
    }
}

