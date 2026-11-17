package com.example.autoloc.controllers;

import com.example.autoloc.entities.Equipement;
import com.example.autoloc.services.IEquipementService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/equipement")
public class EquipementController {

    private final IEquipementService equipementService;

    @PostMapping
    public Equipement ajouterEquipement(@RequestBody Equipement equipement) {
        return equipementService.ajouterEquipement(equipement);
    }

    @PutMapping
    public Equipement modifierEquipement(@RequestBody Equipement equipement) {
        return equipementService.modifierEquipement(equipement);
    }

    @GetMapping
    public List<Equipement> consulterEquipements() {
        return equipementService.consulterEquipements();
    }

    @GetMapping("/getById/{idEquipement}")
    public Equipement getByIdEquipement(@PathVariable("idEquipement") Long idEquipement) {
        return equipementService.consulterEquipementById(idEquipement);
    }

    @DeleteMapping("/delete/{idEquipement}")
    public void deleteEquipement(@PathVariable("idEquipement") Long idEquipement) {
        equipementService.supprimerEquipement(idEquipement);
    }
}