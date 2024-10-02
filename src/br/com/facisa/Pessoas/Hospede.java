package br.com.facisa.Pessoas;

import br.com.facisa.Reservas.Reserva;

import java.util.ArrayList;

public class Hospede extends Pessoa {

    private String tipoEstadia;
    private ArrayList<Reserva> historicoEstadia;

    public Hospede(String cpf, String nome, String endereco, String numeroTelefone, String dataNascimento, String tipoEstadia) {
        super(cpf, nome, endereco, numeroTelefone, dataNascimento);
        this.tipoEstadia = tipoEstadia;
    }

    public String getTipoEstadia() {
        return tipoEstadia;
    }

    public void setTipoEstadia(String tipoEstadia) {
        this.tipoEstadia = tipoEstadia;
    }

    public ArrayList<Reserva> getHistoricoEstadia() {
        if (historicoEstadia == null) {
            return null;
        }
        return this.historicoEstadia;
    }

    public void setHistoricoEstadia(Reserva reserva) {
        if (historicoEstadia == null) {
            historicoEstadia = new ArrayList<>();
        }
        this.historicoEstadia.add(reserva);
    }

    @Override
    public String toString() {
        return  super.toString() +
                "\nTipo de Estadia: " + tipoEstadia +
                "\n--------------------------------------------\n";
    }
}