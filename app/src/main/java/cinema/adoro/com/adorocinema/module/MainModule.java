package cinema.adoro.com.adorocinema.module;


import android.content.Context;
import android.location.LocationManager;

import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import cinema.adoro.com.adorocinema.activity.MovieDetailActivity;
import cinema.adoro.com.adorocinema.activity.MoviesActivity;
import cinema.adoro.com.adorocinema.application.ApplicationContext;
import cinema.adoro.com.adorocinema.database.DatabaseHelper;
import cinema.adoro.com.adorocinema.fragment.ListMoviesFragment;
import cinema.adoro.com.adorocinema.network.CinemaNetwork;
import cinema.adoro.com.adorocinema.network.MovieNetwork;
import cinema.adoro.com.adorocinema.util.ServerUrl;
import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by clertonleal on 16/10/14.
 * Adoro-Cinema-android
 */

@Module(
        library = true,
        injects = {
                MovieDetailActivity.class,
                MoviesActivity.class,
                ListMoviesFragment.class,
                ApplicationContext.class
        }
)
public class MainModule {

    private ApplicationContext applicationContext;

    public MainModule(ApplicationContext applicationContext){
        this.applicationContext = applicationContext;
    }

    @Provides
    @Singleton
    Context provideApplicationContext(){
        return applicationContext;
    }

    @Provides
    LocationManager provideLocationManager(){
        return (LocationManager) applicationContext.getSystemService(Context.LOCATION_SERVICE);
    }

    @Provides
    @Singleton
    DatabaseHelper provideDatabaseHelper(Context context){
        return new DatabaseHelper(context);
    }

    @Provides
    @Singleton
    RestAdapter provideRestAdapter(){
        return new RestAdapter.Builder().setEndpoint(ServerUrl.SERVER_URL).
                setConverter(new GsonConverter(new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create()))
                .build();
    }

    @Provides
    MovieNetwork provideMovieNetwork(RestAdapter restAdapter){
        return restAdapter.create(MovieNetwork.class);
    }

    @Provides
    CinemaNetwork provideCinemaNetwork(RestAdapter restAdapter){
        return restAdapter.create(CinemaNetwork.class);
    }

}
