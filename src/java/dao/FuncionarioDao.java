package dao;
import model.Funcionario;

import com.mysql.jdbc.MySQLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao {
    private static final String URL = "jdbc:mysql://localhost:3306/bancoDeDados";
    private static final String USUARIO = "admin";
    private static final String SENHA = "1234";


    public void salvarFuncionario(Funcionario funcionario) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "INSERT INTO funcionario (codigo, nome, endereco) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, funcionario.getCodigo());
            statement.setString(2, funcionario.getNome());
            statement.setString(3, funcionario.getEndereco());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Funcionario buscarFuncionarioPorCodigo(int codigo) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT * FROM funcionario WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, codigo);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String endereco = resultSet.getString("endereco");
                Funcionario funcionario = new Funcionario(codigo, nome, endereco);
                return funcionario;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void atualizarFuncionario(Funcionario funcionario) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "UPDATE funcionario SET nome = ?, endereco = ? WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, funcionario.getNome());
            statement.setString(2, funcionario.getEndereco());
            statement.setInt(3, funcionario.getCodigo());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarFuncionario(int codigo) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "DELETE FROM funcionario WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, codigo);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Funcionario> listarFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT * FROM funcionario";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                String nome = resultSet.getString("nome");
                String endereco = resultSet.getString("endereco");
                funcionarios.add(new Funcionario(codigo, nome, endereco));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return funcionarios;
    }
}
