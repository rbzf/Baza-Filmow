package pl.as.bazafilmow.movie;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import pl.as.bazafilmow.actor.Actor;
import pl.as.bazafilmow.movie.Category;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate premiereDate;
    @Enumerated(EnumType.STRING)
    private Category category;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Actor> actors = new ArrayList<>();

    public Movie() {
    }

    public Movie(Long id, String title, LocalDate premiereDate, Category category) {
        this.id = id;
        this.title = title;
        this.premiereDate = premiereDate;
        this.category = category;
    }

    public Movie(String title, LocalDate premiereDate, Category category) {
        this.title = title;
        this.premiereDate = premiereDate;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPremiereDate() {
        return premiereDate;
    }

    public void setPremiereDate(LocalDate premiereDate) {
        this.premiereDate = premiereDate;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", premiereDate=" + premiereDate +
                ", category=" + category +
                '}';
    }

}
