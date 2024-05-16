package org.farmacia.repository;

import org.farmacia.entities.Farmaceutica;
import org.farmacia.entities.Substancia;
import java.util.ArrayList;
import java.util.Objects;

// Repositório de Substancia: Armazena substancias em memória em uma ArrayList
public class SubstanciaRepository {
    ArrayList<Substancia> substancias = new ArrayList<>();
    //save(Substancia):void -> Adiciona substancia ao banco de dados
    public void save(Substancia substancia) {
        substancias.add(substancia);
    }

    //encontrarPorNome(String nome): ArrayList<Substancia> -> Pesquisa por um nome e retorna substancias com este nome
    public ArrayList<Substancia> encontrarPorNome(String nome) {
        ArrayList<Substancia> substanciasPesquisados = new ArrayList<>();
        for (Substancia substancia : substancias) {
            if (Objects.equals(substancia.nome_substancia, nome)) {
                substanciasPesquisados.add(substancia);
            }
        }
        return substanciasPesquisados;

    //encontrarPorTipo(Tipo meuTipo): ArrayList<Substancia> -> Pesquisa por um Tipo e retorna tipo da substancia com este nome
        public ArrayList<Substancia> encontrarPorTipo(Tipo meuTipo) {
            ArrayList<Substancia> substanciasPesquisados = new ArrayList<>();
            for (Substancia substancia : substancias) {
                if (Objects.equals(substancia.Tipo_substancia, Tipo)) {
                    substanciasPesquisados.add(substancia);
                }
            }
            return substanciasPesquisados;
      
  }
