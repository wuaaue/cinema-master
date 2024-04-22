package com.bron.cinema.api.service;

import com.bron.cinema.api.request.ReservationRequest;
import com.bron.cinema.exception.ReservationException;
import com.bron.cinema.model.Reservation;
import com.bron.cinema.model.Screening;
import com.bron.cinema.repository.ReservationRepository;
import com.bron.cinema.repository.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ScreeningRepository screeningRepository;

    public void makeReservation(ReservationRequest request) throws ReservationException {
        Screening screening = screeningRepository.findById(request.getScreeningId())
                .orElseThrow(() -> new ReservationException("Screening not found"));

        if (screening.getAvailableSeats() < request.getSeatsBooked()) {
            throw new ReservationException("Not enough available seats");
        }

        Reservation reservation = new Reservation();
        reservation.setScreening(screening);
        reservation.setCustomerName(request.getCustomerName());
        reservation.setSeatsBooked(request.getSeatsBooked());
        reservation.setTotalPrice(screening.getPrice().multiply(BigDecimal.valueOf(request.getSeatsBooked())));
        reservation.setReservationTime(Timestamp.valueOf(LocalDateTime.now()));

        screening.setAvailableSeats(screening.getAvailableSeats() - request.getSeatsBooked());
        screeningRepository.save(screening);

        reservationRepository.save(reservation);
    }
}
