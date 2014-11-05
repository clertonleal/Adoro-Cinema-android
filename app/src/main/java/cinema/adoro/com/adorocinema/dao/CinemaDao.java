package cinema.adoro.com.adorocinema.dao;

import javax.inject.Inject;

import cinema.adoro.com.adorocinema.domain.Cinema;

/**
 * Created by clertonleal on 04/11/14.
 * Adoro-Cinema-android
 */
public class CinemaDao extends GenericDao<Cinema> {

    @Inject
    public CinemaDao() {
        super(Cinema.class);
    }
}
