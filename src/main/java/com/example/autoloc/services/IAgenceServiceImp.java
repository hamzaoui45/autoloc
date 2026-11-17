package com.example.autoloc.services;

import com.example.autoloc.entities.Agence;
import com.example.autoloc.entities.Vehicule;
import com.example.autoloc.repositories.AgenceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class IAgenceServiceImp implements IAgenceService {

    private final AgenceRepository agenceRepository;

    @Override
    public Agence ajouterAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public Agence modifierAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public List<Agence> consulterAgences() {
        return agenceRepository.findAll();
    }

    @Override
    public Agence consulterAgenceById(Long idAgence) {
        return agenceRepository.findById(idAgence).orElse(null);
    }

    @Override
    public void supprimerAgence(Long idAgence) {
        agenceRepository.deleteById(idAgence);
    }

    @Override
    @Transactional
    public Agence ajouterAgenceEtAffecterVehicules(Agence agence) {
        // 1) Affecter chaque véhicule à l'agence (côté propriétaire = Vehicule)
        if (agence.getVehicules() != null) {
            for (Vehicule vehicule : agence.getVehicules()) {
                vehicule.setAgence(agence);
            }
        }

        // 2) Enregistrer l'agence : les véhicules sont enregistrés en cascade (PERSIST)
        return agenceRepository.save(agence);
    }
}