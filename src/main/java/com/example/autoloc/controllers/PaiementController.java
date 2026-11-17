package com.example.autoloc.controllers;

import com.example.autoloc.entities.Paiement;
import com.example.autoloc.services.IPaiementService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/paiement")
public class PaiementController {

    private final IPaiementService paiementService;

    @PostMapping
    public Paiement ajouterPaiement(@RequestBody Paiement paiement) {
        return paiementService.ajouterPaiement(paiement);
    }

    @PutMapping
    public Paiement modifierPaiement(@RequestBody Paiement paiement) {
        return paiementService.modifierPaiement(paiement);
    }

    @GetMapping
    public List<Paiement> consulterPaiements() {
        return paiementService.consulterPaiements();
    }

    @GetMapping("/getById/{idPaiement}")
    public Paiement getByIdPaiement(@PathVariable("idPaiement") Long idPaiement) {
        return paiementService.consulterPaiementById(idPaiement);
    }

    @DeleteMapping("/delete/{idPaiement}")
    public void deletePaiement(@PathVariable("idPaiement") Long idPaiement) {
        paiementService.supprimerPaiement(idPaiement);
    }
}