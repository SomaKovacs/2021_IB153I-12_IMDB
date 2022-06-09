package application.service;

import application.dto.WatchlistDto;
import application.key.WatchlistKey;
import application.modell.Watchlist;
import application.repository.WatchlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import java.util.stream.Collectors;

@Service
public class WatchlistService {

    @Autowired
    private WatchlistRepository watchlistRepository;

    public void save(WatchlistDto watchlistDto) {

        Watchlist watchlist = new Watchlist();

        System.out.println(watchlistDto);

        watchlist.setUser_id(watchlistDto.getUser_id());
        watchlist.setMovie_id(watchlistDto.getMovie_id());

        watchlistRepository.save(watchlist);
    }

    public void delete(Long userId, Long rank){
        WatchlistKey key = new WatchlistKey();
        key.setUserId(userId);
        key.setMovieId(rank);
        delete(key);
    }

    public void delete(WatchlistKey key) {
        watchlistRepository.deleteById(key);
    }

    public void clearUser(Long id){
        for(WatchlistDto wl : getWatchlist(id)){
            WatchlistKey key = new WatchlistKey();
            key.setUserId(id);
            key.setMovieId(wl.getMovie_id());
            delete(key);
        }
    }

    public List<WatchlistDto> getWatchlist(Long id) {
        return watchlistRepository.findAll().stream()
                .map(this::toDto).filter(x -> Objects.equals(x.getUser_id(), id))
                .collect(Collectors.toList());
    }

    private WatchlistDto toDto(Watchlist watchlist) {

        WatchlistDto watchlistDto = new WatchlistDto();

        watchlistDto.setMovie_id(watchlist.getMovie_id());
        watchlistDto.setUser_id(watchlist.getUser_id());

        return watchlistDto;
    }

    public List<WatchlistDto> getWatchlistEntires() {
        return watchlistRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
