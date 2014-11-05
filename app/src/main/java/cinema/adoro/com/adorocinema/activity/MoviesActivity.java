package cinema.adoro.com.adorocinema.activity;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;

import java.util.List;

import javax.inject.Inject;

import cinema.adoro.com.adorocinema.R;
import cinema.adoro.com.adorocinema.domain.Cinema;
import cinema.adoro.com.adorocinema.domain.Movie;
import cinema.adoro.com.adorocinema.exception.GenericException;
import cinema.adoro.com.adorocinema.fragment.ListMoviesFragment;
import cinema.adoro.com.adorocinema.fragment.NavigationDrawerFragment;
import cinema.adoro.com.adorocinema.service.CinemaService;
import cinema.adoro.com.adorocinema.service.MovieService;
import cinema.adoro.com.adorocinema.util.ListCinemas;
import rx.android.observables.AndroidObservable;


public class MoviesActivity extends GenericActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks{

    @Inject
    MovieService movieService;

    @Inject
    CinemaService cinemaService;

    private NavigationDrawerFragment navigationDrawerFragment;
    private CharSequence title;
    private final ListMoviesFragment listMoviesFragment = new ListMoviesFragment();
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressDialog = ProgressDialog.show(this, getResources().getString(R.string.app_name), getResources().getString(R.string.setup_application), true, false);
        compositeSubscription.add(AndroidObservable.bindActivity(this, cinemaService.retrieveCinemas()).subscribe(
                cinemas -> initApplication(cinemas),
                e -> logError(e)
        ));
    }

    private void initApplication(List<Cinema> cinemas) {
        try {
            ListCinemas.setCinemas(cinemas, this);
            cinemaService.createOrUpdate(cinemas);
        } catch (GenericException e) {
            log(e);
        }

        navigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager().findFragmentById(R.id.navigation_drawer);
        navigationDrawerFragment.notifyDataSetChanged();
        title = getTitle();
        navigationDrawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout));
        createListFragment();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        compositeSubscription.add(AndroidObservable.bindActivity(this, movieService.retrieveAllMovies()).subscribe(
                movies -> showMovies(movies),
                e -> logError(e)
        ));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        title = ListCinemas.CINEMAS.get(position).getName();
        listMoviesFragment.showLoading();
        compositeSubscription.add(movieService.retrieveAllMovies().subscribe(
                movies -> showMovies(movies),
                e -> logError(e)
        ));
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(title);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (navigationDrawerFragment != null && !navigationDrawerFragment.isDrawerOpen()) {
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    private void createListFragment() {
        getFragmentManager().beginTransaction().add(R.id.container, listMoviesFragment).commit();
    }

    private void logError(Throwable e) {
        listMoviesFragment.showError();
        log(new GenericException(e), "");
    }

    private void showMovies(List<Movie> movies) {
        if(progressDialog.isShowing()){
            progressDialog.dismiss();
        }
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
