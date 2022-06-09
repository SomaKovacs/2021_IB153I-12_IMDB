package application.service;

import application.dto.MovieDto;
import application.dto.MovieWithPersonDto;
import application.dto.ParticipateMovieDto;
import application.key.GenreKey;
import application.key.PersonMovieKey;
import application.mapper.MovieMapper;
import application.mapper.PersonMapper;
import application.modell.Genre;
import application.modell.Movie;
import application.modell.Participates;
import application.modell.Person;
import application.repository.GenreRepository;
import application.repository.MovieRepository;
import application.repository.ParticipateRepository;
import application.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private ParticipateRepository participateRepository;
    @Autowired
    private GenreRepository genreRepository;

    public void save(MovieDto movieDto) {
        Movie movie = movieRepository.save(movieMapper.toMovie(movieDto));

        movieDto.getGenres().stream()
                .map(genre -> {
                    genre.getId().setMovieId(movie.getId());
                    genre.setMovie(movie);
                    return genre;
                })
                .collect(Collectors.toList());

        movie.setGenres(movieDto.getGenres());

        Set<Participates> participatesSet = movieDto.getParticipateDtoList().stream()
                .map(participateDto -> {

                    if (!personRepository.findById(participateDto.getPersonId()).isPresent()) {
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "person.not.found");
                    }
                    Person person = personRepository.findById(participateDto.getPersonId()).get();
                    Participates participates = new Participates();
                    participates.setId(new PersonMovieKey());
                    participates.getId().setMovieId(movie.getId());
                    participates.getId().setPersonId(person.getId());
                    participates.setMovie(movie);
                    participates.setPerson(person);
                    participates.setRole(participateDto.getRole());

                    return participates;
                })
                .collect(Collectors.toSet());

        movie.setParticipates(participatesSet);

        movieRepository.save(movie);
    }

    public void delete(Long id) {

        movieRepository.deleteById(id);
    }

    public void update(MovieDto movieDto) {

        Optional<Movie> movie = movieRepository.findById(movieDto.getId());

        if (!movie.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "movie.not.found");
        }
        Movie movie2 = movie.get();
        movie2.setTitle(movieDto.getTitle());
        movie2.setRelease_year(movieDto.getRelease_year());
        movie2.setDescription(movieDto.getDescription());
        movie2.setDuration(movieDto.getDuration());
        movie2.setPicture(movieDto.getPicture());

        movieDto.setGenres(
                movieDto.getGenres().stream()
                .map(genre -> {
                    GenreKey genreKey = new GenreKey();

                    genreKey.setMovieId(movie2.getId());
                    genreKey.setGenreName(genre.getId().getGenreName());

                    genre.setId(genreKey);
                    genre.setMovie(movie2);
                    return genre;
                })
                .collect(Collectors.toSet())
        );

        Set<GenreKey> forDeleteGenre = genreRepository.findByMovie(movie2).stream()
                .filter(genre -> !movieDto.getGenres().contains(genre))
                .map(Genre::getId)
                .collect(Collectors.toSet());

        genreRepository.deleteAllById(forDeleteGenre);

        Set<Genre> forSaveGenre = movieDto.getGenres().stream()
                .filter(genre -> !genreRepository.existsById(genre.getId()))
                .collect(Collectors.toSet());

        movie2.setGenres(forSaveGenre);

        Set<Participates> participatesSet = movieDto.getParticipateDtoList().stream()
                .map(participateDto -> {

                    if (!personRepository.findById(participateDto.getPersonId()).isPresent()) {
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "person.not.found");
                    }
                    Person person = personRepository.findById(participateDto.getPersonId()).get();
                    Participates participates = new Participates();
                    participates.setId(new PersonMovieKey());
                    participates.getId().setMovieId(movie2.getId());
                    participates.getId().setPersonId(person.getId());
                    participates.setMovie(movie2);
                    participates.setPerson(person);
                    participates.setRole(participateDto.getRole());

                    return participates;
                })
                .collect(Collectors.toSet());

        Set<Participates> forDelete = participateRepository.findAllByMovie(movie2).stream()
                .filter(participate -> !participatesSet.contains(participate))
                .collect(Collectors.toSet());

        participateRepository.deleteAll(forDelete);

        Set<Participates> forSave = participatesSet.stream()
                .filter(participates -> !participateRepository.existsById(participates.getId()))
                .collect(Collectors.toSet());

        movie2.setParticipates(forSave);

        movieRepository.save(movie2);
    }

    public List<MovieDto> listMovies() {
        return movieRepository.findAll().stream()
                .map(movieMapper::toDto)
                .collect(Collectors.toList());
    }

    public MovieWithPersonDto findById(long id) {

        Optional<Movie> movie = movieRepository.findById(id);

        if (!movie.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "movie.not.found");
        }

        return toMovieWithPersonDto(movie.get());
    }

    private MovieWithPersonDto toMovieWithPersonDto(Movie movie) {

        MovieWithPersonDto movieWithPersonDto = new MovieWithPersonDto();

        movieWithPersonDto.setId(movie.getId());
        movieWithPersonDto.setTitle(movie.getTitle());
        movieWithPersonDto.setDescription(movie.getDescription());
        movieWithPersonDto.setPicture(movie.getPicture());
        movieWithPersonDto.setDuration(movie.getDuration());
        movieWithPersonDto.setRelease_year(movie.getRelease_year());
        movieWithPersonDto.setGenres(movie.getGenres());

        List<ParticipateMovieDto> participateMovieDtoList = movie.getParticipates().stream()
                .map(participates ->  {
                    ParticipateMovieDto participateMovieDto = new ParticipateMovieDto();
                    participateMovieDto.setPersonDto(personMapper.toDto(participates.getPerson()));
                    participateMovieDto.setRole(participates.getRole());
                    return participateMovieDto;
                })
                .collect(Collectors.toList());

        movieWithPersonDto.setParticipateMovieDtoList(participateMovieDtoList);

        return movieWithPersonDto;
    }
}
