package com.example.ownroadrider;

public class CardForDestination {
    private String destName;
    private String location;
    private Integer destImg;
    private Integer type;

    public CardForDestination(String destName, String location, Integer destImg, Integer type) {
        this.destName = destName;
        this.location = location;
        this.destImg = destImg;
        this.type = type;
    }

    public String getDestName() {
        return destName;
    }
    public void setDestName(String destName) {
        this.destName = destName;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getDestImg() {
        return destImg;
    }
    public void setDestImg(Integer destImg) {
        this.destImg = destImg;
    }

    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
}
