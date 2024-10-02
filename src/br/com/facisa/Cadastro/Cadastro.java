package br.com.facisa.Cadastro;

import br.com.facisa.Enum.StatusQuarto;
import br.com.facisa.Enum.TipoQuarto;
import br.com.facisa.Enum.Turno;
import br.com.facisa.Gerencial.GerencialPessoas;
import br.com.facisa.Gerencial.GerencialQuarto;
import br.com.facisa.Pessoas.Funcionario;
import br.com.facisa.Pessoas.Hospede;
import br.com.facisa.Quartos.Quarto;
import br.com.facisa.Reservas.Reserva;

import javax.swing.*;
import java.util.ArrayList;

public class Cadastro {

    GerencialQuarto gQuarto = new GerencialQuarto();
    GerencialPessoas gPessoas = new GerencialPessoas();


    public Quarto cadastroQuarto() {

        String numeroQuarto = JOptionPane.showInputDialog("Digite o número do quarto:");
        while (!gQuarto.validaCadastro(numeroQuarto)) {
            numeroQuarto = JOptionPane.showInputDialog("Campo vazio ou número do quarto já cadastrado, digite novamente: ");
        }


        String tipoQuartoStr = JOptionPane.showInputDialog(""" 
                Escolha o id do tipo do quarto:
                1 - Solteiro;
                2 - Casal;
                3 - Suíte. 
                """);
        TipoQuarto tipoQuarto = null;

        if (tipoQuartoStr.equals("1")) {
            tipoQuarto = TipoQuarto.SOLTEIRO;
        } else if (tipoQuartoStr.equals("2")) {
            tipoQuarto = TipoQuarto.CASAL;
        } else if (tipoQuartoStr.equals("3")) {
            tipoQuarto = TipoQuarto.SUITE;
        } else {
            JOptionPane.showMessageDialog(null, "Opção invalida!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        while (!gQuarto.validaCadastro(tipoQuartoStr)) {
            tipoQuartoStr = JOptionPane.showInputDialog("O tipo do quarto é obrigatório, Digite Novamente: ");
        }

        String capacidadeStr = JOptionPane.showInputDialog("Digite a capacidade do quarto: ");
        while (!gQuarto.validaCadastro(capacidadeStr)) {
            capacidadeStr = JOptionPane.showInputDialog("A capacidade do quarto é obrigatória!: ");
        }
        int capacidade = Integer.parseInt(capacidadeStr);


        String statusQuartoStr = JOptionPane.showInputDialog(""" 
                Escolha o status do quarto:
                1 - Disponível; 
                2 - Ocupado;
                3 - Manutenção. """);

        StatusQuarto statusQuarto = null;

        if (statusQuartoStr.equals("1")) {
            statusQuarto = StatusQuarto.DISPONIVEL;
        } else if (statusQuartoStr.equals("2")) {
            statusQuarto = StatusQuarto.OCUPADO;
        } else if (statusQuartoStr.equals("3")) {
            statusQuarto = StatusQuarto.MANUTENCAO;
        } else {
            JOptionPane.showMessageDialog(null, "Opção invalida!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        while (!gQuarto.validaCadastro(statusQuartoStr)) {
            statusQuartoStr = JOptionPane.showInputDialog("O Status do quarto é obrigatório!: ");
        }

        String valorDiariaStr = JOptionPane.showInputDialog("Digite o valor da diária:");
        double valorDiaria = Double.parseDouble(valorDiariaStr);
        while (valorDiariaStr == null || valorDiariaStr.isEmpty() || valorDiaria <= 0 ) {
            try {
                valorDiaria = Double.parseDouble(valorDiariaStr);

                if (valorDiaria <= 0) {
                    valorDiariaStr = JOptionPane.showInputDialog("O valor da diária deve ser maior que zero:");
                }
            } catch (NumberFormatException e) {
                valorDiariaStr = JOptionPane.showInputDialog("Digite um valor numérico válido para a diária:");
            }
        }


        Quarto novoQuarto = new Quarto(numeroQuarto, tipoQuarto, capacidade, statusQuarto, valorDiaria);

        return novoQuarto;

    }

    public Hospede cadastroHospede() {

        String cpf = JOptionPane.showInputDialog("Digite seu CPF com 11 dígitos, apenas números: ");
        while (!gPessoas.validaCpf(cpf)) {
            cpf = JOptionPane.showInputDialog("CPF inválido ou já existe. Digite um CPF válido: ");
        }
        String nome = JOptionPane.showInputDialog("Digite seu nome: ");
        while (!gPessoas.validaCadastro(nome)) {
            nome = JOptionPane.showInputDialog("Nome inválido. Digite um nome válido: ");
        }
        String endereco = JOptionPane.showInputDialog("Digite seu endereço: ");
        while (!gPessoas.validaCadastro(endereco)) {
            endereco = JOptionPane.showInputDialog("Endereço invalido, Digite seu endereço novamente: ");
        }
        String numeroTelefone = JOptionPane.showInputDialog("Digite seu Telefone: ");
        while (!gPessoas.validaTelefone(numeroTelefone)) {
            numeroTelefone = JOptionPane.showInputDialog("Número invalido, Digite seu telefone novamente: ");
        }
        String dataNascimento = JOptionPane.showInputDialog("""
                Qual a sua data de nascimento ex: "dd/MM/yyyy": """);
        while (!gPessoas.validaDataNascimento(dataNascimento)) {
            dataNascimento = JOptionPane.showInputDialog("Data invalida, Digite sua data de nascimento novamente: ");
        }

        String tipoEstadia = JOptionPane.showInputDialog("""
                Digite seu tipo de estadia:
                
                1 - Tipo All-Inclusive;
                2 - Tipo Pensão completa.
                
                """);
        if (tipoEstadia.equals("1")) {
            tipoEstadia = "All-Inclusive";
        } else if (tipoEstadia.equals("2")) {
            tipoEstadia = "Pensão completa";
        } else {
            while (!gPessoas.validaCadastro(tipoEstadia)) {
                tipoEstadia = JOptionPane.showInputDialog("Estadia invalida, Digite novamente: ");
            }
        }

        Hospede novoHospede = new Hospede(cpf, nome, endereco, numeroTelefone, dataNascimento, tipoEstadia);

        return novoHospede;
    }


    public Hospede alterarCadastroHospede() {

         String cpfPesquisa = JOptionPane.showInputDialog("Digite o CPF do hospede que deseja alterar: ");
         while (!gPessoas.validaCpf(cpfPesquisa)) {
             cpfPesquisa = JOptionPane.showInputDialog("CPF inválido  digite novamente: ");
         }

         String nomeAlterar = JOptionPane.showInputDialog("Altere seu nome: ");
         while (!gPessoas.validaCadastro(nomeAlterar)) {
             nomeAlterar = JOptionPane.showInputDialog("Nome inválido. Digite um nome válido: ");
         }
         String enderecoAlterar = JOptionPane.showInputDialog("Altere seu endereço: ");
         while (!gPessoas.validaCadastro(enderecoAlterar)) {
             enderecoAlterar = JOptionPane.showInputDialog("Endereço invalido, Digite seu endereço novamente: ");
         }
         String numeroTelefoneAlterar = JOptionPane.showInputDialog("Altere seu Telefone: ");
         while (!gPessoas.validaTelefone(numeroTelefoneAlterar)) {
             numeroTelefoneAlterar = JOptionPane.showInputDialog("Número invalido, Digite seu telefone novamente: ");
         }
         String dataNascimentoAlterar = JOptionPane.showInputDialog("""
                Altere a sua data de nascimento ex: "dd/MM/yyyy": """);
         while (!gPessoas.validaDataNascimento(dataNascimentoAlterar)) {
             dataNascimentoAlterar = JOptionPane.showInputDialog("Data invalida, Digite sua data de nascimento novamente: ");
         }
         String tipoEstadiaAlterar = JOptionPane.showInputDialog("""
                Altere seu tipo de estadia:
                
                1 - Tipo All-Inclusive;
                2 - Tipo Pensão completa.
                
                """);
         if (tipoEstadiaAlterar.equals("1")) {
             tipoEstadiaAlterar = "All-Inclusive";
         } else if (tipoEstadiaAlterar.equals("2")) {
             tipoEstadiaAlterar = "Pensão completa";
         } else {
             while (!gPessoas.validaCadastro(tipoEstadiaAlterar)) {
                 tipoEstadiaAlterar = JOptionPane.showInputDialog("Estadia invalida, Digite novamente: ");
             }
         }

         Hospede alterarHospede = new Hospede(cpfPesquisa, nomeAlterar, enderecoAlterar, numeroTelefoneAlterar, dataNascimentoAlterar, tipoEstadiaAlterar);

         return alterarHospede;

    }

    public Funcionario cadastroFuncionario() {

        String cpfFuncionario = JOptionPane.showInputDialog("Digite seu CPF: ");
        while (!gPessoas.validaCpf(cpfFuncionario)) {
            cpfFuncionario = JOptionPane.showInputDialog("CPF inválido  digite novamente: ");
        }
        String nomeFuncionario = JOptionPane.showInputDialog("Digite seu nome: ");
        while (!gPessoas.validaCadastro(nomeFuncionario)) {
            nomeFuncionario = JOptionPane.showInputDialog("Nome inválido. Digite um nome válido: ");
        }
        String enderecoFuncionario = JOptionPane.showInputDialog("Digite seu endereço: ");
        while (!gPessoas.validaCadastro(enderecoFuncionario)) {
            enderecoFuncionario = JOptionPane.showInputDialog("Endereço invalido, Digite seu endereço novamente: ");
        }
        String numeroTelefoneFuncionario = JOptionPane.showInputDialog("Digite seu Telefone: ");
        while (!gPessoas.validaTelefone(numeroTelefoneFuncionario)) {
            numeroTelefoneFuncionario = JOptionPane.showInputDialog("Número invalido, Digite seu telefone novamente: ");
        }
        String dataNascimentoFuncionario = JOptionPane.showInputDialog("""
                Qual a sua data de nascimento ex: "dd/MM/yyyy":""");
        while (!gPessoas.validaDataNascimento(dataNascimentoFuncionario)) {
            dataNascimentoFuncionario = JOptionPane.showInputDialog("Data invalida, Digite sua data de nascimento novamente: ");
        }
        String cargoFuncionario = JOptionPane.showInputDialog("""
                Qual sua Função:
                
                1 - Gerente;
                2 - Recepcionista;
                3 - Camareira;
                4 - Serviços gerais;
                5 - Manutenção.
                
                """);
        if (cargoFuncionario.equals("1")) {
            cargoFuncionario = "Gerente";
        } else if (cargoFuncionario.equals("2")) {
            cargoFuncionario = "Recepcionista";
        } else if (cargoFuncionario.equals("3")) {
            cargoFuncionario = "Camareira";
        } else if (cargoFuncionario.equals("4")) {
            cargoFuncionario = "Serviços gerais";
        } else if (cargoFuncionario.equals("5")) {
            cargoFuncionario = "Manutenção";
        } else {
            while (!gPessoas.validaCadastro(cargoFuncionario)) {
                cargoFuncionario = JOptionPane.showInputDialog("Cargo invalido, Digite novamente: ");
            }
        }
        String turnoFuncionarioStr = JOptionPane.showInputDialog("""
                Qual sua Função:
                
                1 - Manhã;
                2 - Tarde;
                3 - Noite;
                
                """);
        Turno turnoFuncionario = null;

        if (turnoFuncionarioStr.equals("1")) {
            turnoFuncionario = Turno.MANHA;
        } else if (turnoFuncionarioStr.equals("2")) {
            turnoFuncionario = Turno.TARDE;
        } else if (turnoFuncionarioStr.equals("3")) {
            turnoFuncionario = Turno.NOITE;
        } else {
            while (!gPessoas.validaCadastro(turnoFuncionarioStr)) {
                turnoFuncionarioStr = JOptionPane.showInputDialog("Turno invalido, Digite novamente: ");
            }
        }
        String salarioFuncionario = JOptionPane.showInputDialog("Digite o sálario base: ");
        while (!gPessoas.validaCadastro(salarioFuncionario)) {
            salarioFuncionario = JOptionPane.showInputDialog("Erro, Digite novamente: ");
        }
        double salarioDouble = Double.parseDouble(salarioFuncionario);

        Funcionario novoFuncionario = new Funcionario(cpfFuncionario, nomeFuncionario, enderecoFuncionario, numeroTelefoneFuncionario, dataNascimentoFuncionario, cargoFuncionario, turnoFuncionario, salarioDouble);

        return novoFuncionario;
    }

    public Funcionario alterarCadastroFuncionario() {

        String cpfFuncionarioAntigo = JOptionPane.showInputDialog("Digite seu CPF: ");
        while (!gPessoas.validaCpf(cpfFuncionarioAntigo)) {
            cpfFuncionarioAntigo = JOptionPane.showInputDialog("CPF inválido  digite novamente: ");
        }

        String nomeFuncionarioAlterar = JOptionPane.showInputDialog("Digite seu nome: ");
        while (!gPessoas.validaCadastro(nomeFuncionarioAlterar)) {
            nomeFuncionarioAlterar = JOptionPane.showInputDialog("Nome inválido. Digite um nome válido: ");
        }
        String enderecoFuncionarioAlterar = JOptionPane.showInputDialog("Digite seu endereço: ");
        while (!gPessoas.validaCadastro(enderecoFuncionarioAlterar)) {
            enderecoFuncionarioAlterar = JOptionPane.showInputDialog("Endereço invalido, Digite seu endereço novamente: ");
        }
        String numeroTelefoneFuncionarioAlterar = JOptionPane.showInputDialog("Digite seu Telefone: ");
        while (!gPessoas.validaTelefone(numeroTelefoneFuncionarioAlterar)) {
            numeroTelefoneFuncionarioAlterar = JOptionPane.showInputDialog("Número invalido, Digite seu telefone novamente: ");
        }
        String dataNascimentoFuncionarioAlterar = JOptionPane.showInputDialog("""
                Qual a sua data de nascimento ex: "dd/MM/yyyy":""");
        while (!gPessoas.validaDataNascimento(dataNascimentoFuncionarioAlterar)) {
            dataNascimentoFuncionarioAlterar = JOptionPane.showInputDialog("Data invalida, Digite sua data de nascimento novamente: ");
        }
        String cargoFuncionarioAlterar = JOptionPane.showInputDialog("""
                Qual sua Função:
                
                1 - Gerente;
                2 - Recepcionista;
                3 - Camareira;
                4 - Serviços gerais;
                5 - Manutenção.
                
                """);
        if (cargoFuncionarioAlterar.equals("1")) {
            cargoFuncionarioAlterar = "Gerente";
        } else if (cargoFuncionarioAlterar.equals("2")) {
            cargoFuncionarioAlterar = "Recepcionista";
        } else if (cargoFuncionarioAlterar.equals("3")) {
            cargoFuncionarioAlterar = "Camareira";
        } else if (cargoFuncionarioAlterar.equals("4")) {
            cargoFuncionarioAlterar = "Serviços gerais";
        } else if (cargoFuncionarioAlterar.equals("5")) {
            cargoFuncionarioAlterar = "Manutenção";
        } else {
            while (!gPessoas.validaCadastro(cargoFuncionarioAlterar)) {
                cargoFuncionarioAlterar = JOptionPane.showInputDialog("Cargo invalido, Digite novamente: ");
            }
        }
        String turnoFuncionarioAlterarStr = JOptionPane.showInputDialog("""
                Qual sua Função:
                
                1 - Manhã;
                2 - Tarde;
                3 - Noite;
                
                """);

        Turno turnoFuncionarioAlterar = null;

        if (turnoFuncionarioAlterarStr.equals("1")) {
            turnoFuncionarioAlterar = Turno.MANHA;
        } else if (turnoFuncionarioAlterarStr.equals("2")) {
            turnoFuncionarioAlterar = Turno.TARDE;
        } else if (turnoFuncionarioAlterarStr.equals("3")) {
            turnoFuncionarioAlterar = Turno.NOITE;
        } else {
            while (!gPessoas.validaCadastro(turnoFuncionarioAlterarStr)) {
                turnoFuncionarioAlterarStr = JOptionPane.showInputDialog("Turno invalido, Digite novamente: ");
            }
        }
        String salarioFuncionarioAlterar = JOptionPane.showInputDialog("Digite o salário base: ");
        while (!gPessoas.validaCadastro(salarioFuncionarioAlterar)) {
            salarioFuncionarioAlterar = JOptionPane.showInputDialog("Erro, Digite novamente: ");
        }
        double salarioDoubleAlterar = Double.parseDouble(salarioFuncionarioAlterar);

        Funcionario alterarFuncionario = new Funcionario(cpfFuncionarioAntigo, nomeFuncionarioAlterar, enderecoFuncionarioAlterar, numeroTelefoneFuncionarioAlterar, dataNascimentoFuncionarioAlterar, cargoFuncionarioAlterar, turnoFuncionarioAlterar, salarioDoubleAlterar);

        return alterarFuncionario;
    }

    public Reserva cadastroReserva(){
        String cpfHospede = JOptionPane.showInputDialog("Digite seu CPF: ");
        while (!gPessoas.validaCpf(cpfHospede)) {
            cpfHospede = JOptionPane.showInputDialog("CPF inválido, digite novamente: ");
        }
        Hospede hospedeReserva = gPessoas.buscarHospedePorCpf(cpfHospede);

        ArrayList<Quarto> listaQuartos = gQuarto.listarQuartoGeral();
        String lista = "Lista de Quartos Disponíveis:\n";
        if (!listaQuartos.isEmpty()) {
            for (Quarto item : listaQuartos) {
                if (item.getStatusQuarto() == StatusQuarto.DISPONIVEL)
                    lista += item.toString();
            }
        }
        String numeroQuarto = JOptionPane.showInputDialog(lista + "\nDigite o número do quarto da sua preferência: ");
        while (!gPessoas.validaCadastro(numeroQuarto)) {
            numeroQuarto = JOptionPane.showInputDialog("Número do quarto inválido, digite novamente: ");
        }
        Quarto quartoReserva = gQuarto.buscarQuartoPorId(numeroQuarto);

        String dataInicioStr = JOptionPane.showInputDialog("""
                                            Digite a data "INICIAL" da estadia. Ex: "dd/MM/yyyy": """);
        while (!gPessoas.validaDataNascimento(dataInicioStr)) {
            dataInicioStr = JOptionPane.showInputDialog("Data invalida, Digite novamente: ");
        }

        String dataFinalStr = JOptionPane.showInputDialog("""
                                            Digite a data do "FIM" da estadia. Ex: "dd/MM/yyyy": """);
        while (!gPessoas.validaDataNascimento(dataFinalStr)) {
            dataFinalStr = JOptionPane.showInputDialog("Data invalida, Digite novamente: ");
        }

        Reserva novaReserva = new Reserva(hospedeReserva, quartoReserva, dataInicioStr, dataFinalStr);

        return novaReserva;
    }


}
