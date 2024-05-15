package org.farmacia.services;

import org.farmacia.entities.Representante;

import java.util.ArrayList;

public class RepresentanteService {

	ArrayList<Representante> representantes = new ArrayList<>();

    public void adicionarRepresentante(String nome, int telefone) {
        Representante representante = new Representante(nome, telefone);
        representantes.add(representante);
    }      

    public ArrayList<Representante> getRepresentantes() {
        return representantes;
    }

    // Esses são os métodos para manipular os representantes, como buscar por nome, excluir representante, etc.
}
