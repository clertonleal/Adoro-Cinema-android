package cinema.adoro.com.adorocinema.network;

import java.util.List;

import cinema.adoro.com.adorocinema.domain.Movie;
import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by clertonleal on 18/10/14.
 * Adoro-Cinema-android
 */
public interface MovieNetwork {

    @GET("/movies.json")
    void allMovies(Callback<List<Movie>> movies);
}
