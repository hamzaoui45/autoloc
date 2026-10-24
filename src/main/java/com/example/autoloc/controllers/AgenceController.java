package com.example.autoloc.controllers;

import com.example.autoloc.entities.Agence;
import com.example.autoloc.services.IAgenceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("agence")
@RestController
public class AgenceController {
    private final IAgenceService agenceService;

    @PostMapping("/ajout")
    public Agence ajouterAgence(@RequestBody Agence agence) {
        return agenceService.ajouterAgence(agence);
    }

    @PutMapping("/modifier")
    public Agence modifierAgence(@RequestBody Agence agence) {
        return agenceService.modifierAgence(agence);
    }

    @GetMapping("/consulter")
    public List<Agence> getall() {
        return agenceService.consulterAgences();
    }

    @GetMapping("/getById/{idAgence}")
    public Agence getAgenceById(@PathVariable Long idAgence) {
        return agenceService.consulterAgenceById(idAgence);
    }

    @DeleteMapping("/delete/{idAgence}")
    public void deleteById(@PathVariable Long idAgence) {
        agenceService.supprimerAgenceById(idAgence);
    }
}
