
package dao;

import com.mysql.jdbc.MySQLConnection;

import java.util.ArrayList;
import model.Modal;


import java.sql.*;
import java.util.List;

public class ModalDao {
    private static final String URL = "jdbc:mysql://localhost:3306/bancoDeDados";
    private static final String USUARIO = "admin";
    private static final String SENHA = "1234";

    public void criarModal(Modal modal) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "INSERT INTO modal (codigo, capacidade, ano_fabricacao, qtd_pessoas, tipo, modelo, situacao) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, modal.getCodigo());
            statement.setInt(2, modal.getCapacidade());
            statement.setInt(3, modal.getAnoFabricacao());
            statement.setInt(4, modal.getQtdPessoas());
            statement.setString(5, modal.getTipo());
            statement.setString(6, modal.getModelo());
            statement.setBoolean(7, modal.isSituacao());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Modal buscarModalPorCodigo(int codigo) {
        Modal modal = null;

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT * FROM modal WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, codigo);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int capacidade = resultSet.getInt("capacidade");
                int anoFabricacao = resultSet.getInt("ano_fabricacao");
                int qtdPessoas = resultSet.getInt("qtd_pessoas");
                String tipo = resultSet.getString("tipo");
                String modelo = resultSet.getString("modelo");
                boolean situacao = resultSet.getBoolean("situacao");
                modal = new Modal(codigo, capacidade, anoFabricacao, qtdPessoas, tipo, modelo, situacao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return modal;
    }

    public void atualizarModal(Modal modal) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "UPDATE modal SET capacidade = ?, ano_fabricacao = ?, qtd_pessoas = ?, tipo = ?, modelo = ?, situacao = ? WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, modal.getCapacidade());
            statement.setInt(2, modal.getAnoFabricacao());
            statement.setInt(3, modal.getQtdPessoas());
            statement.setString(4, modal.getTipo());
            statement.setString(5, modal.getModelo());
            statement.setBoolean(6, modal.isSituacao());
            statement.setInt(7, modal.getCodigo());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarModal(int codigo) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "DELETE FROM modal WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, codigo);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Modal> listarModais() {
        List<Modal> modais = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT * FROM modal";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                int capacidade = resultSet.getInt("capacidade");
                int anoFabricacao = resultSet.getInt("ano_fabricacao");
                int qtdPessoas = resultSet.getInt("qtd_pessoas");
                String tipo = resultSet.getString("tipo");
                String modelo = resultSet.getString("modelo");
                boolean situacao = resultSet.getBoolean("situacao");
                Modal modal = new Modal(codigo, capacidade, anoFabricacao, qtdPessoas, tipo, modelo, situacao);
                modais.add(modal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return modais;
    }
}

