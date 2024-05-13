package org.farmacia.entities;

import java.util.Date;

public class Remedio extends Substancia {
    public String nome_remedio;
    public Date data_vencimento;
    public int quantidade;
    public float concentracao;
    public Farmaceutica farmaceutica;

    public Remedio(Tipo tipo, String nome, String nome_remedio, Date data_vencimento, int quantidade, float concentracao, Farmaceutica farmaceutica) {
        super(tipo, nome);
        this.nome_remedio = nome_remedio;
        this.data_vencimento = data_vencimento;
        this.quantidade = quantidade;
        this.concentracao = concentracao;
        this.farmaceutica = farmaceutica;
    }

    public String getNome_remedio() {
        return nome_remedio;
    }

    public void setNome_remedio(String nome_remedio) {
        this.nome_remedio = nome_remedio;
    }

    public Date getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(Date data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getConcentracao() {
        return concentracao;
    }

    public void setConcentracao(float concentracao) {
        this.concentracao = concentracao;
    }

    public Farmaceutica getFarmaceutica() {
        return farmaceutica;
    }

    public void setFarmaceutica(Farmaceutica farmaceutica) {
        this.farmaceutica = farmaceutica;
    }

    @Override
    public String toString() {
        return "Remedio{" +
                "nome_remedio='" + nome_remedio + '\'' +
                ", data_vencimento=" + data_vencimento +
                ", quantidade=" + quantidade +
                ", concentracao=" + concentracao +
                ", farmaceutica=" + farmaceutica +
                ", meuTipo=" + meuTipo +
                ", nome_susbstancia='" + nome_susbstancia + '\'' +
                '}';
    }
}