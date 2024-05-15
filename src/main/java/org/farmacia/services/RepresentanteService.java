import java.util.ArrayList;
import java.util.List;

public class ManipulacaoRepresentante {

	ArrayList<Representante> representantes = new ArrayList<>();

    public void adicionarRepresentante(String nome, int telefone) {
        Representante representante = new Representante(nome, telefone);
        representantes.add(representante);
    }      

    public List<Representante> getRepresentantes() {
        return representantes;
    }

    // Esses são os métodos para manipular os representantes, como buscar por nome, excluir representante, etc.
}
