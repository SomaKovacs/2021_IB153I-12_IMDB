package application.modell;

import application.key.GenreKey;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "genre")
public class Genre {

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("movieId")
    @JoinColumn(name = "movie_id")
    @JsonIgnore
    private Movie movie;
    @EmbeddedId
    private GenreKey id;

    public GenreKey getId() {
        return id;
    }

    public void setId(GenreKey id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

}
