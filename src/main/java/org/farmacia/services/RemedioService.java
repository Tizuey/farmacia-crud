package org.farmacia.services;

import org.farmacia.entities.Farmaceutica;
import org.farmacia.entities.Remedio;
import org.farmacia.entities.Substancia;
import org.farmacia.repository.RemedioRepository;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RemedioService {

    RemedioRepository remedioRepository = new RemedioRepository();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public void cadastrarRemedio(Scanner sc) {
        String sub;
        String nome;
        LocalDate date;
        int quantidade = -1;
        float concentracao = -1;
        String farmaceuticaNome;
        System.out.println("-- CADASTRAR NOVO REMÉDIO --");
        System.out.print("Digite o nome da substância do remédio: ");
        sub = sc.nextLine();
        System.out.print("Digite o nome do remédio: ");
        nome = sc.nextLine();
        date = getDate(sc);
        while (quantidade < 0) {
            try {
                System.out.print("Digite a quantidade de remédios em estoque: ");
                quantidade = sc.nextInt();
                if (quantidade < 0) {
                    System.out.println("Por favor, insira uma quantidade válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira uma quantidade válida.");
                sc.nextLine();
            }
        }
        while (concentracao < 0) {
            try {
                System.out.print("Digite a concentração do remédio: ");
                concentracao = sc.nextFloat();
                if (concentracao < 0) {
                    System.out.println("Por favor, insira uma concentração válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira uma concentração válida.");
                sc.nextLine();
            }
        }
        sc.nextLine();
        System.out.print("Digite o nome da farmaceutica: ");
        farmaceuticaNome = sc.nextLine();
        Farmaceutica farm = new Farmaceutica("placeholder", -1, farmaceuticaNome);
        Remedio remedio = new Remedio(Substancia.Tipo.Outros, "Teste", nome, date, quantidade, concentracao, farm);
        System.out.println("Remédio cadastrado!");
        remedioRepository.save(remedio);
    }

    public void listarRemedios() {
        ArrayList<Remedio> remedios = remedioRepository.encontrarTodosRemedios();
        if (!remedios.isEmpty()) {
            System.out.print("REMÉDIOS CADASTRADOS ");
            System.out.println("_".repeat(19));
            System.out.printf("%-12s | %-12s | %-12s %n", "Substância", "Nome", "Vencimento");
            for (Remedio remedio : remedios) {
                System.out.printf("%-12s | %-12s | %-12s %n", remedio.nome_susbstancia, remedio.nome_remedio, remedio.data_vencimento.format(formatter));
            }
            System.out.println("_".repeat(40));
        } else {
            System.out.println("Remédios não encontrados.");
        }
    }

    public void buscarRemedioPorNome(Scanner sc) {
        System.out.print("Procurar pelo nome: ");
        String nome = sc.nextLine();
        ArrayList<Remedio> remedios = remedioRepository.encontrarPorNome(nome);
        if (!remedios.isEmpty()) {
            System.out.println("Remédios com o nome " + nome + " ");
            System.out.println("_".repeat(72));
            System.out.printf("%-12s | %-12s | %-12s | %-12s | %-12s%n", "Substancia", "Nome", "Vencimento", "Quantidade", "Concentração");
            for (Remedio remedio : remedios) {
                System.out.printf("%-12s | %-12s | %-12s | %-12s | %-12s%n", remedio.nome_susbstancia, remedio.nome_remedio, remedio.data_vencimento.format(formatter), remedio.quantidade, remedio.concentracao);
            }
            System.out.println("_".repeat(72));
        } else {
            System.out.println("Remédios não encontrados.");
        }
    }

    public void buscarRemedioPorValidade(Scanner sc) {
        LocalDate date = getDate(sc);
        ArrayList<Remedio> remedios = remedioRepository.encontrarPorValidade(date);
        if (!remedios.isEmpty()) {
            System.out.println("Remédios que vencem em " + date.format(formatter) + " ");
            System.out.println("_".repeat(72));
            System.out.printf("%-12s | %-12s | %-12s | %-12s | %-12s%n", "Substancia", "Nome", "Vencimento", "Quantidade", "Concentração");
            for (Remedio remedio : remedios) {
                System.out.printf("%-12s | %-12s | %-12s | %-12s | %-12s%n", remedio.nome_susbstancia, remedio.nome_remedio, remedio.data_vencimento.format(formatter), remedio.quantidade, remedio.concentracao);
            }
            System.out.println("_".repeat(72));
        } else {
            System.out.println("Remédios não encontrados.");
        }
    }

    public void buscarRemedioPorFarmaceutica(Scanner sc) {
        System.out.print("Farmaceutica: ");
        sc.nextLine();
        String farmaceutica = sc.nextLine();
        ArrayList<Remedio> remedios = remedioRepository.encontrarPorFarmaceutica(farmaceutica);
        if (!remedios.isEmpty()) {
            System.out.println("Remédios da farmaceutica " + farmaceutica + " ");
            System.out.println("_".repeat(72));
            System.out.printf("%-12s | %-12s | %-12s | %-12s | %-12s%n", "Substancia", "Nome", "Vencimento", "Quantidade", "Concentração");
            for (Remedio remedio : remedios) {
                System.out.printf("%-12s | %-12s | %-12s | %-12s | %-12s%n", remedio.nome_susbstancia, remedio.nome_remedio, remedio.data_vencimento.format(formatter), remedio.quantidade, remedio.concentracao);
            }
            System.out.println("_".repeat(72));
        } else {
            System.out.println("Remédios não encontrados.");
        }
    }

    public void save(Remedio remedio) {
        remedioRepository.save(remedio);
    }

    private LocalDate getDate(Scanner sc) {
        int ano = -1;
        int mes = -1;
        int dia = -1;
        while (ano < Year.now().getValue()) {
            try {
                System.out.print("Digite o ano de vencimento: ");
                ano = sc.nextInt();
                if (ano < Year.now().getValue()) {
                    System.out.println("Por favor, insira um ano válido.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um ano válido.");
                sc.nextLine();
            }
        }
        while (mes < 1 || mes > 12) {
            try {
                System.out.print("Digite o mês de vencimento (1-12): ");
                mes = sc.nextInt();
                if (mes < 1 || mes > 12) {
                    System.out.println("Por favor, insira um mês válido.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um mês válido.");
                sc.nextLine();
            }
        }
        while (dia < 0 || dia > 31) {
            try {
                System.out.print("Digite o dia de vencimento: ");
                dia = sc.nextInt();
                if (dia < 0 || dia > 31) {
                    System.out.println("Por favor, insira um dia válido.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um dia válido.");
                sc.nextLine();
            }
        }
        LocalDate date = LocalDate.of(ano, mes, dia);
        return date;
    }
}
