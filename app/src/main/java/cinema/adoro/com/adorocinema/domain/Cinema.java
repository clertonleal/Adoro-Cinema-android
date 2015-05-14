package cinema.adoro.com.adorocinema.domain;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by clertonleal on 04/11/14.
 * Adoro-Cinema-android
 */
@DatabaseTable
public class Cinema {

    public Cinema(){}

    public Cinema(String name, Integer id){
        setName(name);
        setId(id);
    }

    @DatabaseField(id = true)
    private Integer id;

    @DatabaseField
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
