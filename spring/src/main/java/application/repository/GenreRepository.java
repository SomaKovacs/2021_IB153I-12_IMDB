package application.repository;

import application.key.GenreKey;
import application.modell.Genre;
import application.modell.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre, GenreKey> {

    List<Genre> findByMovie(Movie movie);
}
