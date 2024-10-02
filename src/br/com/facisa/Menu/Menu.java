package br.com.facisa.Menu;

import javax.swing.*;

public class Menu {

    public String menuPrincipal() {
         String menuStr = JOptionPane.showInputDialog("""
                               MENU HOTEL
                    
                    1 - Gerenciamento Quartos;
                    2 - Gerenciamento Hóspedes;
                    3 - Gerenciamento Funcionarios;
                    4 - Reservas;
                    5 - Sair.
                    
                    Digite o número da opção desejada:
                    """);

         return menuStr;
    }

    public String menuQuarto(){
        String menu2Str = JOptionPane.showInputDialog("""
                               MENU QUARTO
                                
                     1 - Adicionar Quarto;
                     2 - Listar Todos os Quartos;
                     3 - Excluir Quarto;
                     4 - Voltar.
                                
                     Digite o número da opção desejada:
                     """);
        return menu2Str;

    }

    public String menuHospede(){
        String menu3Str = JOptionPane.showInputDialog("""
                               MENU HÓSPEDES
                                
                     1 - Cadastrar Hóspede;
                     2 - Lista Todos os Hóspedes;
                     3 - Editar Cadastro;
                     4 - Excluir Cadastro;
                     5 - Voltar.
                                
                     Digite o número da opção desejada:
                     """);
        return menu3Str;
    }
    public String menuFuncionario(){
        String menu4Str = JOptionPane.showInputDialog("""
                              MENU FUNCIONÁRIOS
                                
                     1 - Cadastro de Funcionários;
                     2 - Listar Todos os Funcionários;
                     3 - Editar Cadastro;
                     4 - Excluir Cadastro;
                     5 - Valor Salário por horas trabalhadas;
                     6 - Voltar.
                               
                     Digite o número da opção desejada:
                     """);
        return menu4Str;
    }

    public String menuReserva(){
        String menu5Str = JOptionPane.showInputDialog("""
                              MENU RESERVAS
                                
                     1 - Criar Reserva;
                     2 - Listar todas as Reservas;
                     3 - Cancelar Reserva;
                     4 - Histórico Hóspede Estadia;
                     5 - Check-In;
                     6 - Check-Out;
                     7 - Voltar.
                               
                     Digite o número da opção desejada:
                     """);
        return menu5Str;
    }

}
