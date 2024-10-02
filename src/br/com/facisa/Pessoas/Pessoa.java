package br.com.facisa.Pessoas;

public abstract class Pessoa {

    private String cpf;
    private String nome;
    private String endereco;
    private String numeroTelefone;
    private String dataNascimento;

    public Pessoa(String cpf, String nome, String endereco, String numeroTelefone, String dataNascimento) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.numeroTelefone = numeroTelefone;
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return
                "\nCPF: " + cpf +
                "\nNome: " + nome +
                "\nEndereco: " + endereco +
                "\nTelefone: " + numeroTelefone +
                "\nData de Nascimento: " + dataNascimento;

    }

}
