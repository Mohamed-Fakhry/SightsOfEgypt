package com.example.com.sightsofegypt.data.model;


import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "image")
public class SightImage implements Parcelable {

    @Id(autoincrement = true)
    private Long id;
    @Property(nameInDb = "width")
    private int width;
    @Property(nameInDb = "height")
    private int height;
    @Property(nameInDb = "url")
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "SightImage{" +
                "width=" + width +
                ", height=" + height +
                ", url='" + url + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.width);
        dest.writeInt(this.height);
        dest.writeString(this.url);
    }

    public SightImage() {}

    protected SightImage(Parcel in) {
        this.width = in.readInt();
        this.height = in.readInt();
        this.url = in.readString();
    }

    @Generated(hash = 1579706248)
    public SightImage(Long id, int width, int height, String url) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.url = url;
    }

    public static final Parcelable.Creator<SightImage> CREATOR = new Parcelable.Creator<SightImage>() {
        @Override
        public SightImage createFromParcel(Parcel source) {
            return new SightImage(source);
        }

        @Override
        public SightImage[] newArray(int size) {
            return new SightImage[size];
        }
    };
}
