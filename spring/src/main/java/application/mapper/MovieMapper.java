package application.mapper;

import application.dto.MovieDto;
import application.dto.ParticipatePersonDtoIn;
import application.modell.Movie;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class MovieMapper {

    public MovieDto toDto(Movie movie) {

        MovieDto movieDto = new MovieDto();

        movieDto.setId(movie.getId());
        movieDto.setTitle(movie.getTitle());
        movieDto.setDescription(movie.getDescription());
        movieDto.setPicture(movie.getPicture());
        movieDto.setDuration(movie.getDuration());
        movieDto.setRelease_year(movie.getRelease_year());
        movieDto.setGenres(movie.getGenres());
        movieDto.setParticipateDtoList(
                movie.getParticipates().stream()
                .map(participates -> {
                    ParticipatePersonDtoIn participatePersonDtoIn = new ParticipatePersonDtoIn();

                    participatePersonDtoIn.setPersonId(participates.getPerson().getId());
                    participatePersonDtoIn.setRole(participates.getRole());
                    return participatePersonDtoIn;
                })
                .collect(Collectors.toList())
        );

        return movieDto;
    }

    public Movie toMovie(MovieDto movieDto) {

        Movie movie = new Movie();
        movie.setTitle(movieDto.getTitle());
        movie.setRelease_year(movieDto.getRelease_year());
        movie.setDescription(movieDto.getDescription());
        movie.setDuration(movieDto.getDuration());
        movie.setPicture(movieDto.getPicture());

        return movie;
    }
}
