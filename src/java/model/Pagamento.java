package model;

public class Pagamento {
    
    private int codigo;
    private float valor;
    private int qtdParcelas;
    private boolean status;
    private boolean aprovado;
    private Cliente cliente;

    public Pagamento() {   
        this.cliente = new Cliente();
    }

    public Pagamento(int codigo, float valor, int qtdParcelas, boolean status) {
        this.codigo = codigo;
        this.valor = valor;
        this.qtdParcelas = qtdParcelas;
        this.status = status;
    }

    public Pagamento(Cliente cliente, int codigo, float valor, int qtdParcelas, boolean status) {
        this.codigo = codigo;
        this.valor = valor;
        this.qtdParcelas = qtdParcelas;
        this.status = status;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getQtdParcelas() {
        return qtdParcelas;
    }

    public void setQtdParcelas(int qtdParcelas) {
        this.qtdParcelas = qtdParcelas;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    public int verificarPagamento() {
        if(status) {
            return 1;
        } 
        return 0;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pagamento processarPagamento(Pagamento pagamento) {
        
        if(verificarPagamento() == 1) {
            if(cliente.getTipoPagamento().equals("Crédito") || 
            cliente.getTipoPagamento().equals("Débito")) 
            {
                return pagamento;
            }
        } 
        return null;
    }
    

    @Override
    public String toString() {
        return "Pagamento [codigo=" + codigo + ", valor=" + valor + ", qtdParcelas=" + qtdParcelas + ", status="
                + status + "]";
    }

    
}
