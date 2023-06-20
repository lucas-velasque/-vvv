package dao;

import com.mysql.jdbc.MySQLConnection;

import java.sql.*;

import model.Transportadora;
import model.Modal;
import java.util.ArrayList;
import java.util.List;

public class TransportadoraDao {
    private static final String URL = "jdbc:mysql://localhost:3306/bancoDeDados";
    private static final String USUARIO = "admin";
    private static final String SENHA = "1234";

    public void criarTransportadora(Transportadora transportadora) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "INSERT INTO transportadora (codigo) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, transportadora.getCodigo());
            statement.executeUpdate();
            
            // Atualiza a tabela de relacionamento entre a transportadora e os modais
            atualizarModaisTransportadora(transportadora);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Transportadora buscarTransportadoraPorCodigo(int codigo) {
        Transportadora transportadora = null;

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT * FROM transportadora WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, codigo);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                transportadora = new Transportadora(codigo);
                // Carrega os modais da transportadora
                List<Modal> modais = buscarModaisPorTransportadora(transportadora);
                transportadora.setModais(modais);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return transportadora;
    }

    public void atualizarTransportadora(Transportadora transportadora) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "UPDATE transportadora SET codigo = ? WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, transportadora.getCodigo());
            statement.setInt(2, transportadora.getCodigo());
            statement.executeUpdate();
            
            // Atualiza a tabela de relacionamento entre a transportadora e os modais
            atualizarModaisTransportadora(transportadora);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarTransportadora(int codigo) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "DELETE FROM transportadora WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, codigo);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Transportadora> listarTransportadoras() {
        List<Transportadora> transportadoras = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT * FROM transportadora";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                Transportadora transportadora = new Transportadora(codigo);
                // Carrega os modais da transportadora
                List<Modal> modais = buscarModaisPorTransportadora(transportadora);
                transportadora.setModais(modais);
                transportadoras.add(transportadora);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return transportadoras;
    }
    
    private void atualizarModaisTransportadora(Transportadora transportadora) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            // Deleta os registros antigos de modais da transportadora
            String deleteQuery = "DELETE FROM transportadora_modal WHERE codigo_transportadora = ?";
            PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
            deleteStatement.setInt(1, transportadora.getCodigo());
            deleteStatement.executeUpdate();
            
            // Insere os novos registros de modais da transportadora
            String insertQuery = "INSERT INTO transportadora_modal (codigo_transportadora, codigo_modal) VALUES (?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            for (Modal modal : transportadora.getModais()) {
                insertStatement.setInt(1, transportadora.getCodigo());
                insertStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private List<Modal> buscarModaisPorTransportadora(Transportadora transportadora) {
        List<Modal> modais = new ArrayList<>();
        
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT m.codigo, m.capacidade, m.ano_fabricacao, m.tipo, m.modelo, m.situacao FROM modal m JOIN transportadora_modal tm ON m.codigo = tm.codigo_modal WHERE tm.codigo_transportadora = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, transportadora.getCodigo());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                int capacidade = resultSet.getInt("capacidade");
                int anoFabricacao = resultSet.getInt("ano_fabricacao");
                String tipo = resultSet.getString("tipo");
                String modelo = resultSet.getString("modelo");
                boolean situacao = resultSet.getBoolean("situacao");
                Modal modal = new Modal(codigo, capacidade, anoFabricacao, tipo, modelo, situacao);
                modais.add(modal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return modais;
    }
}

