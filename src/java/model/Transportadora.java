package model;

import java.util.List;

public class Transportadora {
    private int codigo;
    private List<Modal> modais;
    
    public Transportadora() {}

    public Transportadora(int codigo) {
        this.codigo = codigo;
    }

    public Transportadora(int codigo, Modal modal) {
        this.codigo = codigo;
        this.modais.add(modal);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public List<Modal> getModais() {
        return modais;
    }

    public void setModais(List<Modal> modais) {
        this.modais = modais;
    }
    
    public void adicionarModal(Modal modal) {
        modais.add(modal);
    }

    public void removerModal(Modal modal) {
        modais.remove(modal);
    }
    
    public void realizarManutencao(Modal modal) {
         if (modais.contains(modal)) {
            modal.setSituacao(true);
        } 
        modal.setSituacao(false);
    }

    public String informarManutencao(Modal modal) {
        if (modais.contains(modal)) {
            return "Modal " + modal.getTipo() + " em manutencao!";
        } 
         return "Modal não encontrado!";
    }

    public String verificarStatusModal(Modal modal) {
        if(modal.isSituacao()) {
            return "Em manutencao!";
        } 
        return "Funcionando normalmente.";
    }

    @Override
    public String toString() {
        return "Transportadora [codigo=" + codigo + ", modais=" + modais + "]";
    }
    
    
}
