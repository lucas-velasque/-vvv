package model;

public class Ticket {
    
    private int codigo, numero;
    private String tipoPassagem,  horaPartida, horaChegada;

    public Ticket() {}

    
    public Ticket(int codigo, int numero, String horaPartida, String horaChegada, String tipoPassagem) {
        this.codigo = codigo;
        this.numero = numero;
        this.horaPartida = horaPartida;
        this.horaChegada = horaChegada;
        this.tipoPassagem = tipoPassagem;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public String getTipoPassagem() {
        return tipoPassagem;
    }

    public void setTipoPassagem(String tipoPassagem) {
        this.tipoPassagem = tipoPassagem;
    }

    public String imprimirTicket() {
       return   "Codigo: " + codigo + 
                "\nNumero=" + numero + 
                "\nHora de Partida: " + horaPartida + 
                "\nHora de Chegada: " + horaChegada +
                "Tipo de Passagem: " + tipoPassagem;
    }

}
