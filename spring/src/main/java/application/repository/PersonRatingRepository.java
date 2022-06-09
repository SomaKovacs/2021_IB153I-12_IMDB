package application.repository;

import application.modell.PersonRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRatingRepository extends JpaRepository <PersonRating, Long>{
}
