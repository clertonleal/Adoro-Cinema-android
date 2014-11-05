package cinema.adoro.com.adorocinema.network;

import java.util.List;

import cinema.adoro.com.adorocinema.domain.Cinema;
import retrofit.http.GET;
import rx.Observable;

/**
 * Created by clertonleal on 04/11/14.
 * Adoro-Cinema-android
 */
public interface CinemaNetwork {

    @GET("/cinemas.json")
    Observable<List<Cinema>> retrieveCinemas();

}
