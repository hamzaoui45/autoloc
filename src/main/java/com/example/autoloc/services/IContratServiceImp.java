package com.example.autoloc.services;

import com.example.autoloc.entities.Contrat;
import com.example.autoloc.repositories.ContratRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IContratServiceImp implements IContratService {
    //@Autowired (non recommander)
    //private ContratRepository contratRepository;
    private final ContratRepository contratRepository;

    @Override
    public Contrat ajouterContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat modifierContrat(Contrat contrat) {
        return  contratRepository.save(contrat);
    }

    @Override
    public List<Contrat> ConsulterContrats() {
        return  contratRepository.findAll();
    }

    @Override
    public Contrat consulterContratById(long idContrat) {
        return  contratRepository.findById(idContrat).orElse(null);
    }

    @Override
    public void supprimerContrat(long idContrat) {
        contratRepository.deleteById(idContrat);

    }


}
