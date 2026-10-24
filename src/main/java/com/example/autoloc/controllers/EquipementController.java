package com.example.autoloc.controllers;

import com.example.autoloc.entities.Equipement;
import com.example.autoloc.services.IEquipementService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("equipement")
@RestController
public class EquipementController {
    private final IEquipementService equipementService;

    @PostMapping("/ajout")
    public Equipement ajouterEquipement(@RequestBody Equipement equipement) {
        return equipementService.ajouterEquipement(equipement);
    }

    @PutMapping("/modifier")
    public Equipement modifierEquipement(@RequestBody Equipement equipement) {
        return equipementService.modifierEquipement(equipement);
    }

    @GetMapping("/consulter")
    public List<Equipement> getall() {
        return equipementService.consulterEquipements();
    }

    @GetMapping("/getById/{idEquipement}")
    public Equipement getEquipementById(@PathVariable Long idEquipement) {
        return equipementService.consulterEquipementById(idEquipement);
    }

    @DeleteMapping("/delete/{idEquipement}")
    public void deleteById(@PathVariable Long idEquipement) {
        equipementService.supprimerEquipementById(idEquipement);
    }
}
