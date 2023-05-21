package com.example.ownroadrider;

import android.graphics.drawable.Drawable;

public class CardForSchedule {
    private String scheduleTitle;
    private String course;
    private Integer dest1Img;
    private Integer dest2Img;
    private Integer dest3Img;
    private Integer rating;
    private String totalreview;

    public CardForSchedule(String scheduleTitle, String course, Integer dest1Img, Integer dest2Img, Integer dest3Img, Integer rating, String totalreview) {
        this.scheduleTitle = scheduleTitle;
        this.course = course;
        this.dest1Img = dest1Img;
        this.dest2Img = dest2Img;
        this.dest3Img = dest3Img;
        this.rating = rating;
        this.totalreview = totalreview;
    }

    public String getScheduleTitle() {
        return scheduleTitle;
    }
    public void setscheduleTitle(String scheduleTitle) {
        this.scheduleTitle = scheduleTitle;
    }

    public String getCourse() {
        return course;
    }
    public void setCourse(String course) {
        this.course = course;
    }

    public Integer getDest1Img() {
        return dest1Img;
    }
    public void setDest1Img(Integer dest1Img) {
        this.dest1Img = dest1Img;
    }

    public Integer getDest2Img() {
        return dest2Img;
    }
    public void setDest2Img(Integer dest2Img) {
        this.dest2Img = dest2Img;
    }

    public Integer getDest3Img() {
        return dest3Img;
    }
    public void setDest3Img(Integer dest3Img) {
        this.dest3Img = dest3Img;
    }

    public Integer getRating() {
        return rating;
    }
    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getTotalreview() {
        return totalreview;
    }
    public void setTotalreview(String totalreview) {
        this.totalreview = totalreview;
    }
}
