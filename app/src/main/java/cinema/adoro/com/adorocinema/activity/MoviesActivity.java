package cinema.adoro.com.adorocinema.activity;

import android.os.Bundle;

import java.util.List;

import javax.inject.Inject;

import cinema.adoro.com.adorocinema.R;
import cinema.adoro.com.adorocinema.domain.Movie;
import cinema.adoro.com.adorocinema.exception.GenericException;
import cinema.adoro.com.adorocinema.fragment.ListMoviesFragment;
import cinema.adoro.com.adorocinema.service.MovieService;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MoviesActivity extends GenericActivity {

    @Inject
    MovieService movieService;

    private final ListMoviesFragment listMoviesFragment = new ListMoviesFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            movieService.retrieveMovies(listCallback);
        }
    }

    Callback<List<Movie>> listCallback = new Callback<List<Movie>>() {
        @Override
        public void success(List<Movie> movies, Response response) {
            listMoviesFragment.setListMovies(movies);
            getFragmentManager().beginTransaction().add(R.id.container, listMoviesFragment).commit();
        }

        @Override
        public void failure(RetrofitError error) {
            log(new GenericException(""), "");
        }
    };

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_movies);
    }
}
