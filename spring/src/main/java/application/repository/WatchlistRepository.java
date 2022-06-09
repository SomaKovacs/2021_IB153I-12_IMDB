package application.repository;

import application.key.WatchlistKey;
import application.modell.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchlistRepository extends JpaRepository <Watchlist, WatchlistKey> {
}
