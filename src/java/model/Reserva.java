package model;

import java.time.LocalTime;

public class Reserva {

    private int codigo, numero;
    private String data, tipoPassagem, horaPartida, horaChegada;
    private float valor;
    private boolean status;
    private Ticket ticket;

    public Reserva(){
        this.ticket = new Ticket();
    }

    public Reserva(int codigo, String date, float valor) {
        this.codigo = codigo;
        this.data = date;
        this.valor = valor;
        this.status = false; //quem confirma a reserva é o funcionário
    }

    public Reserva(int codigo, String data, String tipoPassagem, String horaPartida, String horaChegada, float valor, boolean status) {
        this.codigo =codigo;
        this.data = data;
        this.tipoPassagem = tipoPassagem;
        this.horaPartida = horaPartida;
        this.horaChegada = horaChegada;
        this.valor = valor;
        this.status = status;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    
    public String getTipoPassagem() {
        return tipoPassagem;
    }

    public void setTipoPassagem(String tipoPassagem) {
        this.tipoPassagem = tipoPassagem;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getHoraPartida() {
        return horaPartida;
    }

    public void setHoraPartida(String horaPartida) {
        this.horaPartida = horaPartida;
    }

    public String getHoraChegada() {
        return horaChegada;
    }

    public void setHoraChegada(String horaChegada) {
        this.horaChegada = horaChegada;
    }


    public void emitirTicket() {
        LocalTime horaAtual = LocalTime.now();
        LocalTime horaPartida = horaAtual.plusHours(2);  // Hora de partida 2 horas após o momento atual
        LocalTime horaChegada = horaPartida.plusHours(3);  // Hora de chegada 3 horas após a hora de partida

        this.horaPartida = horaPartida.toString();
        this.horaChegada = horaChegada.toString();

        this.ticket = new Ticket(codigo, numero, this.horaPartida, this.horaChegada, tipoPassagem);
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "codigo=" + codigo +
                ", date='" + data + '\'' +
                ", valor=" + valor +
                ", status=" + status +
                '}';
    }
}
