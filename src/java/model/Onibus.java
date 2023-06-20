package model;

public class Onibus extends Modal {
    
    private int codigo;

    public Onibus(){}

    public Onibus(int codigo) {
        this.codigo = codigo;
    }

    public Onibus(int codigo, int capacidade, int anoFabricacao, String tipo, String modelo, boolean situacao) {
        this.codigo = codigo;
        super.setCapacidade(capacidade);;
        super.setAnoFabricacao(anoFabricacao);
        super.setTipo(tipo);
        super.setModelo(modelo);
        super.setSituacao(situacao);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public boolean consultarSituacaoModal() { 
        return super.isSituacao();
    }

    public String verificarCapacidade() {
        
        if(super.getQtdPessoas() > super.getCapacidade()) {
            return "Onibus acima da capacidade!";
        } 
        
        return "Capacidade OK!";
    }

    @Override
    public String toString() {
        return "Onibus [codigo=" + codigo + "]";
    }
}

