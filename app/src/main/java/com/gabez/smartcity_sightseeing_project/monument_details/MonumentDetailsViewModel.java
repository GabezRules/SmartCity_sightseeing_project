package com.gabez.smartcity_sightseeing_project.monument_details;

import androidx.lifecycle.ViewModel;

import com.gabez.smartcity_sightseeing_project.Monument;

public class MonumentDetailsViewModel extends ViewModel {
    private Monument _monument;

    public void set_monument(Monument monument){
        _monument = monument;
    }

    public Monument get_monument(){
        return _monument;
    }
}
