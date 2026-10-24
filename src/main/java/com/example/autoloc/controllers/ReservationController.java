package com.example.autoloc.controllers;

import com.example.autoloc.entities.Reservation;
import com.example.autoloc.services.IReservationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("reservation")
@RestController
public class ReservationController {
    private final IReservationService reservationService;

    @PostMapping("/ajout")
    public Reservation ajouterReservation(@RequestBody Reservation reservation) {
        return reservationService.ajouterReservation(reservation);
    }

    @PutMapping("/modifier")
    public Reservation modifierReservation(@RequestBody Reservation reservation) {
        return reservationService.modifierReservation(reservation);
    }

    @GetMapping("/consulter")
    public List<Reservation> getall() {
        return reservationService.consulterReservations();
    }

    @GetMapping("/getById/{idReservation}")
    public Reservation getReservationById(@PathVariable Long idReservation) {
        return reservationService.consulterReservationById(idReservation);
    }

    @DeleteMapping("/delete/{idReservation}")
    public void deleteById(@PathVariable Long idReservation) {
        reservationService.supprimerReservationById(idReservation);
    }
}
