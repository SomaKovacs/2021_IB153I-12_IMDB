package application.service;


import application.dto.UserDto;
import application.modell.User;
import application.dto.UserRegistrationDto;
import application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public void save(UserRegistrationDto userRegistrationDto) {

        if (userRepository.findByUserName(userRegistrationDto.getUserName()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "username.already.exist");
        }

        User user = new User();
        user.setUserName(userRegistrationDto.getUserName());
        user.setPassword(encoder.encode(userRegistrationDto.getPassword()));
        user.setEmail(userRegistrationDto.getEmail());
        user.setDateOfBirth(userRegistrationDto.getBirthDay());
        user.setActive(true);
        user.setRoles("ROLE_USER");

        userRepository.save(user);
    }

    public void delete(Long id) {

        userRepository.deleteById(id);
    }

    public void update(UserDto userDto) {

        Optional<User> user = userRepository.findById(userDto.getId());

        if (!user.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user.not.found");
        }
        User user2 = user.get();
        user2.setRoles(userDto.getRoles());
        user2.setUserName(userDto.getUserName());
        user2.setDateOfBirth(userDto.getDateOfBirth());
        user2.setEmail(userDto.getEmail());
        user2.setPicture(userDto.getPicture());


        userRepository.save(user2);
    }

    public List<UserDto> listUsers() {

        return userRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private UserDto toDto(User user) {

        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setUserName(user.getUserName());
        userDto.setDateOfBirth(user.getDateOfBirth());
        userDto.setEmail(user.getEmail());
        userDto.setActive(user.isActive());
        userDto.setRoles(user.getRoles());
        userDto.setPicture(user.getPicture());

        return userDto;
    }

    public UserDto getCurrentUser() {

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        return userRepository.findByUserName(userName).map(this::toDto).orElse(new UserDto());
    }

    public UserDto findById(long id) {

        Optional<User> user = userRepository.findById(id);

        if (!user.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "person.not.user");
        }

        return toDto(user.get());
    }
}
