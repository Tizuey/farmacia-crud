package org.farmacia.services;

import org.farmacia.repository.RemedioRepository;

import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RemedioService {

    RemedioRepository remedioRepository = new RemedioRepository();

    public void cadastrarRemedio() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome do remedio: ");
        String nome = sc.nextLine();
        int ano = 0;
        while (ano < Year.now().getValue()) {
            try {
                System.out.print("Digite o ano de vencimento: ");
                ano = sc.nextInt();
                if (ano < Year.now().getValue()) {
                    System.out.println("Por favor, insira um ano válido.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ano invalido.");
            }
        }
        int mes = -1;
        while (mes < 0 || mes > 12) {
            try {
                System.out.print("Digite o mês de vencimento (1-12): ");
                mes = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Mês invalido.");
            }
        }
        int dia = -1;
        while (dia < 0 || dia > 31) {
            try {
                System.out.print("Digite o dia de vencimento: ");
               dia = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Dia invalido.");
            }
        }
        Date date = new Date(ano, mes - 1, dia);
        System.out.print("Digite a quantidade do remédio em estoque: ");
        int quantidade = sc.nextInt();
        System.out.println("Digite a concentração do remédio: ");
        double concentracao = sc.nextDouble();
        System.out.println("Digite o nome da farmaceutica: ");
        String farmaceutica = sc.nextLine();
        sc.close();
    }
}
