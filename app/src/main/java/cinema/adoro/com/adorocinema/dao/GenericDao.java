package cinema.adoro.com.adorocinema.dao;

import android.util.Log;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import cinema.adoro.com.adorocinema.database.DatabaseHelper;
import cinema.adoro.com.adorocinema.exception.GenericException;

/**
 * Created by clertonleal on 18/10/14.
 * Adoro-Cinema-android
 */
public abstract class GenericDao <T> {

    @Inject
    DatabaseHelper databaseHelper;

    private final Class<T> clazz;

    public GenericDao(Class<T> tClass){
        this.clazz = tClass;
    }

    public long countOf() throws GenericException {
        try {
            return getDao().countOf();
        } catch (SQLException e) {
            throw new GenericException(e);
        }
    }

    public void create(T t) throws GenericException {
        try {
            getDao().create(t);
        } catch (SQLException e) {
            throw new GenericException(e);
        }
    }

    public long queryRawValue(String sql) throws GenericException {
        try {
            return getDao().queryRawValue(sql);
        } catch (SQLException e) {
            throw new GenericException(e);
        }
    }

    public void createIfNotExists(T t) throws GenericException {
        try {
            getDao().createIfNotExists(t);
        } catch (SQLException e) {
            throw new GenericException(e);
        }
    }

    public void createOrUpdate(T t) throws GenericException {
        try {
            getDao().createOrUpdate(t);
        } catch (SQLException e) {
            throw new GenericException(e);
        }
    }

    public void createOrUpdate(final Collection<T> ts) throws GenericException {
        if (ts == null || ts.isEmpty()) {
            return;
        }

        try {
            getDao().callBatchTasks(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    for (T t : ts) {
                        createOrUpdate(t);
                    }
                    return null;
                }
            });
        } catch (Exception e) {
            throw new GenericException(e);
        }
    }

    public void createOrUpdate(final T[] ts) throws GenericException {
        if (ts == null || ts.length == 0) {
            return;
        }

        try {
            getDao().callBatchTasks(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    for (T t : ts) {
                        createOrUpdate(t);
                    }
                    return null;
                }
            });
        } catch (Exception e) {
            throw new GenericException(e);
        }
    }

    public void delete(T t) throws GenericException {
        try {
            getDao().delete(t);
        } catch (SQLException e) {
            throw new GenericException(e);
        }
    }

    public void delete(Collection<T> ts) throws GenericException {
        try {
            getDao().delete(ts);
        } catch (SQLException e) {
            throw new GenericException(e);
        }
    }

    protected DeleteBuilder<T, Integer> deleteBuilder() throws GenericException {
        return getDao().deleteBuilder();
    }

    protected <K> DeleteBuilder<K, Integer> deleteBuilder(Class<K> aClass) throws GenericException {
        return getDao(aClass).deleteBuilder();
    }

    public void deleteById(Integer id) throws GenericException {
        try {
            getDao().deleteById(id);
        } catch (SQLException e) {
            throw new GenericException(e);
        }
    }

    public void deleteIds(Collection<Integer> ids) throws GenericException {
        try {
            getDao().deleteIds(ids);
        } catch (SQLException e) {
            throw new GenericException(e);
        }
    }

    public boolean idExists(Integer id) throws GenericException {
        try {
            return getDao().idExists(id);
        } catch (SQLException e) {
            throw new GenericException(e);
        }
    }

    protected QueryBuilder<T, Integer> queryBuilder() throws GenericException {
        return getDao().queryBuilder();
    }

    protected <K> QueryBuilder<K, Integer> queryBuilder(Class<K> aClass) throws GenericException {
        return getDao(aClass).queryBuilder();
    }

    public List<T> queryForAll() throws GenericException {
        try {
            return getDao().queryForAll();
        } catch (SQLException e) {
            throw new GenericException(e);
        }
    }

    public T queryForId(Integer id) throws GenericException {
        try {
            return getDao().queryForId(id);
        } catch (SQLException e) {
            throw new GenericException(e);
        }
    }

    public void refresh(T t) throws GenericException {
        try {
            getDao().refresh(t);
        } catch (SQLException e) {
            throw new GenericException(e);
        }
    }

    public void update(T t) throws GenericException {
        try {
            getDao().update(t);
        } catch (SQLException e) {
            throw new GenericException(e);
        }
    }

    public void updateRaw(String sql) throws GenericException {
        try {
            getDao().updateRaw(sql);
        } catch (SQLException e) {
            throw new GenericException(e);
        }
    }

    public List<T> queryForEq(String fieldName, Object value) throws GenericException {
        try {
            return getDao().queryForEq(fieldName, value);
        } catch (SQLException e) {
            throw new GenericException(e);
        }
    }

    public void deleteAll() throws GenericException {
        try {
            deleteBuilder().delete();
        } catch (SQLException e) {
            throw new GenericException(e);
        }
    }

    public T queryForFirst() throws GenericException {
        try {
            return queryBuilder().queryForFirst();
        } catch (SQLException e) {
            throw new GenericException(e);
        }
    }

    public T queryForFirst(String... columns) throws GenericException {
        try {
            return queryBuilder().selectColumns(columns).queryForFirst();
        } catch (SQLException e) {
            throw new GenericException(e);
        }
    }

    protected UpdateBuilder<T, Integer> updateBuilder() throws GenericException {
        return getDao().updateBuilder();
    }

    protected <K> UpdateBuilder<K, Integer> updateBuilder(Class<K> aClass) throws GenericException {
        return getDao(aClass).updateBuilder();
    }

    protected Dao<T, Integer> getDao() throws GenericException {
        try {
            return databaseHelper.getDao(clazz);
        } catch (SQLException e) {
            throw new GenericException(e);
        }
    }

    protected <K>Dao<K, Integer> getDao(Class<K> aClass) throws GenericException {
        try {
            return databaseHelper.getDao(aClass);
        } catch (SQLException e) {
            throw new GenericException(e);
        }
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
    
}
