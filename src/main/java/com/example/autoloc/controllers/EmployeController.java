package com.example.autoloc.controllers;

import com.example.autoloc.entities.employee;
import com.example.autoloc.services.IEmployeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("employe")
@RestController
public class EmployeController {
    private final IEmployeService employeService;

    @PostMapping("/ajout")
    public employee ajouterEmploye(@RequestBody employee employe) {
        return employeService.ajouterEmploye(employe);
    }

    @PutMapping("/modifier")
    public employee modifierEmploye(@RequestBody employee employe) {
        return employeService.modifierEmploye(employe);
    }

    @GetMapping("/consulter")
    public List<employee> getall() {
        return employeService.consulterEmployes();
    }

    @GetMapping("/getById/{idEmploye}")
    public employee getEmployeById(@PathVariable Long idEmploye) {
        return employeService.consulterEmployeById(idEmploye);
    }

    @DeleteMapping("/delete/{idEmploye}")
    public void deleteById(@PathVariable Long idEmploye) {
        employeService.supprimerEmployeById(idEmploye);
    }
}
