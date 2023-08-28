package pl.as.bazafilmow;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import java.util.Optional;


@Controller
public class MovieController {
    final private MovieRepository movieRepository;
    final private ActorRepository actorRepository;
    private Optional<Movie> movieById;

    public MovieController(MovieRepository movieRepository, ActorRepository actorRepository) {
        this.movieRepository = movieRepository;
        this.actorRepository = actorRepository;
    }


    @GetMapping("/movie/{id}")
    public String displayMovies(@PathVariable Long id, Model model) {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if (movieOptional.isPresent()) {
            Movie movie = movieOptional.get();
            model.addAttribute("movie", movie);
            return "movie";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/all_movies")
    public String home(Model model) {
        List<Movie> movies = movieRepository.findAll();
        model.addAttribute("allMovies", movies);
        return "all_movies";
    }

    @GetMapping("/addNewMovie")
    public String editFormMovie(Model model) {
        Movie movieToAdd = new Movie();
        model.addAttribute("movieToAdd", movieToAdd);
        model.addAttribute("actors", actorRepository.findAll());
        return "form_movie";
    }

    @PostMapping("/addMovie")
    public String addNewMovie(Movie movie) {
        movieRepository.save(movie);
        return "redirect:/";
    }
}

