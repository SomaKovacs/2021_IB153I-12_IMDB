package application.controller;


import application.dto.MovieDto;
import application.dto.MovieWithPersonDto;
import application.service.MovieService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        movieService.delete(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public void save(@RequestBody MovieDto movieDto) {
        movieService.save(movieDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public void update(@RequestBody MovieDto movieDto) {
        movieService.update(movieDto);
    }

    @GetMapping("/list")
    public List<MovieDto> listMovies() {
        return movieService.listMovies();
    }

    @GetMapping("/{id}")
    public MovieWithPersonDto findById(@PathVariable long id) {
        return movieService.findById(id);
    }

}
