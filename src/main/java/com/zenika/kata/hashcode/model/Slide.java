package com.zenika.kata.hashcode.model;

import java.util.HashSet;
import java.util.Set;

public class Slide {
    public final Photo photo1;
    public final Photo photo2;
    public final Set<String> tags;

    public Slide(Photo photo1, Photo photo2) {
        this.tags = new HashSet<>();
        this.photo1 = photo1;
        if(photo1 != null) {
            tags.addAll(photo1.tags);
        }
        this.photo2 = photo2;
        if(photo2 != null) {
            tags.addAll(photo2.tags);
        }
    }
}
