/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dao.ClienteDao;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author lgcp1
 */
public class Cliente {
    private int idCliente;
    private String nome;
    private String senha;
    private String profissao;
    private double cpf;
    private double telefone;
    private String endereco;
    private String login;
    private String codClient;
    private String tipoPagamento;
    private Cidade cidadeOrigem;
    private Cidade cidadeDestino;
    private Pagamento pagamento;
    private List<Reserva> reservas;
    private List<Modal> modais;


    public Cliente(){   
        this.cidadeOrigem = new Cidade(); 
        this.cidadeDestino = new Cidade();
        this.pagamento = new Pagamento();
    }

    public Cliente(int idCliente, String nome,String login, String senha, String profissao, double cpf, double telefone, String endereco){
        this.idCliente = idCliente;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.profissao = profissao;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco; 
    }
 
    public Cliente(String login, String senha){
        this.nome = login;
        this.senha = senha;
    }
   
    public Cliente(String nome, Reserva reservas, Modal modal) {
        this.nome = nome;
        this.reservas.add(reservas);
        this.modais.add(modal);;
    }

    
    public Cliente( int idCliente, String nome, String senha, String profissao, int cpf, 
                    int telefone, String endereco, String login, String codCliente, 
                    String tipoPagamento) 
    {
        this.idCliente = idCliente;
        this.nome = nome;
        this.senha = senha;
        this.profissao = profissao;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.login = login;
        this.codClient = codCliente;
        this.tipoPagamento = tipoPagamento;
    }

    public void salvar(){
        new ClienteDao().cadastrarCliente(this);
    }
    public boolean auth(){
        return new ClienteDao().authCliente(this);  
    }
    public String codCliente(){
        UUID uuid = UUID.randomUUID();
        String myRandom = uuid.toString();
        return myRandom.substring(0,8);
    }

    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getSenha() {
        return senha;
    }


    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdCliente() {
        return idCliente;
    }


    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }


    public String getProfissao(){
        return profissao;
    }


    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }


    public double getCpf() {
        return cpf;
    }


    public void setCpf(int cpf) {
        this.cpf = cpf;
    }


    public double getTelefone() {
        return telefone;
    }


    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }


    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCodClient() {
        return codClient;
    }
   
      public void setCodClient(String codClient) {
        this.codClient = codClient;
    }

    public void setCpf(double cpf) {
        this.cpf = cpf;
    }

    public void setTelefone(double telefone) {
        this.telefone = telefone;
    }
    
    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public List<Modal> getModais() {
        return modais;
    }

    public void setModais(List<Modal> modais) {
        this.modais = modais;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public Cidade getCidadeOrigem() {
        return cidadeOrigem;
    }

    public void setCidadeOrigem(Cidade cidadeOrigem) {
        this.cidadeOrigem = cidadeOrigem;
    }

    public Cidade getCidadeDestino() {
        return cidadeDestino;
    }

    public void setCidadeDestino(Cidade cidadeDestino) {
        this.cidadeDestino = cidadeDestino;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

     public void realizarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public void cancelarReserva(Reserva reserva) {
        reservas.remove(reserva);
    }

    public String escolherPagamento(String tipoPagamento) {
        if(!tipoPagamento.equals("Crédito") || !tipoPagamento.equals("Débito")) {
            return "Método invalido!";
        } 
        this.tipoPagamento = tipoPagamento;
        return this.tipoPagamento + " escolhido!";
    }

    public Cidade escolherCidadeOrigem(Cidade cidadeOrigem) {
        if(cidadeOrigem != null) {
            this.cidadeOrigem = cidadeOrigem;
            return this.cidadeOrigem;
        } 
        return null;
    }
    
    public Cidade escolherCidadeDestino(Cidade cidadeDestino) {
        if(cidadeDestino != null) {
            this.cidadeDestino = cidadeDestino;
            return this.cidadeDestino;
        } 
        return null;
    }


}