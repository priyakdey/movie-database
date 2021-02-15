package com.priyakdey.movie.db.api.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Movie {

    private Integer id;
    private String title;
    private String overview;

}
