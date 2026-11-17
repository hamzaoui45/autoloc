package com.example.autoloc.services;

import com.example.autoloc.entities.Agence;

import java.util.List;

public interface IAgenceService {
    Agence ajouterAgence(Agence agence);
    Agence modifierAgence(Agence agence);
    List<Agence> consulterAgences();
    Agence consulterAgenceById(Long idAgence);
    void supprimerAgence(Long idAgence);

    Agence ajouterAgenceEtAffecterVehicules(Agence agence);
}