package pl.as.bazafilmow.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.as.bazafilmow.movie.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByCategory(Category category);
}

