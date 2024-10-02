package br.com.facisa.Principal;


import br.com.facisa.Cadastro.Cadastro;
import br.com.facisa.Enum.StatusQuarto;
import br.com.facisa.Enum.TipoQuarto;
import br.com.facisa.Enum.Turno;
import br.com.facisa.Gerencial.GerencialPessoas;
import br.com.facisa.Gerencial.GerencialQuarto;
import br.com.facisa.Gerencial.GerencialReserva;
import br.com.facisa.Menu.Menu;
import br.com.facisa.Pessoas.Funcionario;
import br.com.facisa.Pessoas.Hospede;
import br.com.facisa.Quartos.Quarto;
import br.com.facisa.Reservas.Reserva;

import javax.swing.*;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //instancias das classes
        GerencialQuarto gQuarto = new GerencialQuarto();
        GerencialPessoas gPessoas = new GerencialPessoas();
        GerencialReserva gReserva = new GerencialReserva();
        Menu meuMenu = new Menu();
        Cadastro meuCadastro = new Cadastro();

        Funcionario novoFuncionario1 = new Funcionario("12345678910", "Fulano", "Rua", "12345678", "16/04/1993", "Gerencia", Turno.NOITE, 1000);
        gPessoas.adicionarFuncionario(novoFuncionario1);

        Quarto novoQuarto1 = new Quarto("1", TipoQuarto.CASAL, 2, StatusQuarto.DISPONIVEL, 1000);
        gQuarto.adiconarQuartoLista(novoQuarto1);

        Quarto novoQuarto2 = new Quarto("2", TipoQuarto.CASAL, 2, StatusQuarto.OCUPADO, 1000);
        gQuarto.adiconarQuartoLista(novoQuarto2);

        Hospede novoHospede1 = new Hospede("10183689496", "Alguém", "Rua", "8399133191", "16/04/1993", "All-Inclusive");
        gPessoas.adicionarHospedeLista(novoHospede1);

        Reserva novaReserva1 = new Reserva(novoHospede1, novoQuarto2, "15/09/2024", "20/09/2024");
        gReserva.adiconarReservaLista(novaReserva1);

        Reserva novaReserva2 = new Reserva(novoHospede1, novoQuarto1, "11/09/2024", "20/09/2024");
        gReserva.adiconarReservaLista(novaReserva2);

        int menuPrincipal = 0;

        do {

            try {
                //menu principal
                String menuStr = meuMenu.menuPrincipal();
                menuPrincipal = Integer.parseInt(menuStr);

                switch (menuPrincipal) {
                    case 1:

                        int menuQuarto;

                        do {
                            //menu Quarto
                            String menu2Str = meuMenu.menuQuarto();
                            menuQuarto = Integer.parseInt(menu2Str);

                            switch (menuQuarto) {

                                case 1:
                                    //criar um quarto
                                    Quarto novoQuarto = meuCadastro.cadastroQuarto();
                                    boolean quartoAdicionado = gQuarto.adiconarQuartoLista(novoQuarto);

                                    if (quartoAdicionado) {
                                        JOptionPane.showMessageDialog(null, "O quarto foi adicionado com sucesso!");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "O quarto não foi adicionado, número do quarto já existe!", "Erro", JOptionPane.ERROR_MESSAGE);
                                    }
                                    break;

                                case 2:
                                    //listar todos os quartos
                                    String listar = gQuarto.listarQuartos();
                                    JOptionPane.showMessageDialog(null, listar);
                                    break;


                                case 3:
                                    //remover Quarto
                                    String removerQuarto = JOptionPane.showInputDialog("Digite o número do quarto que deseja excluir: ");
                                    while (!gPessoas.validaCadastro(removerQuarto)) {
                                        removerQuarto = JOptionPane.showInputDialog("CPF inválido digite novamente: ");
                                    }

                                    boolean removerQuartoBool = gQuarto.excluirQuartoPeloNumero(removerQuarto);

                                    if (removerQuartoBool) {
                                        JOptionPane.showMessageDialog(null, "O quarto foi excluido com sucesso!");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Erro ao excluir. Quarto não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                                    }
                            }
                        } while (menuQuarto != 4);
                        break;

                    case 2:

                        int menuHospede;

                        do {
                            //menu hospede
                            String menu3Str = meuMenu.menuHospede();
                            menuHospede = Integer.parseInt(menu3Str);

                            switch (menuHospede) {
                                case 1:
                                    //cadastrar hospede
                                    Hospede novoHospede = meuCadastro.cadastroHospede();
                                    boolean adicicionado = gPessoas.adicionarHospedeLista(novoHospede);

                                    if (adicicionado) {
                                        JOptionPane.showMessageDialog(null, "Hóspede adicionado com sucesso!");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "CPF já castrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                                    }
                                    break;

                                case 2:
                                    //listar hospede
                                    ArrayList<Hospede> listaHospedes = gPessoas.listarHospedes();
                                    String listar = "Lista de Hóspedes:\n";
                                    if (!listaHospedes.isEmpty()) {
                                        for (Hospede i : listaHospedes) {
                                            listar += i.toString();
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Lista Vazia", "Erro", JOptionPane.ERROR_MESSAGE);
                                    }
                                    JOptionPane.showMessageDialog(null, listar);
                                    break;

                                case 3:
                                    //Editar hospede
                                    ArrayList<Hospede> listaHospede = gPessoas.listarHospedes();
                                    if (!listaHospede.isEmpty()) {
                                        Hospede alterarHospede = meuCadastro.alterarCadastroHospede();
                                        boolean alterado = gPessoas.alterarHospede(alterarHospede);
                                        if (alterado) {
                                            JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!");
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Cadastro não alterado, CPF invalido! ", "Erro", JOptionPane.ERROR_MESSAGE);
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "É necessário Cadastrar um Hospede antes de acessar essa opção!");
                                    }
                                    break;

                                case 4:
                                    //excluir Hospede
                                    ArrayList<Hospede> listaHospede2 = gPessoas.listarHospedes();
                                    if (!listaHospede2.isEmpty()) {
                                        String cpfExcluir = JOptionPane.showInputDialog("Digite o CPF do hospede que deseja alterar: ");
                                        while (!gPessoas.validaCpf(cpfExcluir)) {
                                            cpfExcluir = JOptionPane.showInputDialog("CPF inválido digite novamente: ");
                                        }
                                        boolean excluido = gPessoas.excluirHospede(cpfExcluir);

                                        if (excluido) {
                                            JOptionPane.showMessageDialog(null, "Cadastro excluido com sucesso!");
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Cadastro não existe ou CPF errado!", "Erro", JOptionPane.ERROR_MESSAGE);
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "É necessário Cadastrar um Hospede antes de acessar essa opção!");
                                    }

                            }
                            break;


                        } while (menuHospede != 5);
                        break;

                    case 3:

                        int menuFuncionario;

                        do {
                            // menu funcionario
                            String menu4Str = meuMenu.menuFuncionario();
                            menuFuncionario = Integer.parseInt(menu4Str);

                            switch (menuFuncionario) {

                                case 1:
                                    //cadastro funcionario
                                    Funcionario novoFuncionario = meuCadastro.cadastroFuncionario();
                                    boolean foiAdicionado = gPessoas.adicionarFuncionario(novoFuncionario);

                                    if (foiAdicionado) {
                                        JOptionPane.showMessageDialog(null, "O funcionário foi adicionado com sucesso!");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "O funcionário não foi adicionado, CPF do funcionário já existe!", "Erro", JOptionPane.ERROR_MESSAGE);
                                    }
                                    break;

                                case 2:
                                    //listar Funcionario
                                    ArrayList<Funcionario> listaFuncionarios = gPessoas.listarFuncionarios();
                                    String listar = "Lista de Funcionários:\n";
                                    if (!listaFuncionarios.isEmpty()) {
                                        for (Funcionario i : listaFuncionarios) {
                                            listar += i.toString();
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Lista Vazia", "Erro", JOptionPane.ERROR_MESSAGE);
                                    }

                                    JOptionPane.showMessageDialog(null, listar);
                                    break;

                                case 3:
                                    //editar Funcionario
                                    ArrayList<Funcionario> listaFuncionarios1 = gPessoas.listarFuncionarios();
                                    if (!listaFuncionarios1.isEmpty()) {
                                        Funcionario alterarFuncionario = meuCadastro.alterarCadastroFuncionario();
                                        boolean funcionarioAlterado = gPessoas.alterarFuncionarios(alterarFuncionario);

                                        if (funcionarioAlterado) {
                                            JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!");
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Cadastro não alterado ", "Erro", JOptionPane.ERROR_MESSAGE);
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "É necessário Cadastrar um Funcionário antes de acessar essa opção!");
                                    }

                                    break;

                                case 4:
                                    //excluir funcionario
                                    ArrayList<Funcionario> listaFuncionarios2 = gPessoas.listarFuncionarios();
                                    if (!listaFuncionarios2.isEmpty()) {
                                        String cpfExcluir = JOptionPane.showInputDialog("Digite o CPF do funcionário que deseja excluir: ");
                                        while (!gPessoas.validaCpf(cpfExcluir)) {
                                            cpfExcluir = JOptionPane.showInputDialog("CPF inválido digite novamente: ");
                                        }
                                        boolean foiExcluido = gPessoas.excluirFuncionarios(cpfExcluir);

                                        if (foiExcluido) {
                                            JOptionPane.showMessageDialog(null, "Cadastro excluido com sucesso!");
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Cadastro não existe ou CPF errado!", "Erro", JOptionPane.ERROR_MESSAGE);
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "É necessário Cadastrar um Funcionário antes de acessar essa opção!");
                                    }

                                    break;

                                case 5:
                                    //calcular salario por hora
                                    ArrayList<Funcionario> listaFuncionarios3 = gPessoas.listarFuncionarios();
                                    if (!listaFuncionarios3.isEmpty()) {
                                        try {
                                            String perguntaStr = JOptionPane.showInputDialog("Trabalhou mais de um dia? \n1 - Sim\n2 - Não\n\nDigite o número da opção: ");
                                            while (!gPessoas.validaCadastro(perguntaStr)) {
                                                perguntaStr = JOptionPane.showInputDialog("Erro digite novamente: ");
                                            }
                                            int pergunta = Integer.parseInt(perguntaStr);

                                            String cpf = JOptionPane.showInputDialog("Digite o CPF do funcionário: ");
                                            while (!gPessoas.validaCpf(cpf)) {
                                                cpf = JOptionPane.showInputDialog("CPF inválido digite novamente: ");
                                            }
                                            Funcionario funcionariopesquisado = gPessoas.buscarFuncionarioPorCpf(cpf);
                                            JOptionPane.showMessageDialog(null, "Salário base de " + funcionariopesquisado.getNome() + ", adicionado com sucesso!\n Valor: (" + funcionariopesquisado.getSalario() + ").");

                                            String horaIncial = JOptionPane.showInputDialog("Digite a Hora que inicou ex:('HH:mm') ");
                                            while (!gPessoas.validaCadastro(horaIncial)) {
                                                horaIncial = JOptionPane.showInputDialog("Erro digite novamente: ");
                                            }

                                            String horaFinal = JOptionPane.showInputDialog("Digite a Hora que finalizou ex:('HH:mm') ");
                                            while (!gPessoas.validaCadastro(horaFinal)) {
                                                horaFinal = JOptionPane.showInputDialog("Erro digite novamente: ");
                                            }
                                            //calcula salario por hora multiplicado por dias trabalhados ou não
                                            if (pergunta == 1) {
                                                String diasTrabalhadosStr = JOptionPane.showInputDialog("Digite a quantidade de dias trabalhados: ");
                                                while (!gPessoas.validaCadastro(diasTrabalhadosStr)) {
                                                    diasTrabalhadosStr = JOptionPane.showInputDialog("Erro digite novamente: ");
                                                }
                                                int diasTrabalhados = Integer.parseInt(diasTrabalhadosStr);

                                                double salarioPorHora = gPessoas.calcularSalarioPorHora(funcionariopesquisado, horaIncial, horaFinal, diasTrabalhados);
                                                JOptionPane.showMessageDialog(null, String.format("Salário por período trabalho é: R$" + "%.2f", salarioPorHora));

                                            } else if (pergunta == 2) {

                                                double salarioPorHora = gPessoas.calcularSalarioPorHora(funcionariopesquisado, horaIncial, horaFinal);
                                                JOptionPane.showMessageDialog(null, String.format("Salário por hora trabalho é: R$" + "%.2f", salarioPorHora));

                                            } else {
                                                JOptionPane.showMessageDialog(null, "Opção invalida!");
                                            }

                                        } catch (DateTimeParseException e) {
                                            JOptionPane.showMessageDialog(null, "Data invalida!", "Erro", JOptionPane.ERROR_MESSAGE);
                                        }

                                    } else {
                                        JOptionPane.showMessageDialog(null, "É necessário Cadastrar um Funcionário antes de acessar essa opção!");
                                    }

                                    break;
                            }

                        } while (menuFuncionario != 6);
                        break;

                    case 4:

                        int menuReserva = 0;

                        do {
                            //Menu reserva

                            String menu5Str = meuMenu.menuReserva();
                            menuReserva = Integer.parseInt(menu5Str);

                            switch (menuReserva) {

                                case 1:
                                    //criar reserva

                                    Reserva novaReserva = meuCadastro.cadastroReserva();
                                    boolean adicionado = gReserva.adiconarReservaLista(novaReserva);

                                    if (adicionado) {
                                        JOptionPane.showMessageDialog(null, "Reserva realizada com sucesso!");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Erro ao Adiconar Reserva!");
                                    }
                                    break;
                                case 2:
                                    // Listar reserva

                                    ArrayList<Reserva> listaReservas = gReserva.listarReservas();
                                    String listaGeral = "Lista de Reservas:\n";
                                    if (!listaReservas.isEmpty()) {
                                        for (Reserva item : listaReservas) {
                                            listaGeral += item.toString();
                                        }
                                    } else {
                                        listaGeral = "Lista de vazia!";
                                    }
                                    JOptionPane.showMessageDialog(null, listaGeral);
                                    break;

                                case 3:
                                    // Excluir Reserva

                                    ArrayList<Reserva> listareserva1 = gReserva.listarReservas();
                                    if (!listareserva1.isEmpty()) {

                                        String excluirReservaStr = JOptionPane.showInputDialog("Digite o número da reserva que deseja excluir: ");
                                        while (!gPessoas.validaCadastro(excluirReservaStr)) {
                                            excluirReservaStr = JOptionPane.showInputDialog("Número da reserva inválido, digite novamente: ");
                                        }
                                        int excluirReserva = Integer.parseInt(excluirReservaStr);

                                        boolean excluido = gReserva.excluirReservaPeloId(excluirReserva);

                                        if (excluido) {
                                            JOptionPane.showMessageDialog(null, "A Reserva foi excluida com sucesso!");

                                        } else {
                                            JOptionPane.showMessageDialog(null, "Erro ao excluir. Reserva não encontrada!", "Erro", JOptionPane.ERROR_MESSAGE);
                                        }

                                    } else {
                                        JOptionPane.showMessageDialog(null, "É necessário Cadastrar uma Reserva antes de acessar essa opção!");
                                    }


                                    break;
                                case 4:
                                    // Pesquisar Hitórico

                                    try {
                                        String cpfHospedeHistorico = JOptionPane.showInputDialog("Digite seu CPF: ");
                                        while (!gPessoas.validaCpf(cpfHospedeHistorico)) {
                                            cpfHospedeHistorico = JOptionPane.showInputDialog("CPF inválido, digite novamente: ");
                                        }
                                        Hospede hospedeHistorico = gPessoas.buscarHospedePorCpf(cpfHospedeHistorico);
                                        ArrayList<Reserva> historico = gReserva.listarHistoricoReservaHospede(hospedeHistorico);
                                        String listaHistorico = "Hítorico de reservas:\n\n";
                                        if (!historico.isEmpty() && historico != null) {
                                            for (Reserva item : historico) {
                                                listaHistorico += item.toString();
                                            }
                                        }
                                        JOptionPane.showMessageDialog(null, listaHistorico);

                                    } catch (NullPointerException e) {
                                        JOptionPane.showMessageDialog(null, "Sem histórico de reservas");
                                    }
                                    break;

                                case 5:

                                    //checkin
                                    ArrayList<Reserva> listareserva2 = gReserva.listarReservas();
                                    if (!listareserva2.isEmpty()) {
                                        String buscarReservaStr = JOptionPane.showInputDialog("Digite o número da reserva que deseja fazer o ChekIn: ");
                                        while (!gPessoas.validaCadastro(buscarReservaStr)) {
                                            buscarReservaStr = JOptionPane.showInputDialog("Número da reserva inválido, digite novamente: ");
                                        }
                                        int buscarReserva = Integer.parseInt(buscarReservaStr);
                                        Reserva reserva = gReserva.buscarReservaPeloId(buscarReserva);

                                        boolean checkInRealizado = gReserva.checkIn(reserva);
                                        if (checkInRealizado) {
                                            JOptionPane.showMessageDialog(null, "CheckiIn realizado com sucesso!");
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Erro ao realizar chekIn!");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "É necessário Cadastrar uma Reserva antes de acessar essa opção!");
                                    }


                                    break;
                                case 6:
                                    //checkout
                                    ArrayList<Reserva> listareserva3 = gReserva.listarReservas();
                                    if (!listareserva3.isEmpty()) {
                                        String buscarReservaString = JOptionPane.showInputDialog("Digite o número da reserva que deseja fazer o ChekOut: ");
                                        while (!gPessoas.validaCadastro(buscarReservaString)) {
                                            buscarReservaString = JOptionPane.showInputDialog("Número da reserva inválido, digite novamente: ");
                                        }
                                        int buscarReservaInt = Integer.parseInt(buscarReservaString);
                                        Reserva reservaCheckOut = gReserva.buscarReservaPeloId(buscarReservaInt);

                                        double valorPagarCheckOut = gReserva.checkOut(reservaCheckOut);
                                        JOptionPane.showMessageDialog(null, "CheckOut realizado com sucesso!\n\nValor a pagar da reserva: R$" + valorPagarCheckOut + " Reais.");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "É necessário Cadastrar uma Reserva antes de acessar essa opção!");
                                    }
                                    break;
                            }

                        } while (menuReserva != 7);
                        break;
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Campo vazio ou opção invalida!\n\nPor favor, insira uma opção válida \n(Apenas números)", "Erro", JOptionPane.ERROR_MESSAGE);
            }

        } while (menuPrincipal != 5);


    }
}
