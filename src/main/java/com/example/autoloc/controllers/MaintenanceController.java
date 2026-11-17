package com.example.autoloc.controllers;

import com.example.autoloc.entities.Maintenance;
import com.example.autoloc.services.IMaintenanceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/maintenance")
public class MaintenanceController {

    private final IMaintenanceService maintenanceService;

    @PostMapping
    public Maintenance ajouterMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.ajouterMaintenance(maintenance);
    }

    @PutMapping
    public Maintenance modifierMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.modifierMaintenance(maintenance);
    }

    @GetMapping
    public List<Maintenance> consulterMaintenances() {
        return maintenanceService.consulterMaintenances();
    }

    @GetMapping("/getById/{idMaintenance}")
    public Maintenance getByIdMaintenance(@PathVariable("idMaintenance") Long idMaintenance) {
        return maintenanceService.consulterMaintenanceById(idMaintenance);
    }

    @DeleteMapping("/delete/{idMaintenance}")
    public void deleteMaintenance(@PathVariable("idMaintenance") Long idMaintenance) {
        maintenanceService.supprimerMaintenance(idMaintenance);
    }
}