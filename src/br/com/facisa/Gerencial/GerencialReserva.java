package br.com.facisa.Gerencial;

import br.com.facisa.Enum.StatusQuarto;
import br.com.facisa.Enum.StatusReserva;
import br.com.facisa.Pessoas.Hospede;
import br.com.facisa.Reservas.Reserva;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class GerencialReserva {

    ArrayList<Reserva> listaReservas = new ArrayList<Reserva>();



    public boolean adiconarReservaLista(Reserva novaReserva) {
        if(listaReservas.isEmpty()){
            listaReservas.add(novaReserva);
            return true;
        }
        listaReservas.add(novaReserva);
        return true;
    }


    public ArrayList<Reserva> listarReservas() {
        return listaReservas;
    }

    public boolean excluirReservaPeloId(int numeroIdReserva) {
        boolean foiRemovido = false;

        for (Reserva item : listaReservas) {
            if (item.getIdReserva() == numeroIdReserva) {
                listaReservas.remove(item);
                foiRemovido = true;
                break;
            }
        }
        return foiRemovido;
    }

    public void adicionarHistoricoReserva(Reserva reserva, Hospede hospede) {
        hospede.setHistoricoEstadia(reserva);
    }

    public ArrayList<Reserva> listarHistoricoReservaHospede(Hospede hospede) {
        if (hospede.getHistoricoEstadia() == null) {
            return null;
        }
        return hospede.getHistoricoEstadia();
    }

    public boolean checkIn(Reserva reserva){
        StatusReserva status = StatusReserva.INICIADO;
        reserva.setStatusReserva(status);
        reserva.getQuarto().setStatusQuarto(StatusQuarto.OCUPADO);
        //adiciona reserva no historico do hospede
        Hospede hospede = reserva.getHospede();
        adicionarHistoricoReserva(reserva, hospede);
        return true;

    }

    public double checkOut(Reserva reserva) {
        //permite ckeckout apenas de status iniciado
        if (reserva.getStatusReserva() != StatusReserva.INICIADO) {
            return 0.0;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String inicioDaReservaStr = reserva.getDataInicioReserva();
        LocalDate inicioDaReserva = LocalDate.parse(inicioDaReservaStr, formatter);

        String fimDaReservaStr = reserva.getDataFimReserva();
        LocalDate fimDaReserva = LocalDate.parse(fimDaReservaStr, formatter);
        //atualiza status de reserva para encerrado
        StatusReserva status = StatusReserva.ENCERRADO;
        reserva.setStatusReserva(status);
        //atualiza quarto para manutenção e após 1 dia quarto fica disponivel
        reserva.getQuarto().setStatusQuarto(StatusQuarto.MANUTENCAO);
        LocalDate dataManutencao = fimDaReserva.plusDays(1);
        reserva.getQuarto().setStatusQuarto(StatusQuarto.DISPONIVEL);
        //garante pelo menos 1 dia para caucular valor do quarto
        long diasEstadia = ChronoUnit.DAYS.between(inicioDaReserva, fimDaReserva);
        if (diasEstadia == 0) {
            diasEstadia = 1;
        }
        //exclui reserva da lista opós status ecerrado
        excluirReservaPeloId(reserva.getIdReserva());

        return diasEstadia * reserva.getQuarto().getValorDiaria();
    }

    public Reserva buscarReservaPeloId(int numeroIdReserva) {
        for (Reserva item : listaReservas) {
            if (item.getIdReserva() == numeroIdReserva) {
                return item;
            }
        }
        return null;
    }


}

