package application.mapper;

import application.dto.ParticipateMovieDtoIn;
import application.dto.ParticipatePersonDtoIn;
import application.dto.PersonDto;
import application.modell.Person;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PersonMapper {

    public PersonDto toDto(Person person) {

        PersonDto personDto = new PersonDto();

        personDto.setName(person.getName());
        personDto.setId(person.getId());
        personDto.setDescription(person.getDescription());
        personDto.setDateOfBirth(person.getDateOfBirth());
        personDto.setPicture(person.getPicture());
        personDto.setRoles(person.getRoles());
        personDto.setSex(person.isSex());
        personDto.setParticipateMovieDtoInSet(
                person.getParticipates().stream()
                .map(participates -> {
                    ParticipateMovieDtoIn participateMovieDtoIn = new ParticipateMovieDtoIn();
                    participateMovieDtoIn.setMovieId(participates.getMovie().getId());
                    participateMovieDtoIn.setRole(participates.getRole());
                    return participateMovieDtoIn;
                })
                .collect(Collectors.toSet())
        );

        return personDto;
    }

    public Person toPerson(PersonDto personDto) {

        Person person = new Person();

        person.setName(personDto.getName());
        person.setDescription(personDto.getDescription());
        person.setDateOfBirth(personDto.getDateOfBirth());
        person.setSex(personDto.isSex());
        person.setRoles(personDto.getRoles());
        person.setPicture(personDto.getPicture());

        return person;
    }
}
