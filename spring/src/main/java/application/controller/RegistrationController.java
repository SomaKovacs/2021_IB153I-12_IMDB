package application.controller;

import application.dto.UserDto;
import application.dto.UserRegistrationDto;
import application.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void registration(@RequestBody UserRegistrationDto userRegistrationDto) {
        userService.save(userRegistrationDto);
    }
}
