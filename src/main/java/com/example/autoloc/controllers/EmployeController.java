package com.example.autoloc.controllers;

import com.example.autoloc.entities.Employe;
import com.example.autoloc.services.IEmployeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/employe")
public class EmployeController {

    private final IEmployeService employeService;

    @PostMapping
    public Employe ajouterEmploye(@RequestBody Employe employe) {
        return employeService.ajouterEmploye(employe);
    }

    @PutMapping
    public Employe modifierEmploye(@RequestBody Employe employe) {
        return employeService.modifierEmploye(employe);
    }

    @GetMapping
    public List<Employe> consulterEmployes() {
        return employeService.consulterEmployes();
    }

    @GetMapping("/getById/{idEmploye}")
    public Employe getByIdEmploye(@PathVariable("idEmploye") Long idEmploye) {
        return employeService.consulterEmploye(idEmploye);
    }

    @DeleteMapping("/delete/{idEmploye}")
    public void deleteEmploye(@PathVariable("idEmploye") Long idEmploye) {
        employeService.supprimerEmploye(idEmploye);
    }

    @PutMapping("/desaffecter/{idEmploye}")
    public Employe desaffecterEmploye(@PathVariable("idEmploye") Long idEmploye) {
        return employeService.desaffecterEmploye(idEmploye);
    }

    @PutMapping("/affecter/{idEmploye}/{idAgence}")
    public Employe affecterEmploye(@PathVariable("idEmploye") Long idEmploye,
                                   @PathVariable("idAgence") Long idAgence) {
        return employeService.affecterEmploye(idEmploye, idAgence);
    }
}