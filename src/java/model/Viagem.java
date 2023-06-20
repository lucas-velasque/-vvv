package model;

import java.util.List;

public class Viagem {
    
    private int codigo;
    private boolean viagemDireta;
    private boolean viagemEscala;
    private Cidade cidadeOrigem;
    private Cidade cidadeDestino;
    private Cliente cliente;
    private Reserva reserva;
    private List<Modal> modais;
   
   
    public Viagem(){
        cidadeOrigem = new Cidade();
        cidadeDestino = new Cidade();
    }
    
    public Viagem(int codigo, Cidade cidadeOrigem, Cidade cidadeDestino, boolean viagemDireta, boolean viagemEscala) {
        this.codigo = codigo;
        this.cidadeOrigem = cidadeOrigem;
        this.cidadeDestino = cidadeDestino;
        this.viagemDireta = viagemDireta;
        this.viagemEscala = viagemEscala;
    }

    public Viagem(Cliente cliente, Modal modal, Cidade cidadeOrigem, Cidade cidadeDestino) {
        this.cliente = cliente;
        this.modais.add(modal);
        this.cidadeOrigem = cidadeOrigem;
        this.cidadeDestino = cidadeDestino;

    }

    public Viagem(int codigo, boolean viagemDireta, boolean viagemEscala, Cliente cliente, Reserva reserva) {
        this.codigo = codigo;
        this.viagemDireta = viagemDireta;
        this.viagemEscala = viagemEscala;
        this.cliente = cliente;
        this.reserva = reserva;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public boolean isViagemDireta() {
        return viagemDireta;
    }

    public void setViagemDireta(boolean viagemDireta) {
        this.viagemDireta = viagemDireta;
    }

    public boolean isViagemEscala() {
        return viagemEscala;
    }

    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public List<Modal> getModais() {
        return modais;
    }

    public void setModais(List<Modal> modais) {
        this.modais = modais;
    }

    public void setViagemEscala(boolean viagemEscala) {
        this.viagemEscala = viagemEscala;
    }

    public String mostrarRoteiro() {
        return  "Cidade de origem: " + cidadeOrigem.getNome() + " " + cidadeOrigem.getIdentificador() +
                "\nCidade de destino: "  + cidadeDestino.getNome() + " " + cidadeDestino.getIdentificador();

    }

    @Override
    public String toString() {
        return "Viagem [codigo=" + codigo + ", cidadeOrigem=" + cidadeOrigem + ", cidadeDestino=" + cidadeDestino
                + ", viagemDireta=" + viagemDireta + ", viagemEscala=" + viagemEscala + "]";
    }

    
}
