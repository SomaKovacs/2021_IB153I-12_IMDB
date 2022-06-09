package application.dto;

import application.modell.Genre;

import java.util.List;
import java.util.Set;

public class MovieWithPersonDto {

    private long id;
    private String title;
    private int release_year;
    private String description;
    private String picture;
    private int duration;
    private List<ParticipateMovieDto> participateMovieDtoList;
    private Set<Genre> genres;

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public List<ParticipateMovieDto> getParticipateMovieDtoList() {
        return participateMovieDtoList;
    }

    public void setParticipateMovieDtoList(List<ParticipateMovieDto> participateMovieDtoList) {
        this.participateMovieDtoList = participateMovieDtoList;
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
