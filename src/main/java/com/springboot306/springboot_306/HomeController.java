package com.springboot306.springboot_306;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    DirectorRepository directorRepository;

    @RequestMapping("/")
    public String index(Model model) {
        // 1st let's create a director
        Director director = new Director();
        director.setName("Stephen Bullock");
        director.setGenre("Sci Fi");

        // create a Movie
        Movie movie = new Movie();
        movie.setTitle("Star Movie");
        movie.setYear(2017);
        movie.setDescription("About Stars");

        //Add the Movie to an empty list
        Set<Movie> movies = new HashSet<Movie>();
        movies.add(movie);

        movie = new Movie();
        movie.setTitle("DeathStar Ewoks");
        movie.setYear(2011);
        movie.setDescription("About Ewoks on deathStar");
        movies.add(movie);

        // add the list of movies to the director's movie list
        director.setMovies(movies);

        //save the director to the DB
        directorRepository.save(director);

        //grab all the directors from the DB and send them to the template
        model.addAttribute("directors", directorRepository.findAll());
        return "index";
    }
}
