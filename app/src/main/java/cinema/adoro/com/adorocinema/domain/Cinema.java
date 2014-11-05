package cinema.adoro.com.adorocinema.domain;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by clertonleal on 04/11/14.
 * Adoro-Cinema-android
 */
@DatabaseTable
public class Cinema {

    @DatabaseField(id = true)
    private Integer id;

    @DatabaseField
    private String name;

    @DatabaseField
    private String key;

//    @DatabaseField
//    private Date openTime;
//
//    @DatabaseField
//    private Date closeTime;


//    public Date getCloseTime() {
//        return closeTime;
//    }
//
//    public void setCloseTime(Date closeTime) {
//        this.closeTime = closeTime;
//    }
//
//    public Date getOpenTime() {
//        return openTime;
//    }
//
//    public void setOpenTime(Date openTime) {
//        this.openTime = openTime;
//    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

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
