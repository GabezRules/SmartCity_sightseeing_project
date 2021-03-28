package com.gabez.smartcity_sightseeing_project;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MonumentListViewModel extends ViewModel {
    ArrayList<Monument> allMonuments = (ArrayList<Monument>) new MonumentsList().get_monuments().clone();

    public ArrayList<Monument> getAllMonuments(){
        return allMonuments;
    }

    public void setFavourite(int monument) {
        allMonuments.get(monument).set_isFavourite(true);
        allMonuments.get(monument).set_favouriteCount(
                allMonuments.get(monument).get_favouriteCount() + 1
        );
    }

    public void setNotFavourite(int monument) {
        allMonuments.get(monument).set_isFavourite(false);
        allMonuments.get(monument).set_favouriteCount(
                allMonuments.get(monument).get_favouriteCount() - 1
        );
    }

    public void setSeen(int monument) {
        allMonuments.get(monument).set_seen(true);
        allMonuments.get(monument).set_seenBy(
                allMonuments.get(monument).get_seenBy() + 1
        );

    }

    public void setNotSeen(int monument) {
        allMonuments.get(monument).set_seen(false);
        allMonuments.get(monument).set_seenBy(
                allMonuments.get(monument).get_seenBy() - 1
        );
    }

}
