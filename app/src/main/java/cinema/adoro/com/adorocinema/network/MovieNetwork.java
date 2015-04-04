package cinema.adoro.com.adorocinema.network;

import java.util.List;

import cinema.adoro.com.adorocinema.domain.Movie;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by clertonleal on 18/10/14.
 * Adoro-Cinema-android
 */
public interface MovieNetwork {

    @GET("/movies.json")
    Observable<List<Movie>> retrieveAllMovies();

    @GET("/movies/byCinema/{id}")
    Observable<List<Movie>> retrieveMoviesByCinemaId(@Path("id") Integer id);

}
