package com.gabez.smartcity_sightseeing_project;

import java.util.ArrayList;

public class MonumentsList {
    private ArrayList<Monument> _monuments = new ArrayList();
    private String placeholderURL = "https://upload.wikimedia.org/wikipedia/commons/thumb/7/71/Calico_tabby_cat_-_Savannah.jpg/220px-Calico_tabby_cat_-_Savannah.jpg";

    public MonumentsList() {
        _monuments.clear();
        _monuments.add(
                new Monument(
                        MonumentType.CASTLE,
                        "Wawel Castle",
                        "Empty content",
                        true,
                        false,
                        placeholderURL,
                        "The most famous castle",
                        11,
                        1

                )
        );

        _monuments.add(
                new Monument(
                        MonumentType.OTHER,
                        "Kazimierz",
                        "Empty content",
                        false,
                        true,
                        placeholderURL,
                        "Some city part",
                        1,
                        1

                )
        );

        _monuments.add(
                new Monument(
                        MonumentType.PARK,
                        "Dębniki Park",
                        "Empty content",
                        false,
                        false,
                        placeholderURL,
                        "Park near Wisla river",
                        10,
                        3

                )
        );
    }

    public ArrayList<Monument> get_monuments() {
        return _monuments;
    }

}
