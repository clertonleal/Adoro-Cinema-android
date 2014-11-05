package cinema.adoro.com.adorocinema.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import javax.inject.Inject;

import cinema.adoro.com.adorocinema.domain.Cinema;
import cinema.adoro.com.adorocinema.domain.Movie;

/**
 * Created by clertonleal on 16/10/14.
 * Adoro-Cinema-android
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "adoro_cinema.db";
    private static final int DATABASE_VERSION = 1;

    @Inject
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Movie.class);
            TableUtils.createTable(connectionSource, Cinema.class);
        } catch (SQLException e) {
            throw new RuntimeException("Error to create database");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {}
}
