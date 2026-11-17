package com.example.autoloc.services;

import com.example.autoloc.entities.Reservation;
import com.example.autoloc.repositories.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class IReservationServiceImp implements IReservationService{
    private final ReservationRepository reservationRepository;
    @Override
    public Reservation ajouterReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation modifierReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> consulterReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation consulterReservationById(long idReservation) {
        return reservationRepository.getOne(idReservation);
    }

    @Override
    public void supprimerReservation(long idReservation) {
        reservationRepository.deleteById(idReservation);

    }
}
