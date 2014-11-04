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
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class MoviesActivity extends GenericActivity {

    @Inject
    MovieService movieService;

    private final ListMoviesFragment listMoviesFragment = new ListMoviesFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createListFragment();
        compositeSubscription.add(movieService.retrieveMovies().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(
                movies -> showMovies(movies),
                e -> logError(e)
        ));
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        listMoviesFragment.showLoading();
    }

    private void createListFragment() {
        getFragmentManager().beginTransaction().add(R.id.container, listMoviesFragment).commit();
    }

    private void logError(Throwable e) {
        listMoviesFragment.showError();
        log(new GenericException(e), "");
    }

    private void showMovies(List<Movie> movies) {
        if(movies.isEmpty()){
            listMoviesFragment.showEmpty();
        } else {
            listMoviesFragment.setListMovies(movies);
        }

    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_movies);
    }
}
