package cinema.adoro.com.adorocinema.service;

import java.util.List;

import javax.inject.Inject;

import cinema.adoro.com.adorocinema.dao.CinemaDao;
import cinema.adoro.com.adorocinema.dao.GenericDao;
import cinema.adoro.com.adorocinema.domain.Cinema;
import cinema.adoro.com.adorocinema.network.CinemaNetwork;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by clertonleal on 04/11/14.
 * Adoro-Cinema-android
 */
public class CinemaService extends GenericService<Cinema> {

    @Inject
    CinemaDao cinemaDao;

    @Inject
    CinemaNetwork cinemaNetwork;

    @Override
    protected GenericDao<Cinema> getDao() {
        return cinemaDao;
    }

    public Observable<List<Cinema>> retrieveCinemas(){
        return cinemaNetwork.retrieveCinemas().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
