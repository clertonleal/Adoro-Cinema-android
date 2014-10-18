package cinema.adoro.com.adorocinema.dao;

import javax.inject.Inject;

import cinema.adoro.com.adorocinema.domain.Movie;

/**
 * Created by clertonleal on 18/10/14.
 * Adoro-Cinema-android
 */
public class MovieDao extends GenericDao<Movie> {

    @Inject
    public MovieDao() {
        super(Movie.class);
    }

}
