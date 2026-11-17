package com.example.autoloc.repositories;

import com.example.autoloc.entities.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
}
