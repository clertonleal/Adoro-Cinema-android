package cinema.adoro.com.adorocinema.util;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import cinema.adoro.com.adorocinema.R;
import cinema.adoro.com.adorocinema.domain.Cinema;

/**
 * Created by clertonleal on 04/11/14.
 * Adoro-Cinema-android
 */
public class ListCinemas {

    public static void setCinemas(List<Cinema> cinemas, Context context){
        CINEMAS.clear();
        CINEMAS.add(new Cinema(context.getResources().getString(R.string.app_name), -1));
        CINEMAS.addAll(cinemas);

        CINEMA_NAMES.clear();
        final List<String> names = new ArrayList<>();
        names.add(context.getResources().getString(R.string.all));
        for(Cinema cinema : cinemas){
            names.add(cinema.getName());
        }
        CINEMA_NAMES.addAll(names);
    }



    public static List<Cinema> CINEMAS = new ArrayList<>();
    public static List<String> CINEMA_NAMES = new ArrayList<>();

}
