package com.example.autoloc.repositories;

import com.example.autoloc.entities.Agence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenceRepo extends JpaRepository<Agence, Long> {
}
