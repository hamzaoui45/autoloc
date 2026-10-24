package com.example.autoloc.services;

import com.example.autoloc.entities.employee;

import java.util.List;

public interface IEmployeService {
    employee ajouterEmploye(employee employe);
    employee modifierEmploye(employee employe);
    List<employee> consulterEmployes();
    employee consulterEmployeById(Long idEmploye);
    void supprimerEmployeById(Long idEmploye);
}
