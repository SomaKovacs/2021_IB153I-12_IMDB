package application.modell;


import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class MovieRating {
    @Id
    @GeneratedValue(strategy = AUTO)
    private long id;
    private int userId;
    private int movieId;
    private int rating;
    private String comment;




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int star) {
        this.rating = star;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String message) {
        this.comment = message;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
}
