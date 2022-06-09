package application.dto;

import application.modell.Genre;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MovieDto {

    private long id;
    private String title;
    private int release_year;
    private String description;
    private String picture;
    private int duration;
    private Set<Genre> genres = new HashSet<>();
    private List<ParticipatePersonDtoIn> participateDtoList;

    public List<ParticipatePersonDtoIn> getParticipateDtoList() {
        return participateDtoList;
    }

    public void setParticipateDtoList(List<ParticipatePersonDtoIn> participateDtoList) {
        this.participateDtoList = participateDtoList;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
