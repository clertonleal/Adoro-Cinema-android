package cinema.adoro.com.adorocinema.activity;

import android.os.Bundle;

import javax.inject.Inject;

import cinema.adoro.com.adorocinema.R;
import cinema.adoro.com.adorocinema.exception.GenericException;
import cinema.adoro.com.adorocinema.fragment.ListMoviesFragment;
import cinema.adoro.com.adorocinema.service.MovieService;


public class MoviesActivity extends GenericActivity {

    @Inject
    MovieService movieService;

    private final ListMoviesFragment listMoviesFragment = new ListMoviesFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            try {
                listMoviesFragment.setListMovies(movieService.queryForAll());
                getFragmentManager().beginTransaction().add(R.id.container, listMoviesFragment).commit();
            } catch (GenericException e) {
                log(e);
            }
        }
    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_movies);
    }
}
