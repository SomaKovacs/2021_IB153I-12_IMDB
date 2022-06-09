package application.service;


import application.dto.MovieRatingDto;
import application.modell.MovieRating;
import application.repository.MovieRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class MovieRatingService {

    @Autowired
    private MovieRatingRepository ratingRepository;

    public void save(MovieRatingDto ratingDto) {

        MovieRating rating = new MovieRating();
        rating.setId(ratingDto.getId());
        rating.setRating(ratingDto.getStar());
        rating.setComment(ratingDto.getMessage());
        rating.setUserId(ratingDto.getUserId());
        rating.setMovieId(ratingDto.getMovieId());

        ratingRepository.save(rating);

    }

    public void delete(Long id) {

        ratingRepository.deleteById(id);
    }

     public void update(MovieRatingDto ratingDto) {

        Optional<MovieRating> rating = ratingRepository.findById(ratingDto.getId());

        if (!rating.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "rating.not.found");
        }
        MovieRating rating2 = rating.get();
        rating2.setId(ratingDto.getId());
        rating2.setRating(ratingDto.getStar());
        rating2.setComment(ratingDto.getMessage());
        rating2.setUserId(ratingDto.getUserId());
        rating2.setMovieId(ratingDto.getMovieId());

        ratingRepository.save(rating2);
    }

    public List<MovieRatingDto> listRatings() {
        return ratingRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private MovieRatingDto toDto(MovieRating rating) {

        MovieRatingDto ratingDto = new MovieRatingDto();

        ratingDto.setId(rating.getId());
        ratingDto.setStar(rating.getRating());
        ratingDto.setMessage(rating.getComment());
        ratingDto.setUserId(rating.getUserId());
        ratingDto.setMovieId(rating.getMovieId());

        return ratingDto;
    }

}
