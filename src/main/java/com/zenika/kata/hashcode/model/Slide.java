package com.zenika.kata.hashcode.model;

import java.util.HashSet;
import java.util.Set;

public class Slide {
    public Photo photo1;
    public Photo photo2;
    public final Set<String> tags;

    public Slide(Photo photo1) {
        this.tags = new HashSet<>();
        this.photo1 = photo1;
        if(photo1 != null) {
            tags.addAll(photo1.tags);
        }
    }

    public void addPhoto2(Photo photo) {
        this.photo2 = photo;
        if(photo2 != null) {
            tags.addAll(photo2.tags);
        }
    }

    @Override
    public String toString() {
        String string = photo1.id.toString();

        if (null != photo2) {
            string += " " + photo2.id;
        }

        return string;
    }
}
