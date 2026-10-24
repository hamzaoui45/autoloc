package com.example.autoloc.controllers;

import com.example.autoloc.entities.Contrat;
import com.example.autoloc.repositories.ContratRepo;
import com.example.autoloc.services.IContratService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("contrat")

@RestController
public class ContratController {
    private final IContratService contratService ;

    @PostMapping("/ajout")
    public Contrat ajouterContrat(@RequestBody Contrat contrat){
        return contratService.ajouterContrat(contrat);
    }

    @PutMapping("/modifier")
    public Contrat modifierContrat(@RequestBody Contrat contrat){
        return contratService.modifierContrat(contrat);
    }
    @GetMapping("/consulter")
    public List<Contrat> getall(){
        return contratService.consulterContrats();

    }
    @GetMapping("/getById/{idContrat}")
    public Contrat getContratById(@PathVariable Long idContrat){
        return contratService.consulterContratById(idContrat);

    }
    @DeleteMapping("/delete/{idContrat}")
    public  void deleteById(@PathVariable Long idContrat){
        contratService.supprimerContratById(idContrat);
    }




}
