package model;

public class Cidade {

    private String nome;
    private int codigo;
    private String identificador;

    public Cidade() {}

    public Cidade(String nome, String identificador) {
        this.nome = nome;
        this.identificador = identificador;
    }

    public Cidade(String nome, int codigo, String identificador) {
        this.nome = nome;
        this.codigo = codigo;
        this.identificador = identificador;
    }

    public Cidade(int codigo, String nome, String identificador) {
        this.codigo = codigo;
        this.nome = nome;
        this.identificador = identificador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "nome='" + nome + '\'' +
                ", codigo=" + codigo +
                ", identificador='" + identificador + '\'' +
                '}';
    }

}

