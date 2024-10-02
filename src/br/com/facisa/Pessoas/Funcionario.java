package br.com.facisa.Pessoas;

import br.com.facisa.Enum.Turno;

public class Funcionario extends Pessoa{

    private String cargo;
    private Turno turnoTrabalho;
    private double salario;


    public Funcionario(String cpf, String nome, String endereco, String numeroTelefone, String dataNascimento, String cargo, Turno turnoTrabalho, double salario) {
        super(cpf, nome, endereco, numeroTelefone, dataNascimento);
        this.cargo = cargo;
        this.turnoTrabalho = turnoTrabalho;
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Turno getTurnoTrabalho() {
        return turnoTrabalho;
    }

    public void setTurnoTrabalho(Turno turnoTrabalho) {
        this.turnoTrabalho = turnoTrabalho;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "\nCargo: " + cargo +
                "\nTurno Trabalhado: " + turnoTrabalho +
                "\nSalário Mensal: " + salario +
                "\n------------------------------------------------\n";

    }
}
