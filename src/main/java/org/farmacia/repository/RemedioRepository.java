package org.farmacia.repository;

import org.farmacia.entities.Farmaceutica;
import org.farmacia.entities.Remedio;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

// Repositório de Remédios: Armazena remédios em memória em uma ArrayList
public class RemedioRepository {




    ArrayList<Remedio> remedios = new ArrayList<>();
    //save(Remedio):void -> Adiciona remédio ao banco de dados
    public void save(Remedio remedio) {
        remedios.add(remedio);
    }

    //encontrarPorNome(String nome): ArrayList<Remedio> -> Pesquisa por um nome e retorna remédios com este nome
    public ArrayList<Remedio> encontrarPorNome(String nome) {
        ArrayList<Remedio> remediosPesquisados = new ArrayList<>();
        for (Remedio remedio : remedios) {
            if (Objects.equals(remedio.nome_remedio, nome)) {
                remediosPesquisados.add(remedio);
            }
        }
        return remediosPesquisados;
    }

    // encontrarPorValidade(Date validade): ArrayList<Remedio> -> Pesquisa por um nome e retorna remédios com esta validade
    public ArrayList<Remedio> encontrarPorValidade(Date validade) {
        ArrayList<Remedio> remediosPesquisados = new ArrayList<>();
        for (Remedio remedio : remedios) {
            if (Objects.equals(remedio.data_vencimento, validade)) {
                remediosPesquisados.add(remedio);
            }
        }
        return remediosPesquisados;
    }

    // encontrarTodosRemedios(): ArrayList<Remedio> -> Retorna todos remédios cadastrados,
    public ArrayList<Remedio> encontrarPorFarmaceutica(String farmaceutica) {
        ArrayList<Remedio> remediosPesquisados = new ArrayList<>();
        for (Remedio remedio : remedios) {
            if (Objects.equals(remedio.farmaceutica.nome_farmaceutica, farmaceutica)) {
                remediosPesquisados.add(remedio);
            }
        }
        return remediosPesquisados;
    }

    //atualizarRemedio(String nome, String farmaceutica, String novoNome, Date dataVencimento, int quantidade,float concentracao, Farmaceutica novaFarmaceutica): void -> Atualiza remédio x de farmaceutica y com os dados passados.
    public ArrayList<Remedio> encontrarTodosRemedios() {
        return remedios;
    }

    public void atualizarRemedio(String nome, String farmaceutica, String novoNome, Date dataVencimento, int quantidade,
                                 float concentracao, Farmaceutica novaFarmaceutica) {
        ArrayList<Remedio> remediosPesquisados = encontrarPorNome(nome);
        for (Remedio remedio : remediosPesquisados) {
            if (Objects.equals(remedio.farmaceutica.nome_farmaceutica, farmaceutica)) {
                remedio.setNome_remedio(novoNome);
                remedio.setData_vencimento(dataVencimento);
                remedio.setQuantidade(quantidade);
                remedio.setConcentracao(concentracao);
                remedio.setFarmaceutica(novaFarmaceutica);
            } else {
                System.out.println("Remédio não encontrado.");
            }
        }
    }
    //removerRemedio(String nome, String farmaceutica): void -> Remove remédio x de farmaceutica y do sistema.
    public void removerRemedio(String nome, String farmaceutica) {
        ArrayList<Remedio> remediosPesquisados = encontrarPorNome(nome);
        for (Remedio remedio : remediosPesquisados) {
            if (Objects.equals(remedio.farmaceutica.nome_farmaceutica, farmaceutica)) {
                remedios.remove(remedio);
            } else {
                System.out.println("Remédio não encontrado.");
            }
        }
    }
}
