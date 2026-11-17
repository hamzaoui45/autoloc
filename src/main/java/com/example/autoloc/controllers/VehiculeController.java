package com.example.autoloc.controllers;

import com.example.autoloc.entities.Vehicule;
import com.example.autoloc.services.IVehiculeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/vehicule")
public class VehiculeController {

    private final IVehiculeService vehiculeService;

    @PostMapping
    public Vehicule ajouterVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.ajouterVehicule(vehicule);
    }

    @PutMapping
    public Vehicule modifierVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.modifierVehicule(vehicule);
    }

    @GetMapping
    public List<Vehicule> consulterVehicules() {
        return vehiculeService.consulterVehicules();
    }

    @GetMapping("/getById/{idVehicule}")
    public Vehicule getByIdVehicule(@PathVariable("idVehicule") Long idVehicule) {
        return vehiculeService.consulterVehiculeById(idVehicule);
    }

    @DeleteMapping("/delete/{idVehicule}")
    public void deleteVehicule(@PathVariable("idVehicule") Long idVehicule) {
        vehiculeService.supprimerVehicule(idVehicule);
    }

    @PutMapping("/affecterEquipement/{idVehicule}/{idEquipement}")
    public Vehicule affecterEquipement(@PathVariable("idVehicule") Long idVehicule,
                                       @PathVariable("idEquipement") Long idEquipement) {
        return vehiculeService.affecterEquipement(idVehicule, idEquipement);
    }

    @PutMapping("/desaffecterEquipement/{idVehicule}/{idEquipement}")
    public Vehicule desaffecterEquipement(@PathVariable("idVehicule") Long idVehicule,
                                          @PathVariable("idEquipement") Long idEquipement) {
        return vehiculeService.desaffecterEquipement(idVehicule, idEquipement);
    }
}