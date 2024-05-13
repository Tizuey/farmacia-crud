package org.farmacia.repository;

import org.farmacia.entities.Farmaceutica;
import org.farmacia.entities.Remedio;
import org.farmacia.entities.Substancia;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class RemedioRepository {

    ArrayList<Remedio> remedios;

    public void save(Remedio remedio) {
        remedios.add(remedio);
    }

    public Remedio encontrarPorNome(String nome) {
        for (Remedio remedio : remedios) {
            if (Objects.equals(remedio.nome_remedio, nome)) {
                return remedio;
            }
        }
        return null;
    }

    public Remedio encontrarPorValidade(Date validade) {
        for (Remedio remedio : remedios) {
            if (Objects.equals(remedio.data_vencimento, validade)) {
                return remedio;
            }
        }
        return null;
    }

    public Remedio encontrarPorFarmaceutica(String nome_farmaceutica) {
        for (Remedio remedio : remedios) {
            if (Objects.equals(remedio.farmaceutica.nome_farmaceutica, nome_farmaceutica)) {
                return remedio;
            }
        }
        return null;
    }

    public ArrayList<Remedio> encontrarTodosRemedios() {
        return remedios;
    }

    public void atualizarRemedio(String antigo_nome, Substancia.Tipo tipo, String nome, String nome_remedio, Date data_vencimento, int quantidade, float concentracao, Farmaceutica farmaceutica){
        Remedio remedio = encontrarPorNome(antigo_nome);
        remedios.remove(remedio);
        remedio.setNome_remedio(nome_remedio);
        remedio.setData_vencimento(data_vencimento);
        remedio.setQuantidade(quantidade);
        remedio.setConcentracao(concentracao);
        remedio.setFarmaceutica(farmaceutica);
        remedios.add(remedio);
    }

    public void removerRemedio(String nome) {
        Remedio remedio = encontrarPorNome(nome);
        remedios.remove(remedio);
    }
}
