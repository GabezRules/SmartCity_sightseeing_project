package com.gabez.smartcity_sightseeing_project;

public interface MonumentListCallback {

    void setFavourite(int monument);
    void setNotFavourite(int monument);

    void setSeen(int monument);
    void setNotSeen(int monument);

    void showMonument(Monument monument);
}
