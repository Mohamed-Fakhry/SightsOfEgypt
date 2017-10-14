package com.example.com.sightsofegypt.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToOne;

@Entity(nameInDb = "sight")
public class Sight implements Parcelable {

    @Id()
    private Long id;
    @Property(nameInDb = "place_description")
    private String placeDescription;
    @Property(nameInDb = "price")
    private double price;
    @Property(nameInDb = "type")
    private String type = "explore";
    @Property(nameInDb = "url")
    private String url;
    @ToOne(joinProperty = "id")
    private SightImage image;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setPlaceDescription(String placeDescription) {
        this.placeDescription = placeDescription;
    }

    public String getPlaceDescription() {
        return placeDescription;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Sight{" +
                "id=" + id +
                ", placeDescription='" + placeDescription + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.placeDescription);
        dest.writeDouble(this.price);
        dest.writeParcelable(this.image, flags);
    }


    public String getImageUrl() {
        if (image != null)
            return image.getUrl();
        else
            return url;
    }

    /**
     * To-one relationship, resolved on first access.
     */
    @Generated(hash = 1183454334)
    public SightImage getImage() {
        Long __key = this.id;
        if (image__resolvedKey == null || !image__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            SightImageDao targetDao = daoSession.getSightImageDao();
            SightImage imageNew = targetDao.load(__key);
            synchronized (this) {
                image = imageNew;
                image__resolvedKey = __key;
            }
        }
        return image;
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 1141837586)
    public void setImage(SightImage image) {
        synchronized (this) {
            this.image = image;
            id = image == null ? null : image.getId();
            image__resolvedKey = id;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 192222504)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getSightDao() : null;
    }

    public Sight() {
    }

    protected Sight(Parcel in) {
        this.id = in.readLong();
        this.placeDescription = in.readString();
        this.price = in.readDouble();
        this.image = in.readParcelable(SightImage.class.getClassLoader());
    }

    @Generated(hash = 1794506998)
    public Sight(Long id, String placeDescription, double price, String type, String url) {
        this.id = id;
        this.placeDescription = placeDescription;
        this.price = price;
        this.type = type;
        this.url = url;
    }

    public static final Parcelable.Creator<Sight> CREATOR = new Parcelable.Creator<Sight>() {
        @Override
        public Sight createFromParcel(Parcel source) {
            return new Sight(source);
        }

        @Override
        public Sight[] newArray(int size) {
            return new Sight[size];
        }
    };
    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /**
     * Used for active entity operations.
     */
    @Generated(hash = 1793964851)
    private transient SightDao myDao;
    @Generated(hash = 1517498479)
    private transient Long image__resolvedKey;
}
