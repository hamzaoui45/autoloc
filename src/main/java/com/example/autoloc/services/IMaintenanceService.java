package com.example.autoloc.services;

import com.example.autoloc.entities.Maintenance;

import java.util.List;

public interface IMaintenanceService {
    Maintenance ajouterMaintenance(Maintenance maintenance);
    Maintenance modifierMaintenance(Maintenance maintenance);
    List<Maintenance> consulterMaintenances();
    Maintenance consulterMaintenanceById(long idMaintenance);
    void supprimerMaintenance(long idMaintenance);

}
