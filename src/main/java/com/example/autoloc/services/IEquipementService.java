package com.example.autoloc.services;

import com.example.autoloc.entities.Equipement;

import java.util.List;

public interface IEquipementService {
    Equipement ajouterEquipement(Equipement equipement);
    Equipement modifierEquipement(Equipement equipement);
    List<Equipement> consulterEquipements();
    Equipement consulterEquipementById(long idEquipement);
    void supprimerEquipement(long idEquipement);

}
