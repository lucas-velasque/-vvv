package dao;

import com.mysql.jdbc.MySQLConnection;

import java.sql.*;

import model.Viagem;
import model.Reserva;
import model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ViagemDao {
    private static final String URL = "jdbc:mysql://localhost:3306/bancoDeDados";
    private static final String USUARIO = "admin";
    private static final String SENHA = "1234";
    private Cliente cliente;
    private Reserva reserva;

    public void criarViagem(Viagem viagem) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "INSERT INTO viagem (codigo, viagem_direta, viagem_escala, cidade_origem, cidade_destino, cliente, reserva) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, viagem.getCodigo());
            statement.setBoolean(2, viagem.isViagemDireta());
            statement.setBoolean(3, viagem.isViagemEscala());
            statement.setInt(4, viagem.getCidadeOrigem().getCodigo());
            statement.setInt(5, viagem.getCidadeDestino().getCodigo());
            statement.setString(6, viagem.getCliente().getCodClient());
            statement.setInt(7, viagem.getReserva().getCodigo());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Viagem buscarViagemPorCodigo(int codigo) {
        Viagem viagem = null;

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT * FROM viagem WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, codigo);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                boolean viagemDireta = resultSet.getBoolean("viagem_direta");
                boolean viagemEscala = resultSet.getBoolean("viagem_escala");
                viagem = new Viagem(codigo, viagemDireta, viagemEscala, cliente, reserva);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return viagem;
    }

    public void atualizarViagem(Viagem viagem) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "UPDATE viagem SET viagem_direta = ?, viagem_escala = ?, cidade_origem = ?, cidade_destino = ?, cliente = ?, reserva = ? WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setBoolean(1, viagem.isViagemDireta());
            statement.setBoolean(2, viagem.isViagemEscala());
            statement.setInt(3, viagem.getCidadeOrigem().getCodigo());
            statement.setInt(4, viagem.getCidadeDestino().getCodigo());
            statement.setString(5, viagem.getCliente().getCodClient());
            statement.setInt(6, viagem.getReserva().getCodigo());
            statement.setInt(7, viagem.getCodigo());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarViagem(int codigo) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "DELETE FROM viagem WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, codigo);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Viagem> listarViagens() {
        List<Viagem> viagens = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT * FROM viagem";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                boolean viagemDireta = resultSet.getBoolean("viagem_direta");
                boolean viagemEscala = resultSet.getBoolean("viagem_escala");
                Viagem viagem = new Viagem(codigo, viagemDireta, viagemEscala, cliente, reserva);
                viagens.add(viagem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return viagens;
    }
}
