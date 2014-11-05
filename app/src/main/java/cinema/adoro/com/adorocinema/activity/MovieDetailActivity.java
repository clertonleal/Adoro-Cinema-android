package cinema.adoro.com.adorocinema.activity;

import android.graphics.Point;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.InjectView;
import cinema.adoro.com.adorocinema.R;
import cinema.adoro.com.adorocinema.domain.Movie;
import cinema.adoro.com.adorocinema.util.BundleHelper;
import cinema.adoro.com.adorocinema.util.ServerUrl;
import cinema.adoro.com.adorocinema.util.TextMerging;

/**
 * Created by clertonleal on 13/09/14.
 * Adoro Cinema
 */
public class MovieDetailActivity extends GenericActivity {

    @InjectView(R.id.image_detail_movie)
    ImageView cover;

    @InjectView(R.id.text_synopsis)
    TextView synopsis;

    @InjectView(R.id.text_detail_title)
    TextView title;

    private Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMovieFromIntent();
        fillScreen();
    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_movie_detail);
    }

    private void getMovieFromIntent() {
        movie = (Movie) getIntent().getSerializableExtra(BundleHelper.MOVIE);
    }

    private void fillScreen() {
        title.setText(movie.getTitle());
        Picasso.with(this).load(ServerUrl.SERVER_URL + movie.getCoverUrl()).placeholder(R.drawable.movie_placeholder).into(cover);
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
