package application.controller;

import application.dto.WatchlistDto;
import application.service.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/watchlist")
public class WatchlistController {

    @Autowired
    private WatchlistService watchlistService;

    public WatchlistController(WatchlistService watchlistService) {
        this.watchlistService = watchlistService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{user_id}/{movie_id}")
    public void delete(@PathVariable long user_id, @PathVariable long movie_id) {
        watchlistService.delete(user_id, movie_id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public void save(@RequestBody WatchlistDto watchlistDto) {
        try{
            watchlistService.save(watchlistDto);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    @GetMapping("/{user_id}")
    public List<WatchlistDto> watchlist(@PathVariable long user_id) {
        return watchlistService.getWatchlist(user_id);
    }

    @GetMapping("/list")
    public List<WatchlistDto> listWatchlistEntires() {
        return watchlistService.getWatchlistEntires();
    }

}
