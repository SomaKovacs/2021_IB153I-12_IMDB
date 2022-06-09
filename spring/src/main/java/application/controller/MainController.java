package application.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/actors")
    public String actors() {
        return "actors";
    }

    @GetMapping("/movies")
    public String movies() {
        return "movies";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @GetMapping("/movie")
    public String movie() {
        return "movie";
    }

    @GetMapping("/actor")
    public String actor() {
        return "actor";
    }
    
    @GetMapping("/users")
    public String users() {
        return "users";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

    @GetMapping("/watchlist")
    public String watchlist() {
        return "watchlist";
    }
    
    @GetMapping("/updateMovie")
    public String updateMovie() {
        return "updateMovie";
    }
    
    @GetMapping("/updateActor")
    public String updateActor() {
        return "updateActor";
    }
}
