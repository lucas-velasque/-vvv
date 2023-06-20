
package dao;

import com.mysql.jdbc.MySQLConnection;

import java.util.ArrayList;
import model.Reserva;
import java.sql.*;
import java.util.List;

public class ReservaDao {
    private static final String URL = "jdbc:mysql://localhost:3306/bancoDeDados";
    private static final String USUARIO = "admin";
    private static final String SENHA = "1234";

    public void criarReserva(Reserva reserva) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "INSERT INTO reserva (codigo, date, tipo_passagem, hora_partida, hora_chegada, valor, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, reserva.getCodigo());
            statement.setString(2, reserva.getData());
            statement.setString(3, reserva.getTipoPassagem());
            statement.setString(4, reserva.getHoraPartida());
            statement.setString(5, reserva.getHoraChegada());
            statement.setFloat(6, reserva.getValor());
            statement.setBoolean(7, reserva.isStatus());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Reserva buscarReservaPorCodigo(int codigo) {
        Reserva reserva = null;

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT * FROM reserva WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, codigo);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String date = resultSet.getString("date");
                String tipoPassagem = resultSet.getString("tipo_passagem");
                String horaPartida = resultSet.getString("hora_partida");
                String horaChegada = resultSet.getString("hora_chegada");
                float valor = resultSet.getFloat("valor");
                boolean status = resultSet.getBoolean("status");
                reserva = new Reserva(codigo, date, tipoPassagem, horaPartida, horaChegada, valor, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reserva;
    }

    public void atualizarReserva(Reserva reserva) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "UPDATE reserva SET date = ?, tipo_passagem = ?, hora_partida = ?, hora_chegada = ?, valor = ?, status = ? WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, reserva.getData());
            statement.setString(2, reserva.getTipoPassagem());
            statement.setString(3, reserva.getHoraPartida());
            statement.setString(4, reserva.getHoraChegada());
            statement.setFloat(5, reserva.getValor());
            statement.setBoolean(6, reserva.isStatus());
            statement.setInt(7, reserva.getCodigo());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarReserva(int codigo) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "DELETE FROM reserva WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, codigo);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Reserva> listarReservas() {
        List<Reserva> reservas = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT * FROM reserva";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                String date = resultSet.getString("date");
                String tipoPassagem = resultSet.getString("tipo_passagem");
                String horaPartida = resultSet.getString("hora_partida");
                String horaChegada = resultSet.getString("hora_chegada");
                float valor = resultSet.getFloat("valor");
                boolean status = resultSet.getBoolean("status");
                Reserva reserva = new Reserva(codigo, date, tipoPassagem, horaPartida, horaChegada, valor, status);
                reservas.add(reserva);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reservas;
    }
}

