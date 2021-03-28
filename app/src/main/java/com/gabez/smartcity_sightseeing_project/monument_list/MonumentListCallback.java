package com.gabez.smartcity_sightseeing_project.monument_list;

import com.gabez.smartcity_sightseeing_project.Monument;

public interface MonumentListCallback {

    void setFavourite(int monument);
    void setNotFavourite(int monument);

    void setSeen(int monument);
    void setNotSeen(int monument);

    void showMonument(Monument monument);
}
