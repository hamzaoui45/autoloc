package com.example.autoloc.controllers;

import com.example.autoloc.entities.Agence;
import com.example.autoloc.services.IAgenceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/agence")
public class AgenceController {

    private final IAgenceService agenceService;

    @PostMapping
    public Agence ajouterAgence(@RequestBody Agence agence) {
        return agenceService.ajouterAgence(agence);
    }

    @PutMapping
    public Agence modifierAgence(@RequestBody Agence agence) {
        return agenceService.modifierAgence(agence);
    }

    @GetMapping
    public List<Agence> consulterAgences() {
        return agenceService.consulterAgences();
    }

    @GetMapping("/getById/{idAgence}")
    public Agence getByIdAgence(@PathVariable("idAgence") Long idAgence) {
        return agenceService.consulterAgenceById(idAgence);
    }

    @DeleteMapping("/delete/{idAgence}")
    public void deleteAgence(@PathVariable("idAgence") Long idAgence) {
        agenceService.supprimerAgence(idAgence);
    }

    @PostMapping("/ajouterAvecVehicules")
    public Agence ajouterAgenceEtAffecterVehicules(@RequestBody Agence agence) {
        return agenceService.ajouterAgenceEtAffecterVehicules(agence);
    }
}