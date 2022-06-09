package application.key;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PersonMovieKey implements Serializable {

    @Column(name = "person_id")
    private Long personId;

    @Column(name = "movie_id")
    private Long movieId;

    @Override
    public String toString() {
        return "PersonMovieKey{" +
                "personId=" + personId +
                ", movieId=" + movieId +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }
}
