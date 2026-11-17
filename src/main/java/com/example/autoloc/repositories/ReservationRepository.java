package com.example.autoloc.repositories;

import com.example.autoloc.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long>
{
}
