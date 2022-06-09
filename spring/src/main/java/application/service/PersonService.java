package application.service;

import application.dto.*;
import application.key.PersonMovieKey;
import application.mapper.MovieMapper;
import application.mapper.PersonMapper;
import application.modell.Movie;
import application.modell.Participates;
import application.modell.Person;
import application.repository.MovieRepository;
import application.repository.ParticipateRepository;
import application.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ParticipateRepository participateRepository;

    public void save(PersonDto personDto) {
        Person person = personRepository.save(personMapper.toPerson(personDto));

        Set<Participates> participatesSet = personDto.getParticipateMovieDtoInSet().stream()
                .map(participateMovieDtoIn -> {

                    if (!movieRepository.findById(participateMovieDtoIn.getMovieId()).isPresent()) {
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "movie.not.found");
                    }
                    Movie movie = movieRepository.findById(participateMovieDtoIn.getMovieId()).get();

                    Participates participates = new Participates();

                    participates.setId(new PersonMovieKey());
                    participates.getId().setMovieId(movie.getId());
                    participates.getId().setPersonId(person.getId());
                    participates.setMovie(movie);
                    participates.setPerson(person);
                    participates.setRole(participateMovieDtoIn.getRole());

                    return participates;
                })
                .collect(Collectors.toSet());

        person.setParticipates(participatesSet);

        personRepository.save(person);
    }

    public void delete(Long id) {
        personRepository.deleteById(id);
    }

    public void update(PersonDto personDto) {

        Optional<Person> person = personRepository.findById(personDto.getId());

        if (!person.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "person.not.found");
        }

        Person person2 = person.get();

        person2.setName(personDto.getName());
        person2.setId(personDto.getId());
        person2.setDescription(personDto.getDescription());
        person2.setDateOfBirth(personDto.getDateOfBirth());
        person2.setPicture(personDto.getPicture());
        person2.setRoles(personDto.getRoles());
        person2.setSex(personDto.isSex());

        Set<Participates> participatesSet = personDto.getParticipateMovieDtoInSet().stream()
                .map(participateMovieDtoIn -> {

                    if (!movieRepository.findById(participateMovieDtoIn.getMovieId()).isPresent()) {
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "movie.not.found");
                    }
                    Movie movie = movieRepository.findById(participateMovieDtoIn.getMovieId()).get();
                    Participates participates = new Participates();
                    participates.setId(new PersonMovieKey());
                    participates.getId().setMovieId(movie.getId());
                    participates.getId().setPersonId(person2.getId());
                    participates.setMovie(movie);
                    participates.setPerson(person2);
                    participates.setRole(participateMovieDtoIn.getRole());

                    return participates;
                })
                .collect(Collectors.toSet());

        Set<Participates> forDelete = participateRepository.findAllByPerson(person2).stream()
                .filter(participate -> !participatesSet.contains(participate))
                .collect(Collectors.toSet());

        participateRepository.deleteAll(forDelete);

        Set<Participates> forSave = participatesSet.stream()
                .filter(participates -> !participateRepository.existsById(participates.getId()))
                .collect(Collectors.toSet());

        person2.setParticipates(forSave);

        personRepository.save(person2);
    }

    public List<PersonDto> listPerson() {

        return personRepository.findAll().stream()
                .map(personMapper::toDto)
                .collect(Collectors.toList());
    }

    public PersonWithMovieDto findById(long id) {

        Optional<Person> person = personRepository.findById(id);

        if (!person.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "person.not.found");
        }

        return toPersonWithMovie(person.get());
    }

    private PersonWithMovieDto toPersonWithMovie(Person person) {

        PersonWithMovieDto peronWithMovie = new PersonWithMovieDto();

        peronWithMovie.setId(person.getId());
        peronWithMovie.setName(person.getName());
        peronWithMovie.setDescription(person.getDescription());
        peronWithMovie.setPicture(person.getPicture());
        peronWithMovie.setDateOfBirth(person.getDateOfBirth());
        peronWithMovie.setRoles(person.getRoles());
        peronWithMovie.setSex(person.isSex());

        List<ParticipatePersonDto> participatePersonDtoList = person.getParticipates().stream()
                .map(participates ->  {
                    ParticipatePersonDto participatePersonDto = new ParticipatePersonDto();
                    participatePersonDto.setMovieDto(movieMapper.toDto(participates.getMovie()));
                    participatePersonDto.setRole(participates.getRole());
                    return participatePersonDto;
                })
                .collect(Collectors.toList());

        peronWithMovie.setParticipatePersonDtoList(participatePersonDtoList);

        return peronWithMovie;
    }
}
