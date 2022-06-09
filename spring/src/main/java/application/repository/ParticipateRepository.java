package application.repository;

import application.key.PersonMovieKey;
import application.modell.Movie;
import application.modell.Participates;
import application.modell.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipateRepository extends JpaRepository<Participates, PersonMovieKey> {

    List<Participates> findAllByPerson(Person person);

    List<Participates> findAllByMovie(Movie movie);
}
