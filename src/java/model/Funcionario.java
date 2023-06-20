package model;

import java.util.ArrayList;

public class Funcionario {
   
    private int codigo;
    private String nome;
    private String endereco;
    private Reserva reserva;
    private ArrayList<Cliente> clientes;
    private ArrayList<Reserva> reservas;

    public Funcionario() {
        this.clientes = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public Funcionario(int codigo, String nome, String endereco) {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.reservas = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    } 

    public Cliente venderPassagem(Cliente cliente) {
        if(cliente.getPagamento() != null) {
            if(cliente.getReservas() != null) {
                return cliente;
            }
        }
        return null;
    }

    public String verificarPagamento(Cliente cliente) {
        if(cliente.getPagamento() != null) {
            return "Pagamento ok!";
        } 
        return "Pagamento não confirmado";
    }

    public String confirmarReserva(Cliente cliente) {
        if(!cliente.getPagamento().isAprovado()) {
            reserva.setStatus(false);
            return "Impossivel confirmar reserva, pagamento nao realizado.";
        }
        reserva.setStatus(true);
        return "Reserva confirmada!";
    }


    
}

