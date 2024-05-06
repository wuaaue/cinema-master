package com.bron.cinema.api.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReservationRequest {
    private Long screeningId;
    private String customerName;
    private int seatsBooked;

}

