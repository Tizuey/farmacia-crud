package entities;

public class Representante {
    public String nome_representante ;
    public int telefone ;

    public Representante(String nome_representante, int telefone) {
        this.nome_representante = nome_representante;
        this.telefone = telefone;
    }

    public String getNome_representante() {
        return nome_representante;
    }

    public void setNome_representante(String nome_representante) {
        this.nome_representante = nome_representante;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Representante{" +
                "nome_representante = '" + nome_representante + '\'' +
                ", telefone = " + telefone +
                '}';
    }
}
