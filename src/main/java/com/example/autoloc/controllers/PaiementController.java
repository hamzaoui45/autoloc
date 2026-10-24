package com.example.autoloc.controllers;

import com.example.autoloc.entities.Paiement;
import com.example.autoloc.services.IPaiementService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("paiement")
@RestController
public class PaiementController {
    private final IPaiementService paiementService;

    @PostMapping("/ajout")
    public Paiement ajouterPaiement(@RequestBody Paiement paiement) {
        return paiementService.ajouterPaiement(paiement);
    }

    @PutMapping("/modifier")
    public Paiement modifierPaiement(@RequestBody Paiement paiement) {
        return paiementService.modifierPaiement(paiement);
    }

    @GetMapping("/consulter")
    public List<Paiement> getall() {
        return paiementService.consulterPaiements();
    }

    @GetMapping("/getById/{idPaiement}")
    public Paiement getPaiementById(@PathVariable Long idPaiement) {
        return paiementService.consulterPaiementById(idPaiement);
    }

    @DeleteMapping("/delete/{idPaiement}")
    public void deleteById(@PathVariable Long idPaiement) {
        paiementService.supprimerPaiementById(idPaiement);
    }
}
