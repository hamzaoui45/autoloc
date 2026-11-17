package com.example.autoloc.services;

import com.example.autoloc.entities.Vehicule;

import java.util.List;

public interface IVehiculeService {
    Vehicule ajouterVehicule(Vehicule vehicule);
    Vehicule modifierVehicule(Vehicule vehicule);
    List<Vehicule> consulterVehicules();
    Vehicule consulterVehiculeById(long idVehicule);
    void supprimerVehicule(long idVehicule);

    Vehicule affecterEquipement(Long idVehicule, Long idEquipement);
    Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement);
}