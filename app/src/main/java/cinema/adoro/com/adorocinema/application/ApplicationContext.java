package cinema.adoro.com.adorocinema.application;

import android.app.Application;
import android.util.Log;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import cinema.adoro.com.adorocinema.dao.MovieDao;
import cinema.adoro.com.adorocinema.exception.GenericException;
import cinema.adoro.com.adorocinema.module.MainModule;
import cinema.adoro.com.adorocinema.util.FactorMovies;
import dagger.ObjectGraph;

/**
 * Created by clertonleal on 18/10/14.
 * Adoro-Cinema-android
 */
public class ApplicationContext extends Application {

    @Inject
    MovieDao movieDao;

    private ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        objectGraph = ObjectGraph.create(getModules().toArray());
        inject(this);
        try {
            movieDao.deleteAll();
            movieDao.createOrUpdate(FactorMovies.getMovies());
        } catch (GenericException e) {
            Log.e("Application","Fudeu", e);
        }
    }

    public void inject(Object o){
        objectGraph.inject(o);
    }

    private List getModules(){
        return Arrays.asList(new MainModule(this));
    }
}
