import org.farmacia.entities.Farmaceutica;
import org.farmacia.entities.Remedio;
import org.farmacia.entities.Substancia;
import org.farmacia.services.RemedioService;

import java.time.LocalDate;
import java.util.Scanner;

public class TesteRemedios {
    static void testeRepositorioRemedios() {
        Substancia acido = new Substancia(Substancia.Tipo.Outros, "Acido");
        Farmaceutica drogasil = new Farmaceutica("Zé", 999, "Fulano");
        Scanner sc = new Scanner(System.in);
        Remedio remedio = new Remedio(Substancia.Tipo.Outros, "Ácido", "Teste1", LocalDate.now(), 9, 1, drogasil);
        Remedio remedio1 = new Remedio(Substancia.Tipo.Outros, "Ácido", "Teste2", LocalDate.now(), 9, 1, drogasil);
        Remedio remedio2 = new Remedio(Substancia.Tipo.Outros, "Ácido", "Teste3", LocalDate.now(), 9, 1, drogasil);


        RemedioService remedioService = new RemedioService();
        remedioService.cadastrarRemedio(sc);
        remedioService.save(remedio);
        remedioService.save(remedio1);
        remedioService.save(remedio2);
        remedioService.buscarRemedioPorNome(sc);
        remedioService.buscarRemedioPorValidade(sc);
        remedioService.buscarRemedioPorFarmaceutica(sc);
        remedioService.listarRemedios();
    }
}
