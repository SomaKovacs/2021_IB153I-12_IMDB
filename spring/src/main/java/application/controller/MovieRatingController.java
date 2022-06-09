package application.controller;


import application.dto.MovieRatingDto;
import application.service.MovieRatingService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class MovieRatingController {

    private final MovieRatingService ratingService;

    public MovieRatingController(MovieRatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        ratingService.delete(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public void save(@RequestBody MovieRatingDto ratingDto) {
        ratingService.save(ratingDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public void update(@RequestBody MovieRatingDto ratingDto) {
        ratingService.update(ratingDto);
    }

    @GetMapping("/list")
    public List<MovieRatingDto> listRatings() {
        return ratingService.listRatings();
    }
}
