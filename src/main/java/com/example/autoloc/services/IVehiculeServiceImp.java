package com.example.autoloc.services;

import com.example.autoloc.entities.Equipement;
import com.example.autoloc.entities.Vehicule;
import com.example.autoloc.repositories.EquipementRepository;
import com.example.autoloc.repositories.VehiculeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.List;

@Service
@AllArgsConstructor
public class IVehiculeServiceImp implements IVehiculeService {

    private final VehiculeRepository vehiculeRepository;
    private final EquipementRepository equipementRepository;

    @Override
    public Vehicule ajouterVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule modifierVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public List<Vehicule> consulterVehicules() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Vehicule consulterVehiculeById(long idVehicule) {
        return vehiculeRepository.findById(idVehicule).orElse(null);
    }

    @Override
    public void supprimerVehicule(long idVehicule) {
        vehiculeRepository.deleteById(idVehicule);
    }

    @Override
    @Transactional
    public Vehicule affecterEquipement(Long idVehicule, Long idEquipement) {
        // 1) Récupérer le véhicule et l'équipement
        Vehicule vehicule = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Véhicule introuvable : " + idVehicule));
        Equipement equipement = equipementRepository.findById(idEquipement)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Équipement introuvable : " + idEquipement));

        // 2) Ajouter l'équipement à la liste du véhicule (côté propriétaire)
        if (vehicule.getEquipements() == null) {
            vehicule.setEquipements(new HashSet<>());
        }
        boolean dejaAffecte = vehicule.getEquipements().stream()
                .anyMatch(e -> e.getIdEquipement().equals(idEquipement));
        if (dejaAffecte) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Cet équipement est déjà affecté à ce véhicule");
        }
        vehicule.getEquipements().add(equipement);

        // 3) Mise à jour
        return vehiculeRepository.save(vehicule);
    }

    @Override
    @Transactional
    public Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement) {
        // 1) Récupérer le véhicule
        Vehicule vehicule = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Véhicule introuvable : " + idVehicule));

        // 2) Retirer l'équipement de la liste du véhicule (le lien disparaît, pas l'équipement)
        boolean retire = vehicule.getEquipements() != null
                && vehicule.getEquipements().removeIf(e -> e.getIdEquipement().equals(idEquipement));
        if (!retire) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Cet équipement n'est pas affecté à ce véhicule");
        }

        // 3) Mise à jour
        return vehiculeRepository.save(vehicule);
    }
}