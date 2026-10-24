package com.example.autoloc.controllers;

import com.example.autoloc.entities.Maintenance;
import com.example.autoloc.services.IMaintenanceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("maintenance")
@RestController
public class MaintenanceController {
    private final IMaintenanceService maintenanceService;

    @PostMapping("/ajout")
    public Maintenance ajouterMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.ajouterMaintenance(maintenance);
    }

    @PutMapping("/modifier")
    public Maintenance modifierMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.modifierMaintenance(maintenance);
    }

    @GetMapping("/consulter")
    public List<Maintenance> getall() {
        return maintenanceService.consulterMaintenances();
    }

    @GetMapping("/getById/{idMaintenance}")
    public Maintenance getMaintenanceById(@PathVariable Long idMaintenance) {
        return maintenanceService.consulterMaintenanceById(idMaintenance);
    }

    @DeleteMapping("/delete/{idMaintenance}")
    public void deleteById(@PathVariable Long idMaintenance) {
        maintenanceService.supprimerMaintenanceById(idMaintenance);
    }
}
