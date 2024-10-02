package br.com.facisa.Reservas;

import br.com.facisa.Enum.StatusQuarto;
import br.com.facisa.Enum.StatusReserva;
import br.com.facisa.Pessoas.Hospede;
import br.com.facisa.Quartos.Quarto;

public class Reserva {

    private int idReserva;
    private Hospede hospede;
    private Quarto quarto;
    private String dataInicioReserva;
    private String dataFimReserva;
    private StatusReserva statusReserva;


    private static int contador = 1;

    public Reserva(Hospede hospede, Quarto quarto, String dataInicioReserva, String dataFimReserva) {
        this.idReserva = contador++;
        this.hospede = hospede;
        this.quarto = quarto;
        this.dataInicioReserva = dataInicioReserva;
        this.dataFimReserva = dataFimReserva;
        this.statusReserva = StatusReserva.AGENDADO;
        this.quarto.setStatusQuarto(StatusQuarto.OCUPADO);

    }

    public Reserva(Hospede hospede, Quarto quarto, String dataInicioReserva, String dataFimReserva, StatusReserva statusReserva) {
        this.idReserva = contador++;
        this.hospede = hospede;
        this.quarto = quarto;
        this.dataInicioReserva = dataInicioReserva;
        this.dataFimReserva = dataFimReserva;
        this.statusReserva = StatusReserva.AGENDADO;
        this.quarto.setStatusQuarto(StatusQuarto.OCUPADO);

    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public String getDataInicioReserva() {
        return dataInicioReserva;
    }

    public void setDataInicioReserva(String dataInicioReserva) {
        this.dataInicioReserva = dataInicioReserva;
    }

    public String getDataFimReserva() {
        return dataFimReserva;
    }

    public void setDataFimReserva(String dataFimReserva) {
        this.dataFimReserva = dataFimReserva;
    }

    public StatusReserva getStatusReserva() {
        return statusReserva;
    }

    public void setStatusReserva(StatusReserva statusReserva) {
        this.statusReserva = statusReserva;
    }


    @Override
    public String toString() {
        return  "\nID Reserva: " + idReserva +
                "\nHospede: " + hospede.getNome() +
                "\nInicio Reserva: " + dataInicioReserva +
                "\nFim Reserva: " + dataFimReserva +
                "\nNúmero Quarto: " + quarto.getNumeroQuarto() +
                "\nValor Diária: " + quarto.getValorDiaria() +
                "\nStatus Reserva: " + statusReserva +
                "\n----------------------------------------------------------\n";
    }


}
