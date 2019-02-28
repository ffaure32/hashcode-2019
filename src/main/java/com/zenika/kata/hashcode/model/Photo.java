package com.zenika.kata.hashcode.model;

import java.util.Set;

public class Photo {

    public final Integer id;
    public final Orientation orientation;
    public final Set<String> tags;

    public Photo(Integer id, Orientation orientation, Set<String> tags) {
        this.id = id;
        this.orientation = orientation;
        this.tags = tags;
    }
}
