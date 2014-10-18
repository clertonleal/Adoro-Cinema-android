package cinema.adoro.com.adorocinema.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import butterknife.ButterKnife;
import cinema.adoro.com.adorocinema.application.ApplicationContext;

/**
 * Created by clertonleal on 18/10/14.
 * Adoro-Cinema-android
 */
public abstract class GenericActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((ApplicationContext)getApplication()).inject(this);
        setContentView();
        ButterKnife.inject(this);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setOnClickListeners();
    }

    protected void log(Exception e){
        Log.e(getTag(), "", e);
    }

    protected void log(Exception e, String message){
        Log.e(getTag(), message, e);
    }

    private String getTag(){
        return this.getClass().getName();
    }

    protected void setOnClickListeners(){}

    abstract protected void setContentView();
}
