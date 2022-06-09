package application.controller;



import application.service.UserService;
import application.dto.UserDto;
import org.springframework.boot.SpringApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("hasRole('ADMIN') or (isAuthenticated() and @currentUserSec.ownId(#id))")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        userService.delete(id);
    }

    @PreAuthorize("hasRole('ADMIN') or (isAuthenticated() and @currentUserSec.ownId(#userDto.id))")
    @PutMapping
    public void update(@RequestBody UserDto userDto) {
        userService.update(userDto);
    }

    @GetMapping("/list")
    public List<UserDto> listUsers() {
        return userService.listUsers();
    }

    @GetMapping("/current-user")
    public UserDto getCurrentUser() {
        return userService.getCurrentUser();
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable long id) {
        return userService.findById(id);
    }

    interface currentUserSec {
        boolean ownId(long id);
    }

    @Component(value = "currentUserSec")
    class currentUserSecImpl implements currentUserSec {
        @Override
        public boolean ownId(long id) {
            return getCurrentUser().getId() == id;
        }

    }
}
