package cinema.adoro.com.adorocinema.service;

import javax.inject.Inject;

import cinema.adoro.com.adorocinema.dao.GenericDao;
import cinema.adoro.com.adorocinema.dao.MovieDao;
import cinema.adoro.com.adorocinema.domain.Movie;

/**
 * Created by clertonleal on 18/10/14.
 * Adoro-Cinema-android
 */
public class MovieService extends GenericService<Movie> {

    @Inject
    MovieDao movieDao;

    @Override
    protected GenericDao<Movie> getDao() {
        return movieDao;
    }
}
