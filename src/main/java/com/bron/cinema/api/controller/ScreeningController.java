package com.bron.cinema.api.controller;

import com.bron.cinema.api.service.ScreeningService;
import com.bron.cinema.model.Screening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/screenings")
public class ScreeningController {

    private final ScreeningService screeningService;

    public ScreeningController(ScreeningService screeningService) {
        this.screeningService = screeningService;
    }

    @GetMapping("/{movieId}")
    public List<Screening> getScreeningsByMovieId(@PathVariable Long movieId) {
        return screeningService.getScreeningsByMovieId(movieId);
    }
}

