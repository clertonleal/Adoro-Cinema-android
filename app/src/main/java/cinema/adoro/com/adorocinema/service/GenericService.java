package cinema.adoro.com.adorocinema.service;

import android.util.Log;

import java.util.Collection;
import java.util.List;

import cinema.adoro.com.adorocinema.dao.GenericDao;
import cinema.adoro.com.adorocinema.exception.GenericException;

/**
 * Created by clertonleal on 18/10/14.
 * Adoro-Cinema-android
 */
public abstract class GenericService <BaseType> {

    public long countOf() throws GenericException {
        return getDao().countOf();
    }

    public void create(BaseType t) throws GenericException{
        getDao().create(t);
    }

    public void createIfNotExists(BaseType t) throws GenericException{
        getDao().createIfNotExists(t);
    }

    public void createOrUpdate(BaseType t) throws GenericException{
        getDao().createOrUpdate(t);
    }

    public void createOrUpdate(final Collection<BaseType> ts) throws GenericException {
        getDao().createOrUpdate(ts);
    }

    public void delete(BaseType t) throws GenericException{
        getDao().delete(t);
    }

    public void delete(Collection<BaseType> ts) throws GenericException{
        getDao().delete(ts);
    }

    public void deleteById(Integer id) throws GenericException{
        getDao().deleteById(id);
    }

    public void deleteIds(Collection<Integer> ids) throws GenericException{
        getDao().deleteIds(ids);
    }

    public void idExists(Integer id) throws GenericException{
        getDao().idExists(id);
    }

    public List<BaseType> queryForAll() throws GenericException{
        return getDao().queryForAll();
    }

    public BaseType queryForId(Integer id) throws GenericException{
        return getDao().queryForId(id);
    }

    public void refresh(BaseType t) throws GenericException{
        getDao().refresh(t);
    }

    public void update(BaseType t) throws GenericException{
        getDao().update(t);
    }

    public List<BaseType> queryForEq(String fieldName, Object value) throws GenericException {
        return getDao().queryForEq(fieldName, value);
    }

    public void deleteAll() throws GenericException{
        getDao().deleteAll();
    }

    public BaseType queryForFirst() throws GenericException{
        return getDao().queryForFirst();
    }

    public BaseType queryForFirst(String... columns) throws GenericException{
        return getDao().queryForFirst(columns);
    }

    abstract protected GenericDao<BaseType> getDao();

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
