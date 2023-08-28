package pl.as.bazafilmow;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;
import java.util.Optional;

@Controller
public class MainController {
    final private MovieRepository movieRepository;
    final private ActorRepository actorRepository;
    private Optional<Movie> movieById;

    public MainController(MovieRepository movieRepository, ActorRepository actorRepository) {
        this.movieRepository = movieRepository;
        this.actorRepository = actorRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }
}

