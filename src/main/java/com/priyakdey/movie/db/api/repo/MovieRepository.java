package com.priyakdey.movie.db.api.repo;

import com.priyakdey.movie.db.api.entity.Movie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class MovieRepository {

    private List<Movie> movies;

    public MovieRepository() {
        movies = seed();
    }

    private List<Movie> seed() {
        log.info("Initializing the database...");
        movies = new ArrayList<>();
        movies.add(newMovie(movies.size() + 1, "Batman Begins", "Driven by tragedy, billionaire Bruce Wayne dedicates his life to uncovering and defeating the corruption that plagues his home, Gotham City. Unable to work within the system, he instead creates a new identity, a symbol of fear for the criminal underworld - The Batman."));
        movies.add(newMovie(movies.size() + 1, "Batman Returns", "While Batman deals with a deformed man calling himself the Penguin, an employee of a corrupt businessman transforms into the Catwoman."));
        movies.add(newMovie(movies.size() + 1, "A Quiet Place", "A family is forced to live in silence while hiding from creatures that hunt by sound."));
        movies.add(newMovie(movies.size() + 1, "Annihilation", "A biologist signs up for a dangerous, secret expedition into a mysterious zone where the laws of nature don't apply."));
        movies.add(newMovie(movies.size() + 1, "Birds of Prey (and the Fantabulous Emancipation of One Harley Quinn)", "Harley Quinn joins forces with a singer, an assassin and a police detective to help a young girl who had a hit placed on her after she stole a rare diamond from a crime lord"));
        movies.add(newMovie(movies.size() + 1, "Judas and the Black Messiah", "Bill O'Neal infiltrates the Black Panthers per FBI Agent Mitchell and J. Edgar Hoover. As Black Panther Chairman Fred Hampton ascends, falling for a fellow revolutionary en route, a battle wages for O’Neal’s soul"));
        return movies;
    }

    private Movie newMovie(Integer id, String title, String overview) {
        return Movie
                .builder()
                .id(id)
                .title(title)
                .overview(overview)
                .build();
    }

    public List<Movie> movies(Integer size, Integer page) {
        return movies
                .stream()
                .skip(page * size)
                .limit(size)
                .collect(Collectors.toList());
    }
}
