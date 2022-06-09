package application.controller;


import application.dto.PersonRatingDto;
import application.service.PersonRatingService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/PersonRating")
public class PersonRatingController {

    private final PersonRatingService personRatingService;

    public  PersonRatingController(PersonRatingService ratingService){
        this.personRatingService = ratingService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        personRatingService.delete(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public void save(@RequestBody PersonRatingDto ratingDto) {
        personRatingService.save(ratingDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public void update(@RequestBody PersonRatingDto ratingDto) {
        personRatingService.update(ratingDto);
    }

    @GetMapping("/list")
    public List<PersonRatingDto> listRatings() {
        return personRatingService.listRatings();
    }

}
