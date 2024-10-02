package br.com.facisa.Quartos;

import br.com.facisa.Enum.StatusQuarto;
import br.com.facisa.Enum.TipoQuarto;

public class Quarto {

    private String numeroQuarto;
    private TipoQuarto tipoQuarto;
    private int capacidadeQuarto;
    private StatusQuarto statusQuarto;
    private double valorDiaria;

    public Quarto(String numeroQuarto, TipoQuarto tipoQuarto, int capacidadeQuarto, StatusQuarto statusQuarto, double valorDiaria) {
        this.numeroQuarto = numeroQuarto;
        this.tipoQuarto = tipoQuarto;
        this.capacidadeQuarto = capacidadeQuarto;
        this.statusQuarto = statusQuarto;
        this.valorDiaria = valorDiaria;
    }

    public String getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(String numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public TipoQuarto getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(TipoQuarto tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public int getCapacidadeQuarto() {
        return capacidadeQuarto;
    }

    public void setCapacidadeQuarto(int capacidadeQuarto) {
        this.capacidadeQuarto = capacidadeQuarto;
    }

    public StatusQuarto getStatusQuarto() {
        return statusQuarto;
    }

    public void setStatusQuarto(StatusQuarto statusQuarto) {
        this.statusQuarto = statusQuarto;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    @Override
    public String toString() {
        return  "\nNumero do Quarto: " + numeroQuarto +
                "\nTipo Quarto: " + tipoQuarto  +
                "\nCapacidade: " + capacidadeQuarto + " Pessoas" +
                "\nStatus: " + statusQuarto +
                "\nValor Diaria: " + valorDiaria + " Reais" +
                "\n----------------------------------------------------------\n";

    }

}
