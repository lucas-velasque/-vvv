package model;

import java.util.ArrayList;
import java.util.List;

public class PontoDeVenda {
    private int codigo;
    private String nome;
    private String cnpj;
    private String endereco;
    private int telefone;
    private List<Funcionario> funcionario;

    public PontoDeVenda() {
        this.funcionario = new ArrayList<>();
    }

    public PontoDeVenda(int codigo, String nome, String cnpj, String endereco, int telefone) {
        this.codigo = codigo;
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
        this.funcionario = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public List<Funcionario> getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(List<Funcionario> funcionario) {
        this.funcionario = funcionario;
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        this.funcionario.add(funcionario);
    }

    public void removerFuncionario(Funcionario funcionario) {
        this.funcionario.remove(funcionario);
    }

    @Override
    public String toString() {
        return "PontoDeVenda{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", endereco='" + endereco + '\'' +
                ", telefone=" + telefone +
                ", funcionario=" + funcionario +
                '}';
    }
}

