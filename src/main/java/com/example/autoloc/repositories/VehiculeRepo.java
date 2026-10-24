package com.example.autoloc.repositories;

import com.example.autoloc.entities.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculeRepo extends JpaRepository<Vehicule, Long> {
}
