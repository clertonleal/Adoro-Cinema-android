package cinema.adoro.com.adorocinema.activity;

import android.app.ActionBar;
import android.app.AlertDialog;
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
        showInitialProgressDialog();
    }

    private void showInitialProgressDialog() {
        if(progressDialog != null && progressDialog.isShowing()){
            progressDialog.dismiss();
        }

        progressDialog = ProgressDialog.show(this, getResources().getString(R.string.app_name), getResources().getString(R.string.setup_application), true, false);

        compositeSubscription.add(AndroidObservable.bindActivity(this, cinemaService.retrieveAllCinemas()).subscribe(
                cinemas -> saveCinemasAndCreateNavigation(cinemas),
                e -> showTryAgainDialog()
        ));
    }

    private void showTryAgainDialog() {
        new AlertDialog.Builder(this).
                setCancelable(false).
                setMessage(getResources().getString(R.string.no_internet_connection)).
                setTitle(getResources().getString(R.string.app_name)).
                setNegativeButton(getResources().getString(R.string.finish), (dialog, which) -> finish()).
                setPositiveButton(getResources().getString(R.string.try_again), (dialog, which) -> showInitialProgressDialog()).
                create().
                show();
    }

    private void saveCinemasAndCreateNavigation(List<Cinema> cinemas) {
        try {
            ListCinemas.setCinemas(cinemas, this);
            cinemaService.createOrUpdate(cinemas);
        } catch (GenericException e) {
            log(e);
        }

        createNavigationDrawer();
        createListFragment();
        compositeSubscription.add(AndroidObservable.bindActivity(this, movieService.retrieveAllMovies()).subscribe(
                movies -> showMovies(movies),
                e -> listMoviesFragment.showError()
        ));
    }

    private void createNavigationDrawer() {
        navigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager().findFragmentById(R.id.navigation_drawer);
        title = getTitle();
        navigationDrawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout));
        navigationDrawerFragment.notifyDataSetChanged();
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        final Cinema cinema = ListCinemas.CINEMAS.get(position);
        title = cinema.getName();
        listMoviesFragment.showLoading();
        compositeSubscription.add(AndroidObservable.bindActivity(this, movieService.retrieveMoviesByKey(cinema.getId())).subscribe(
                movies -> showMovies(movies),
                e -> listMoviesFragment.showError()
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
