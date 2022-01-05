package core.basesyntax.service;

import core.basesyntax.model.Movie;
import java.util.List;

public interface MovieService {
    Movie add(Movie movie);

    Movie get(Long id);

    List<Movie> getAll();
}
