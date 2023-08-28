package pl.as.bazafilmow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import java.time.LocalDate;

@SpringBootApplication
public class BazaFilmowApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(BazaFilmowApplication.class, args);
        ActorRepository actorRepository = context.getBean(ActorRepository.class);
        MovieRepository movieRepository = context.getBean(MovieRepository.class);

        Actor actor1 = new Actor("Margot", "Robbie", LocalDate.of(1990, 07, 02));
        Actor actor2 = new Actor("Cilian", "Murphy", LocalDate.of(1976, 05,25));
        Actor actor3 = new Actor("Leonardo", "DiCaprio", LocalDate.of(1974, 11, 11));
        Actor actor4 = new Actor("Ryan", "Gosling", LocalDate.of(1980, 11, 12));
        actorRepository.save(actor1);
        actorRepository.save(actor2);
        actorRepository.save(actor3);
        actorRepository.save(actor4);

        Movie movie1 = new Movie("BARBIE", LocalDate.of(2023, 07,21), Category.COMEDY);
        Movie movie2 = new Movie("OPPENHEIMER", LocalDate.of(2023, 07,21), Category.DRAMA);
        Movie movie3 = new Movie("WILK Z WALLSTREET", LocalDate.of(2013, 12,17), Category.COMEDY);
        movie1.addActor(actor1);
        movie1.addActor(actor4);
        movie2.addActor(actor2);
        movie2.addActor(actor3);
        movie3.addActor(actor3);
        movie3.addActor(actor1);

        movieRepository.save(movie1);
        movieRepository.save(movie2);
        movieRepository.save(movie3);
    }

}
