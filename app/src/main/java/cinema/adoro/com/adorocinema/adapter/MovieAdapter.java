package cinema.adoro.com.adorocinema.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cinema.adoro.com.adorocinema.R;
import cinema.adoro.com.adorocinema.domain.Movie;

/**
 * Created by clertonleal on 13/09/14.
 * Adoro Cinema
 */
public class MovieAdapter extends GenericBaseAdapter<Movie> {

    public MovieAdapter(Context context, List<Movie> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.movie_row, parent, false);
        }

        final ImageView cover = (ImageView) convertView.findViewById(R.id.image_movie_row);
        final TextView title = (TextView) convertView.findViewById(R.id.text_movie_title);
        final TextView description = (TextView) convertView.findViewById(R.id.text_movie_description);

        title.setText(getItem(position).getTitle());
        description.setText(getItem(position).getSynopsis());
        return convertView;
    }
}
