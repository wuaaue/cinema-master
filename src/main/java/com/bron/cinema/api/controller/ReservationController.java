package com.bron.cinema.api.controller;

import com.bron.cinema.api.request.ReservationRequest;
import com.bron.cinema.api.service.ReservationService;
import com.bron.cinema.exception.ReservationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/make")
    public ResponseEntity<String> makeReservation(@RequestBody ReservationRequest request) {
        try {
            reservationService.makeReservation(request);
            return ResponseEntity.ok("Reservation successful");
        } catch (ReservationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

