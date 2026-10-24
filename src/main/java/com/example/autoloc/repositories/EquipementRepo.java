package com.example.autoloc.repositories;

import com.example.autoloc.entities.Equipement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipementRepo extends JpaRepository<Equipement, Long> {
}
