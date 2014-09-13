package cinema.adoro.com.adorocinema.activity;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.ImageView;
import android.widget.TextView;

import cinema.adoro.com.adorocinema.R;
import cinema.adoro.com.adorocinema.domain.Movie;
import cinema.adoro.com.adorocinema.util.BundleHelper;
import cinema.adoro.com.adorocinema.util.TextMerging;

/**
 * Created by clertonleal on 13/09/14.
 * Adoro Cinema
 */
public class MovieDetailActivity extends Activity {

    private Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        getMovieFromIntent();
        fillScreen();
    }

    private void getMovieFromIntent() {
        movie = (Movie) getIntent().getSerializableExtra(BundleHelper.MOVIE);
    }

    private void fillScreen() {
        final ImageView cover = (ImageView) findViewById(R.id.image_detail_movie);
        final TextView synopsis = (TextView) findViewById(R.id.text_synopsis);
        final TextView title = (TextView) findViewById(R.id.text_detail_title);
        title.setText(movie.getTitle());
        setSynopsis(synopsis);

    }

    private void setSynopsis(TextView synopsis) {
        final Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);
        int margin = point.x/2;
        final SpannableString spannableString = new SpannableString(movie.getSynopsis());
        spannableString.setSpan(new TextMerging(15, margin), 0, 0, 0);
        synopsis.setText(spannableString);
    }

}
