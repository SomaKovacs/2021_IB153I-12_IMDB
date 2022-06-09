package application.controller;


import application.dto.PersonDto;
import application.dto.PersonWithMovieDto;
import application.service.PersonService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        personService.delete(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public void save(@RequestBody PersonDto personDto) {
        personService.save(personDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public void update(@RequestBody PersonDto personDto) {
        personService.update(personDto);
    }

    @GetMapping("/list")
    public List<PersonDto> listPerson() {
        return personService.listPerson();
    }

    @GetMapping("/{id}")
    public PersonWithMovieDto findById(@PathVariable long id) {
        return personService.findById(id);
    }
}
