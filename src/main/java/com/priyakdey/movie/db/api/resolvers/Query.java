package com.priyakdey.movie.db.api.resolvers;

import com.priyakdey.movie.db.api.entity.Movie;
import com.priyakdey.movie.db.api.repo.MovieRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;

import java.util.List;

public class Query implements GraphQLQueryResolver {

    private final MovieRepository movieRepository;

    public Query(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> movies(Integer size, Integer page) {
        size = size != null ? size : 10;
        page = page != null ? page : 0;
        return movieRepository.movies(size, page);
    }

}
