package model;

public class Gerente extends Funcionario {
    
    private PontoDeVenda pontoDeVenda;

    public Gerente() {
        this.pontoDeVenda = new PontoDeVenda();
    }

    public Gerente(int codigo, PontoDeVenda pontoDeVenda) {

    }

    public PontoDeVenda getPontoDeVenda() {
        return pontoDeVenda;
    }

    public void setPontoDeVenda(PontoDeVenda pontoDeVenda) {
        this.pontoDeVenda = pontoDeVenda;
    }
    
    public void aprovarVenda() {
        super.getReserva().setStatus(true);
    }

    public void desaprovarVenda() {
        super.getReserva().setStatus(false);
    }

    public void alocarFuncionario(Funcionario funcionario) {
        pontoDeVenda.adicionarFuncionario(funcionario);
    }

    public void desalocarFuncionario(Funcionario funcionario) {
        pontoDeVenda.removerFuncionario(funcionario);
    }

    
}
