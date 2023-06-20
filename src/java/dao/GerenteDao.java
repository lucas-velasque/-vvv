package dao;

import com.mysql.jdbc.MySQLConnection;

import model.Gerente;
import model.PontoDeVenda;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GerenteDao {
    private static final String URL = "jdbc:mysql://localhost:3306/bancoDeDados";
    private static final String USUARIO = "admin";
    private static final String SENHA = "1234";
    private PontoDeVenda pontoDeVenda;

    public GerenteDao() {
        this.pontoDeVenda = new PontoDeVenda();
    }

    public void criarGerente(Gerente gerente) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "INSERT INTO gerente (codigo, ponto_venda) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, gerente.getCodigo());
            statement.setInt(2, gerente.getPontoDeVenda().getCodigo());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Gerente buscarGerentePorCodigo(int codigo) {
        Gerente gerente = null;

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT * FROM gerente WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, codigo);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int pontoVendaCodigo = resultSet.getInt("ponto_venda");
                gerente = new Gerente(codigo, pontoDeVenda);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return gerente;
    }

    public void atualizarGerente(Gerente gerente) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "UPDATE gerente SET ponto_venda = ? WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, gerente.getPontoDeVenda().getCodigo());
            statement.setInt(2, gerente.getCodigo());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarGerente(int codigo) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "DELETE FROM gerente WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, codigo);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Gerente> listarGerentes() {
        List<Gerente> gerentes = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT * FROM gerente";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                int pontoVendaCodigo = resultSet.getInt("ponto_venda");
                PontoDeVenda pontoDeVendaDAO = new PontoDeVenda();
                Gerente gerente = new Gerente(codigo, pontoDeVenda);
                gerentes.add(gerente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return gerentes;
    }
}

