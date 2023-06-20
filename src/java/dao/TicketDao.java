
package dao;
import model.Ticket;

import com.mysql.jdbc.MySQLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketDao {
    private static final String URL = "jdbc:mysql://localhost:3306/bancoDeDados";
    private static final String USUARIO = "admin";
    private static final String SENHA = "1234";

    public void criarTicket(Ticket ticket) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "INSERT INTO ticket (codigo, numero, tipo_passagem, hora_partida, hora_chegada) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, ticket.getCodigo());
            statement.setInt(2, ticket.getNumero());
            statement.setString(3, ticket.getTipoPassagem());
            statement.setString(4, ticket.getHoraPartida());
            statement.setString(5, ticket.getHoraChegada());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Ticket buscarTicketPorCodigo(int codigo) {
        Ticket ticket = null;

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT * FROM ticket WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, codigo);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int numero = resultSet.getInt("numero");
                String tipoPassagem = resultSet.getString("tipo_passagem");
                String horaPartida = resultSet.getString("hora_partida");
                String horaChegada = resultSet.getString("hora_chegada");
                ticket = new Ticket(codigo, numero, tipoPassagem, horaPartida, horaChegada);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ticket;
    }

    public void atualizarTicket(Ticket ticket) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "UPDATE ticket SET numero = ?, tipo_passagem = ?, hora_partida = ?, hora_chegada = ? WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, ticket.getNumero());
            statement.setString(2, ticket.getTipoPassagem());
            statement.setString(3, ticket.getHoraPartida());
            statement.setString(4, ticket.getHoraChegada());
            statement.setInt(5, ticket.getCodigo());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarTicket(int codigo) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "DELETE FROM ticket WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, codigo);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Ticket> listarTickets() {
        List<Ticket> tickets = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT * FROM ticket";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                int numero = resultSet.getInt("numero");
                String tipoPassagem = resultSet.getString("tipo_passagem");
                String horaPartida = resultSet.getString("hora_partida");
                String horaChegada = resultSet.getString("hora_chegada");
                Ticket ticket = new Ticket(codigo, numero, tipoPassagem, horaPartida, horaChegada);
                tickets.add(ticket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tickets;
    }
}

