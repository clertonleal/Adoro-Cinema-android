package cinema.adoro.com.adorocinema.activity;

import android.app.Activity;
import android.os.Bundle;

import cinema.adoro.com.adorocinema.R;
import cinema.adoro.com.adorocinema.fragment.ListMoviesFragment;
import cinema.adoro.com.adorocinema.util.FactorMovies;


public class MoviesActivity extends Activity {

    private final ListMoviesFragment listMoviesFragment = new ListMoviesFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        if (savedInstanceState == null) {
            listMoviesFragment.setListMovies(FactorMovies.getMovies());
            getFragmentManager().beginTransaction().add(R.id.container, listMoviesFragment).commit();
        }
    }
}
