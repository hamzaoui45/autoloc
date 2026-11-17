package com.example.autoloc.services;

import com.example.autoloc.entities.Agence;
import com.example.autoloc.entities.Employe;
import com.example.autoloc.repositories.AgenceRepository;
import com.example.autoloc.repositories.EmployeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class IEmployeServiceImp implements IEmployeService {

    private final EmployeRepository employeRepository;
    private final AgenceRepository agenceRepository;

    @Override
    public Employe ajouterEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public Employe modifierEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public List<Employe> consulterEmployes() {
        return employeRepository.findAll();
    }

    @Override
    public Employe consulterEmploye(Long idEmploye) {
        return employeRepository.findById(idEmploye).orElse(null);
    }

    @Override
    public void supprimerEmploye(Long idEmploye) {
        employeRepository.deleteById(idEmploye);
    }

    @Override
    @Transactional
    public Employe desaffecterEmploye(Long idEmploye) {
        // 1) Récupérer l'employé
        Employe employe = employeRepository.findById(idEmploye)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Employé introuvable : " + idEmploye));

        // 2) Supprimer le lien (côté propriétaire) : l'employé et l'agence restent en base
        employe.setAgence(null);

        // 3) Mise à jour
        return employeRepository.save(employe);
    }

    @Override
    @Transactional
    public Employe affecterEmploye(Long idEmploye, Long idAgence) {
        // 1) Récupérer l'employé et l'agence
        Employe employe = employeRepository.findById(idEmploye)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Employé introuvable : " + idEmploye));
        Agence agence = agenceRepository.findById(idAgence)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Agence introuvable : " + idAgence));

        // 2) Affecter l'agence à l'employé (côté propriétaire)
        employe.setAgence(agence);

        // 3) Mise à jour
        return employeRepository.save(employe);
    }
}