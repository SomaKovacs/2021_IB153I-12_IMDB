package application.modell;

import application.key.WatchlistKey;

import javax.persistence.*;

@Entity
@Table(name = "watchlist")
public class Watchlist {

    @EmbeddedId
    private WatchlistKey key = new WatchlistKey();

    public WatchlistKey getKey() {
        return key;
    }

    public long getUser_id() {
        return key.getUserId();
    }

    public void setUser_id(long user_id) {
        key.setUserId(user_id);
    }

    public long getMovie_id() {
        return key.getMovieId();
    }

    public void setMovie_id(long movie_id) {
        key.setMovieId(movie_id);
    }
}
