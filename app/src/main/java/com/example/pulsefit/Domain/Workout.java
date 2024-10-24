package com.example.pulsefit.Domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Workout implements Serializable {
    private String title;
    private String description;
    private String picPath;
    private int kcal;
    private String duration;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public ArrayList<Lession> getLessions() {
        return lessions;
    }

    public void setLessions(ArrayList<Lession> lessions) {
        this.lessions = lessions;
    }

    public Workout(String title, String description, String picPath, int kcal, String duration, ArrayList<Lession> lessions) {
        this.title = title;
        this.description = description;
        this.picPath = picPath;
        this.kcal = kcal;
        this.duration = duration;
        this.lessions = lessions;
    }

    private ArrayList<Lession> lessions;
}
