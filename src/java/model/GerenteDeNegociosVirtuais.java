package model;

public class GerenteDeNegociosVirtuais extends Funcionario {
    

    public void aprovarVenda() {
        super.getReserva().setStatus(true);
    }

    public void desaprovarReserva() {
        super.getReserva().setStatus(false);
    }
}
