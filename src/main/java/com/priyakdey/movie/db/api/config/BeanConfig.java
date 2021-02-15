package com.priyakdey.movie.db.api.config;

import com.priyakdey.movie.db.api.repo.MovieRepository;
import com.priyakdey.movie.db.api.resolvers.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class BeanConfig {

    private final MovieRepository movieRepository;

    public BeanConfig(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Bean
    public Query query() {
        log.info("Initializing Query Bean..");
        return new Query(movieRepository);
    }

}
