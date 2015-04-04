package cinema.adoro.com.adorocinema.service;

import java.util.List;

import javax.inject.Inject;

import cinema.adoro.com.adorocinema.dao.GenericDao;
import cinema.adoro.com.adorocinema.dao.MovieDao;
import cinema.adoro.com.adorocinema.domain.Movie;
import cinema.adoro.com.adorocinema.network.MovieNetwork;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by clertonleal on 18/10/14.
 * Adoro-Cinema-android
 */
public class MovieService extends GenericService<Movie> {

    @Inject
    MovieDao movieDao;

    @Inject
    MovieNetwork movieNetwork;

    @Override
    protected GenericDao<Movie> getDao() {
        return movieDao;
    }

    public Observable<List<Movie>> retrieveAllMovies(){
        return movieNetwork.retrieveAllMovies().observeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<List<Movie>> retrieveMoviesByKey(Integer id){
        return movieNetwork.retrieveMoviesByCinemaId(id).observeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
