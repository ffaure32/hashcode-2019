package com.zenika.kata.hashcode.model;

import java.util.Set;

public class Photo {
    public final Orientation orientation;
    public final Set<String> tags;

    public Photo(Orientation orientation, Set<String> tags) {
        this.orientation = orientation;
        this.tags = tags;
    }
}
