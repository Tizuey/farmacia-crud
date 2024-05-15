package org.farmacia.entities;
// aqui é a classe de Substancia no qual se criara o objeto
public class Substancia {
// aqui para enumerar o tipos de substancias
    public enum Tipo {
        Alzheimer_Demencia, Antidrepressivo, Antipsicotico, Parkinson, Antinflamatorio_DorDeCabeca, Outros, Vitamina
    }

    public Tipo meuTipo;
    public String nome_susbstancia;
    // o seu contrutor que cria o objeto
    public Substancia(Tipo tipo, String nome) {
        this.meuTipo = tipo;
        this.nome_susbstancia = nome;
    }

    // os get e setter que são utilizados para manipular os atributos do objeto
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

    // trata a resposta , trazendo  os atributos do objeto
    @Override
    public String toString() {
        return "Substancia{" +
                "meuTipo=" + meuTipo +
                ", nome_susbstancia='" + nome_susbstancia + '\'' +
                '}';
    }
}
