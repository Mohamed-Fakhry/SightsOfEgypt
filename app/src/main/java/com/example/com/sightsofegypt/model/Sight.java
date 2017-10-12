package com.example.com.sightsofegypt.model;


public class Sight {

    private int id;
    private String placeDescription;
    private SightImage image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaceDescription() {
        return placeDescription;
    }

    public void setPlaceDescription(String placeDescription) {
        this.placeDescription = placeDescription;
    }

    public SightImage getImage() {
        return image;
    }

    public void setImage(SightImage image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Sight{" +
                "id=" + id +
                ", placeDescription='" + placeDescription + '\'' +
                ", image=" + image +
                '}';
    }
}
