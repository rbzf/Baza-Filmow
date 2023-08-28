package pl.as.bazafilmow;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class ActorController {
    final private ActorRepository actorRepository;
    final private MovieRepository movieRepository;
    private Optional<Actor> byActorId;
    private Optional<Movie> byMovieId;

    public ActorController(ActorRepository actorRepository, MovieRepository movieRepository) {

        this.actorRepository = actorRepository;
        this.movieRepository = movieRepository;
    }
    @GetMapping("/all_actors")
    public String home(Model model) {
        List<Actor> actors = actorRepository.findAll();
        model.addAttribute("allActors", actors);
        return "all_actors";
    }

    @GetMapping ("/actor/{id}")
    public String displayActors(@PathVariable Long id, Model model) {
        Optional<Actor> actorOptional = actorRepository.findById(id);
        if (actorOptional.isPresent()) {
            Actor actor = actorOptional.get();
            model.addAttribute("actor", actor);
            return "actor";
        } else {
            return "redirect:/";
        }
    }
    @GetMapping("/addNewActor")
    public String editForm(Model model) {
        Actor actorToAdd = new Actor();
        model.addAttribute("actorToAdd", actorToAdd);
        model.addAttribute("movies", movieRepository.findAll());
        return "form_actor";
    }

    @PostMapping("/addActor")
    public String addNewActor(Actor actor) {
        actorRepository.save(actor);
        return "redirect:/";
    }

}

