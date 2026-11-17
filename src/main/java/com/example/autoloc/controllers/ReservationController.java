package com.example.autoloc.controllers;

import com.example.autoloc.entities.Reservation;
import com.example.autoloc.services.IReservationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {

    private final IReservationService reservationService;

    @PostMapping
    public Reservation ajouterReservation(@RequestBody Reservation reservation) {
        return reservationService.ajouterReservation(reservation);
    }

    @PutMapping
    public Reservation modifierReservation(@RequestBody Reservation reservation) {
        return reservationService.modifierReservation(reservation);
    }

    @GetMapping
    public List<Reservation> consulterReservations() {
        return reservationService.consulterReservations();
    }

    @GetMapping("/getById/{idReservation}")
    public Reservation getByIdReservation(@PathVariable("idReservation") Long idReservation) {
        return reservationService.consulterReservationById(idReservation);
    }

    @DeleteMapping("/delete/{idReservation}")
    public void deleteReservation(@PathVariable("idReservation") Long idReservation) {
        reservationService.supprimerReservation(idReservation);
    }
}