package core.basesyntax.service.impl;

import core.basesyntax.dao.MovieDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.lib.Service;
import core.basesyntax.model.Movie;
import core.basesyntax.service.MovieService;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Inject
    private MovieDao movieDao;

    @Override
    public Movie add(Movie movie) {
        return movieDao.add(movie);
    }

    @Override
    public Movie get(Long id) {
        return movieDao.get(id).get();
    }

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }
}
