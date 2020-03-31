package com.springboot306.springboot_306;

import javax.persistence.*;

@Entity
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String genre;
    private String name;

    @OneToMany(mappedBy = "director", cascade = cascadeType.ALL, fetch = FetchType.EAGER)
    public  Set<Movie> movies;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
