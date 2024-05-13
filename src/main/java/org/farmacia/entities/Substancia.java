package org.farmacia.entities;

public class Substancia {

    public enum Tipo {
        Alzheimer_Demencia, Antidrepressivo, Antipsicotico, Parkinson, Antinflamatorio_DorDeCabeca, Outros, Vitamina
    }

    public Tipo meuTipo;
    public String nome_susbstancia;

    public Substancia(Tipo tipo, String nome) {
        this.meuTipo = tipo;
        this.nome_susbstancia = nome;
    }


    public Tipo getMeuTipo() {
        return meuTipo;
    }

    public void setMeuTipo(Tipo meuTipo) {
        this.meuTipo = meuTipo;
    }

    public String getNome() {
        return nome_susbstancia;
    }

    public void setNome(String nome) {
        this.nome_susbstancia = nome;
    }

    @Override
    public String toString() {
        return "Substancia{" +
                "meuTipo=" + meuTipo +
                ", nome_susbstancia='" + nome_susbstancia + '\'' +
                '}';
    }
}
