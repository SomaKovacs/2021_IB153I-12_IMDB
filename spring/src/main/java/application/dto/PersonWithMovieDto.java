package application.dto;

import java.time.LocalDate;
import java.util.List;

public class PersonWithMovieDto {

    private long id;
    private String name;
    private LocalDate dateOfBirth;
    private boolean sex;
    private String picture;
    private String roles;
    private String description;
    private List<ParticipatePersonDto> participatePersonDtoList;

    public List<ParticipatePersonDto> getParticipatePersonDtoList() {
        return participatePersonDtoList;
    }

    public void setParticipatePersonDtoList(List<ParticipatePersonDto> participatePersonDtoList) {
        this.participatePersonDtoList = participatePersonDtoList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
