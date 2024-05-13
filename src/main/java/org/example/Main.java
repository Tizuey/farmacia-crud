package org.example;


import entities.Substancia;

public class Main {
    public static void main(String[] args) {

        Substancia substancia = new Substancia (Substancia.Tipo.Antidrepressivo,"Maleato de Fluvoxamina");
        System.out.println("esse é a susbatancia"+ substancia);
    }
}