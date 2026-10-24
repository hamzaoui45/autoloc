package com.example.autoloc.services;

import com.example.autoloc.entities.employee;
import com.example.autoloc.repositories.EmployeRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IEmployeServiceimp implements IEmployeService {
    private final EmployeRepo employeRepository;

    @Override
    public employee ajouterEmploye(employee employe) {
        return employeRepository.save(employe);
    }

    @Override
    public employee modifierEmploye(employee employe) {
        return employeRepository.save(employe);
    }

    @Override
    public List<employee> consulterEmployes() {
        return employeRepository.findAll();
    }

    @Override
    public employee consulterEmployeById(Long idEmploye) {
        return employeRepository.findById(idEmploye).orElse(null);
    }

    @Override
    public void supprimerEmployeById(Long idEmploye) {
        employeRepository.deleteById(idEmploye);
    }
}
