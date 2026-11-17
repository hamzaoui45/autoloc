package com.example.autoloc.services;

import com.example.autoloc.entities.Reservation;

import java.util.List;

public interface IReservationService{
    Reservation ajouterReservation(Reservation reservation);
    Reservation modifierReservation(Reservation reservation);
    List<Reservation> consulterReservations();
    Reservation consulterReservationById(long idReservation);
    void supprimerReservation(long idReservation);

}
