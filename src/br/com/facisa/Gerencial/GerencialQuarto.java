package br.com.facisa.Gerencial;

import br.com.facisa.Enum.StatusQuarto;
import br.com.facisa.Enum.TipoQuarto;
import br.com.facisa.Pessoas.Hospede;
import br.com.facisa.Quartos.Quarto;

import java.util.ArrayList;

public class GerencialQuarto {

    public ArrayList<Quarto> listaQuartos = new ArrayList<Quarto>();


public String listarQuartos() {
    String listaGeral = "Lista de Quartos\n";

    if (listaQuartos.size() > 0) {
        for (Quarto quarto : listaQuartos) {
            listaGeral += quarto.toString();
        }
    } else {
        listaGeral = "Lista de vazia!";
    }

    return listaGeral;
}

    public boolean excluirQuartoPeloNumero(String numeroQuartoExluir) {
        boolean foiRemovido = false;

        for (Quarto item : listaQuartos) {
            if (item.getNumeroQuarto().equals(numeroQuartoExluir)) {
                listaQuartos.remove(item);
                foiRemovido = true;
                break;
            }
        }
        return foiRemovido;

    }

    public boolean adiconarQuartoLista(Quarto novoQuarto) {
        for (Quarto item : listaQuartos) {
            if (item.getNumeroQuarto().equals(novoQuarto.getNumeroQuarto())) {
                return false;
            }
        }
        listaQuartos.add(novoQuarto);
        return true;
    }

    public boolean validaCadastro(String cadastro) {

        return cadastro != null && !cadastro.isEmpty();
    }

    public Quarto buscarQuartoPorId(String numeroQuarto){
        for (Quarto item : listaQuartos) {
            if (item.getNumeroQuarto().equals(numeroQuarto)) {
                return item;
            }
        }
        return null;
    }
    public String listarQuartoDisponiveis() {
        String listaDisponivel = "Lista de Quartos\n";
        StatusQuarto disponivel = StatusQuarto.DISPONIVEL;

        if (!listaQuartos.isEmpty()) {
            for (Quarto quarto : listaQuartos) {
                if(quarto.getStatusQuarto() == disponivel)
                    listaDisponivel += quarto.toString();
            }
        } else {
            listaDisponivel = "Sem Quartos disponíveis!";
        }

        return listaDisponivel;
    }


    public ArrayList<Quarto> listarQuartoGeral() {
        return listaQuartos;
    }

}



