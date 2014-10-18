package cinema.adoro.com.adorocinema.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import android.view.View;

import butterknife.ButterKnife;
import cinema.adoro.com.adorocinema.application.ApplicationContext;

/**
 * Created by clertonleal on 18/10/14.
 * Adoro-Cinema-android
 */
public class GenericFragment extends Fragment {

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((ApplicationContext)getActivity().getApplication()).inject(this);
    }

    public void injectViews(View view){
        ButterKnife.inject(this, view);
    }

    protected void log(Exception e){
        Log.e(getTag(), "", e);
    }

    protected void log(Exception e, String message){
        Log.e(getTag(), message, e);
    }

}
