package com.zenika.kata.hashcode.model;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class SlideGroup {

    public List<Slide> slides = new ArrayList<>();

    public SlideGroup() {
    }

    public SlideGroup(Slide slide) {
        slides.add(slide);
    }

    public Slide first() {
        return slides.stream()
            .reduce((s1, s2) -> s1)
            .orElse(null);
    }

    public Slide last() {
        return slides.stream()
            .reduce((s1, s2) -> s2)
            .orElse(null);
    }

    public void reverse() {
        slides = Lists.reverse(slides);
    }

    public void merge(SlideGroup other, boolean reverse1, boolean reverse2) {
        if (reverse1) {
            reverse();
        }

        if (reverse2) {
            other.reverse();
        }

        slides.addAll(other.slides);
    }
}
