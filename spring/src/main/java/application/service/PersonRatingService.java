package application.service;



import application.dto.PersonRatingDto;
import application.modell.PersonRating;
import application.repository.PersonRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonRatingService {

    @Autowired
    private PersonRatingRepository personRatingRepository;

    public void save(PersonRatingDto personRatingDto){

        PersonRating personRating = new PersonRating();
        personRating.setUserId(personRatingDto.getUserId());
        personRating.setPersonId(personRatingDto.getPersonId());
        personRating.setComment(personRatingDto.getComment());
        personRating.setRating(personRatingDto.getRating());

        personRatingRepository.save(personRating);
    }

    public void delete(Long id){
        personRatingRepository.deleteById(id);
    }

    public void update(PersonRatingDto personRatingDto){
        Optional<PersonRating> rating = personRatingRepository.findById(personRatingDto.getId());

        if (!rating.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "rating.not.found");
        }

        PersonRating rating2 = rating.get();
        rating2.setUserId(personRatingDto.getUserId());
        rating2.setPersonId(personRatingDto.getPersonId());
        rating2.setComment(personRatingDto.getComment());
        rating2.setRating(personRatingDto.getRating());

        personRatingRepository.save(rating2);

    }

    public List<PersonRatingDto> listRatings() {
        return personRatingRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private PersonRatingDto toDto(PersonRating rating) {

        PersonRatingDto ratingDto = new PersonRatingDto();

        ratingDto.setId(rating.getId());
        ratingDto.setUserId(rating.getUserId());
        ratingDto.setPersonId(rating.getPersonId());
        ratingDto.setComment(rating.getComment());
        ratingDto.setRating(rating.getRating());

        return ratingDto;
    }







}
