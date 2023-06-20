package model;

public class Modal {
    private int codigo;
    private int capacidade, anoFabricacao, qtdPessoas;
    private String tipo, modelo;
    private boolean situacao;

    public Modal(){}

    public Modal(int codigo, int capacidade, int anoFabricacao, String tipo, String modelo, boolean situacao) {
        this.capacidade = capacidade;
        this.anoFabricacao = anoFabricacao;
        this.tipo = tipo;
        this.modelo = modelo;
        this.situacao = situacao;
    }

    public Modal(int codigo, int capacidade, int anoFabricacao, int qtdPessoas, String tipo, String modelo, boolean situacao) {
        this.capacidade = capacidade;
        this.anoFabricacao = anoFabricacao;
        this.tipo = tipo;
        this.modelo = modelo;
        this.situacao = situacao;
    }

    public Modal(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return capacidade;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }


    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo + "Modal [capacidade=" + capacidade + ", anoFabricacao=" + anoFabricacao + ", tipo=" + tipo + ", modelo="
                + modelo + ", situacao=" + situacao + "]";
    }

    public int getQtdPessoas() {
        return qtdPessoas;
    }

    public void setQtdPessoas(int qtdPessoas) {
        this.qtdPessoas = qtdPessoas;
    }


}