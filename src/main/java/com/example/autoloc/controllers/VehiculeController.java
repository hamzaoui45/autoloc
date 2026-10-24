package com.example.autoloc.controllers;

import com.example.autoloc.entities.Vehicule;
import com.example.autoloc.services.IVehiculeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("vehicule")
@RestController
public class VehiculeController {
    private final IVehiculeService vehiculeService;

    @PostMapping("/ajout")
    public Vehicule ajouterVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.ajouterVehicule(vehicule);
    }

    @PutMapping("/modifier")
    public Vehicule modifierVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.modifierVehicule(vehicule);
    }

    @GetMapping("/consulter")
    public List<Vehicule> getall() {
        return vehiculeService.consulterVehicules();
    }

    @GetMapping("/getById/{idVehicule}")
    public Vehicule getVehiculeById(@PathVariable Long idVehicule) {
        return vehiculeService.consulterVehiculeById(idVehicule);
    }

    @DeleteMapping("/delete/{idVehicule}")
    public void deleteById(@PathVariable Long idVehicule) {
        vehiculeService.supprimerVehiculeById(idVehicule);
    }
}
