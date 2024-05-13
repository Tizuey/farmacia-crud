import org.farmacia.entities.Farmaceutica;
import org.farmacia.entities.Remedio;
import org.farmacia.entities.Substancia;
import org.farmacia.repository.RemedioRepository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TesteRepositorioRemedios {
    static boolean testeRepositorioRemedios() {
        ArrayList<Remedio> resposta = new ArrayList<>();
        RemedioRepository repository = new RemedioRepository();
        Substancia acido = new Substancia(Substancia.Tipo.Outros, "Acido");
        Farmaceutica drogasil = new Farmaceutica("Zé", 999, "Fulano");
        Remedio acidoSufurico = new Remedio(acido.meuTipo, acido.nome_susbstancia, "Acido Sufurico",
                                new Date(2024, Calendar.DECEMBER, 2), 10, 05F, drogasil);
        resposta.add(acidoSufurico);
        repository.save(acidoSufurico);

        boolean teste = resposta.equals(repository.encontrarTodosRemedios());
        System.out.println(teste ? "O repositório está funcionando." : "O repositório não está funcionando.");
        return teste;
    }
}
