package cinema.adoro.com.adorocinema.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import cinema.adoro.com.adorocinema.R;
import cinema.adoro.com.adorocinema.activity.MovieDetailActivity;
import cinema.adoro.com.adorocinema.adapter.MovieAdapter;
import cinema.adoro.com.adorocinema.domain.Movie;
import cinema.adoro.com.adorocinema.util.BundleHelper;

/**
 * Created by clertonleal on 13/09/14.
 * Adoro Cinema
 */
public class ListMoviesFragment extends GenericFragment {

    private List<Movie> movies = new ArrayList<Movie>();
    private MovieAdapter movieAdapter;

    @InjectView(R.id.list_movies)
    ListView listMovies;

    public void setListMovies(List<Movie> movies){
        this.movies.clear();
        this.movies.addAll(movies);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        movieAdapter = new MovieAdapter(getActivity(), movies);
        final View rootView = inflater.inflate(R.layout.fragment_movies, container, false);
        prepareViews(rootView);
        return rootView;
    }

    private void prepareViews(View rootView) {
        injectViews(rootView);
        listMovies.setAdapter(movieAdapter);
        listMovies.setOnItemClickListener(
                (parent, view, position, id) -> {
            final Intent intent = new Intent(getActivity(), MovieDetailActivity.class);
            intent.putExtra(BundleHelper.MOVIE, movies.get(position));
            startActivity(intent);
        });
    }
}
