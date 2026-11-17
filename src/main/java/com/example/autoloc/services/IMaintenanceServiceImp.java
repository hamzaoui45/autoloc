package com.example.autoloc.services;

import com.example.autoloc.entities.Maintenance;
import com.example.autoloc.repositories.MaintenanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class IMaintenanceServiceImp implements IMaintenanceService{
    private final MaintenanceRepository maintenanceRepository;

    @Override
    public Maintenance ajouterMaintenance(Maintenance maintenance) {
        return  maintenanceRepository.save(maintenance);
    }

    @Override
    public Maintenance modifierMaintenance(Maintenance maintenance) {
        return  maintenanceRepository.save(maintenance);
    }

    @Override
    public List<Maintenance> consulterMaintenances() {
        return  maintenanceRepository.findAll();
    }

    @Override
    public Maintenance consulterMaintenanceById(long idMaintenance) {
        return  maintenanceRepository.findById(idMaintenance).orElse(null);
    }

    @Override
    public void supprimerMaintenance(long idMaintenance) {
        maintenanceRepository.deleteById(idMaintenance);

    }
}
