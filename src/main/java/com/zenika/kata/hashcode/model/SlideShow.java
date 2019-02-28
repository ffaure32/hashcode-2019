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

    public void addPhotos(List<Photo> photos) {
        Slide currentVerticalSlide = null;
        for (Photo photo : photos) {
            if(photo.orientation == Orientation.HORIZONTAL) {
                addSlide(new Slide(photo));
            } else {
                if(currentVerticalSlide == null) {
                    currentVerticalSlide = new Slide(photo);
                    addSlide(currentVerticalSlide);
                } else {
                    currentVerticalSlide.addPhoto2(photo);
                    currentVerticalSlide = null;
                }
            }
        }
    }
    public void addSlide(Slide slide) {
        this.slides.add(slide);
    }
}
