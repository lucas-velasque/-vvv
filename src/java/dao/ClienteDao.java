/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import model.Cliente;

import com.mysql.jdbc.MySQLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;

/**
 *
 * @author lgcp1
 */
public class ClienteDao {

    private static final String URL = "jdbc:mysql://localhost:3306/bancoDeDados";
    private static final String USUARIO = "admin";
    private static final String SENHA = "1234";;
    private Cliente cliente;

    public ClienteDao() {
        cliente = new Cliente();
    }
    
    public void cadastrarCliente(Cliente cliente){
        String sql = "INSERT INTO CLIENTE VALUES (null, ?, ?, ? ,? ,? ,? ,? ,?)";
        PreparedStatement pStatement = null; 
        Connection conn = null;
        
        try {
            conn = new MysqlConnection().getConnection();
            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, cliente.getNome());
            pStatement.setString(2, cliente.getProfissao());
            pStatement.setString(3, cliente.codCliente());
            pStatement.setDouble(4, cliente.getCpf());
            pStatement.setDouble(5, cliente.getTelefone());
            pStatement.setString(6, cliente.getLogin());
            pStatement.setString(7, cliente.getSenha());
            pStatement.setString(8, cliente.getEndereco());
            pStatement.execute();
              
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(pStatement != null){
                    pStatement.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                if(conn != null){
                    conn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    
    
public boolean authCliente(Cliente cliente){
        String sql = "SELECT * FROM CLIENTE WHERE login = ? and senha = ?";
        ResultSet rs = null;
        PreparedStatement pStatement = null; 
        Connection conn = null;
        try {
            conn = new MysqlConnection().getConnection();
            pStatement = conn.prepareStatement(sql);
            pStatement.setString(2, cliente.getSenha());
            pStatement.setString(1, cliente.getNome());
            
            rs = pStatement.executeQuery();
            
            if(rs.next()){
                return true;
            }else{
                return false;
            }
              
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{
            try {
                if(pStatement != null){
                    pStatement.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                if(conn != null){
                    conn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    
    }

    public void salvarCliente(Cliente cliente) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "INSERT INTO cliente (codigo, idCliente, nome, senha, profissao, cpf, telefone, endereco, login, codClient, tipoPagamento) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, cliente.getCodClient());
            statement.setInt(2, cliente.getIdCliente());
            statement.setString(3, cliente.getNome());
            statement.setString(4, cliente.getSenha());
            statement.setString(5, cliente.getProfissao());
            statement.setDouble(6, cliente.getCpf());
            statement.setDouble(7, cliente.getTelefone());
            statement.setString(8, cliente.getEndereco());
            statement.setString(9, cliente.getLogin());
            statement.setString(10, cliente.getCodClient());
            statement.setString(11, cliente.getTipoPagamento());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Cliente buscarClientePorCodigo(int codigo) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT * FROM cliente WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, codigo);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int idCliente = resultSet.getInt("idCliente");
                String nome = resultSet.getString("nome");
                String senha = resultSet.getString("senha");
                String profissao = resultSet.getString("profissao");
                int cpf = resultSet.getInt("cpf");
                int telefone = resultSet.getInt("telefone");
                String endereco = resultSet.getString("endereco");
                String login = resultSet.getString("login");
                String codClient = resultSet.getString("codClient");
                String tipoPagamento = resultSet.getString("tipoPagamento");
                return new Cliente(idCliente, nome, senha, profissao, cpf, telefone, endereco, login, codClient,tipoPagamento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void atualizarCliente(Cliente cliente) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "UPDATE cliente SET idCliente = ?, nome = ?, senha = ?, profissao = ?, cpf = ?, telefone = ?, endereco = ?, " +
                    "login = ?, codClient = ?, tipoPagamento = ? WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, cliente.getIdCliente());
            statement.setString(2, cliente.getNome());
            statement.setString(3, cliente.getSenha());
            statement.setString(4, cliente.getProfissao());
            statement.setDouble(5, cliente.getCpf());
            statement.setDouble(6, cliente.getTelefone());
            statement.setString(7, cliente.getEndereco());
            statement.setString(8, cliente.getLogin());
            statement.setString(9, cliente.getCodClient());
            statement.setString(10, cliente.getTipoPagamento());
            statement.setString(11, cliente.getCodClient());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarCliente(int codigo) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "DELETE FROM cliente WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, codigo);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT * FROM cliente";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                int idCliente = resultSet.getInt("idCliente");
                String nome = resultSet.getString("nome");
                String senha = resultSet.getString("senha");
                String profissao = resultSet.getString("profissao");
                int cpf = resultSet.getInt("cpf");
                int telefone = resultSet.getInt("telefone");
                String endereco = resultSet.getString("endereco");
                String login = resultSet.getString("login");
                String codClient = resultSet.getString("codClient");
                String tipoPagamento = resultSet.getString("tipoPagamento");
                clientes.add(new Cliente(idCliente, nome, senha, profissao, cpf, telefone, endereco, login, codClient,tipoPagamento));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientes;
    }
}


 