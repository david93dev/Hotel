package br.com.facisa.Gerencial;

import br.com.facisa.Pessoas.Funcionario;
import br.com.facisa.Pessoas.Hospede;
import br.com.facisa.Pessoas.Pessoa;
import br.com.facisa.Reservas.Reserva;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;


public class GerencialPessoas {


    private ArrayList<Hospede> listaHospedes = new ArrayList<Hospede>();


    public boolean validaCpf(String cpf) {
        return cpf != null && cpf.matches("\\d{11}");
    }

    public boolean validaCadastro(String cadastro) {
        return cadastro != null && !cadastro.isEmpty();

    }

    public boolean validaTelefone(String telefone) {
        return telefone != null && telefone.matches("\\d{8,15}");
    }

    public boolean validaDataNascimento(String dataNascimento) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate d = LocalDate.parse(dataNascimento, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }



        /*
Funções Hóspedes:
 */

    public boolean adicionarHospedeLista(Hospede novoHospede) {
        if (!listaHospedes.isEmpty()) {
            for (Hospede hospede : listaHospedes) {
                if (hospede.getCpf().equals(novoHospede.getCpf())) {
                    return false;
                }
            }
        }
        listaHospedes.add(novoHospede);
        return true;
    }

    public ArrayList<Hospede> listarHospedes() {
        return listaHospedes;
    }

    public boolean alterarHospede(Hospede alterarHospede) {
        if (!listaHospedes.isEmpty()) {
            for (Hospede item : listaHospedes) {
                if (item.getCpf().equals(alterarHospede.getCpf())) {
                    item.setNome(alterarHospede.getNome());
                    item.setCpf(alterarHospede.getCpf());
                    item.setDataNascimento(alterarHospede.getDataNascimento());
                    item.setNumeroTelefone(alterarHospede.getNumeroTelefone());
                    item.setEndereco(alterarHospede.getEndereco());
                    item.setTipoEstadia(alterarHospede.getTipoEstadia());
                    return true;
                }

            }
        }
        return false;
    }

    public boolean excluirHospede(String cpfPesquisado) {
        boolean foiRemovido = false;
        for (int i = 0; i < listaHospedes.size(); i++) {
            if (listaHospedes.get(i).getCpf().equals(cpfPesquisado)) {
                listaHospedes.remove(i);
                return foiRemovido = true;
            }
        }
        return foiRemovido;
    }

    public Hospede buscarHospedePorCpf(String cpf) {
        for (Hospede item : listaHospedes) {
            if (item.getCpf().equals(cpf)) {
                return item;
            }
        }
        return null;
    }

/*
Funções funcionários:
 */

    private static ArrayList<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();

    public boolean adicionarFuncionario(Funcionario novoFuncionario) {
        if (!listaFuncionarios.isEmpty()) {
            for (Funcionario funcionario : listaFuncionarios) {
                if (funcionario.getCpf().equals(novoFuncionario.getCpf())) {
                    return false;
                }
            }
        }
        listaFuncionarios.add(novoFuncionario);
        return true;
    }


    public ArrayList<Funcionario> listarFuncionarios() {
        return listaFuncionarios;
    }

    public boolean alterarFuncionarios(Funcionario alterarFuncionario) {
        if (!listaFuncionarios.isEmpty()) {
            for (Funcionario item : listaFuncionarios) {
                if (item.getCpf().equals(alterarFuncionario.getCpf())) {
                    item.setNome(alterarFuncionario.getNome());
                    item.setDataNascimento(alterarFuncionario.getDataNascimento());
                    item.setNumeroTelefone(alterarFuncionario.getNumeroTelefone());
                    item.setEndereco(alterarFuncionario.getEndereco());
                    item.setCargo(alterarFuncionario.getCargo());
                    item.setTurnoTrabalho(alterarFuncionario.getTurnoTrabalho());
                    item.setSalario(alterarFuncionario.getSalario());
                    return true;
                }

            }
        }
        return false;
    }

    public boolean excluirFuncionarios(String cpfPesquisado) {
        boolean foiRemovido = false;
        for (int i = 0; i < listaFuncionarios.size(); i++) {
            if (listaFuncionarios.get(i).getCpf().equals(cpfPesquisado)) {
                listaFuncionarios.remove(i);
                return foiRemovido = true;
            }
        }
        return foiRemovido;
    }

    public double calcularSalarioPorHora(Funcionario funcionario, String horaInicio, String horaFim, int diasTrabalhadosPorMes) {
        LocalTime inicio = LocalTime.parse(horaInicio);
        LocalTime fim = LocalTime.parse(horaFim);
        Duration duracao = Duration.between(inicio, fim);
        double horasTrabalhadasPorDia = duracao.toHours() + (duracao.toMinutesPart() / 60.0);

        double totalHorasPorMes = horasTrabalhadasPorDia * diasTrabalhadosPorMes;
        double salarioPorHora = funcionario.getSalario() / 220.0;
        double pagamento = salarioPorHora * totalHorasPorMes;

        return pagamento;
    }


    // Sobrecarga: Função para calcular o salário por hora sem passar os dias de trabalho
    public double calcularSalarioPorHora(Funcionario funcionario, String horaInicio, String horaFim) {
        LocalTime inicio = LocalTime.parse(horaInicio);
        LocalTime fim = LocalTime.parse(horaFim);
        Duration duracao = Duration.between(inicio, fim);
        double horasTrabalhadasPorDia = duracao.toHours() + (duracao.toMinutesPart() / 60.0);

        double salarioPorHora = funcionario.getSalario() / 220.0;
        double pagamento = salarioPorHora * horasTrabalhadasPorDia;

        return pagamento;
    }


    public Funcionario buscarFuncionarioPorCpf(String cpf) {
        for (Funcionario item : listaFuncionarios) {
            if (item.getCpf().equals(cpf)) {
                return item;
            }
        }
        return null;
    }


}





