package com.zenika.kata.hashcode.model;

import java.util.ArrayList;
import java.util.List;

public class SlideShow {

    public final List<Slide> slides;

    public SlideShow() {
        this.slides = new ArrayList<>();
    }

    public SlideShow(List<Slide> slides) {
        this.slides = slides;
    }

    public void addSlide(Slide slide) {
        this.slides.add(slide);
    }
}
