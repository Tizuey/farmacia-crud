package entities;

public class Farmaceutica extends Representante{

    public String nome_farmaceutica;

    public Farmaceutica(String nome_representante, int telefone, String nome_farmaceutica) {
        super(nome_representante, telefone);
        this.nome_farmaceutica = nome_farmaceutica;
    }

    public String getNome_farmaceutica() {
        return nome_farmaceutica;
    }

    public void setNome_farmaceutica(String nome_farmaceutica) {
        this.nome_farmaceutica = nome_farmaceutica;
    }

    @Override
    public String toString() {
        return "Farmaceutica{" +
                "nome_farmaceutica='" + nome_farmaceutica + '\'' +
                ", nome_representante='" + nome_representante + '\'' +
                ", telefone=" + telefone +
                '}';
    }
}
