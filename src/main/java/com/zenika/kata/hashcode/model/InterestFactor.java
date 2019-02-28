package com.zenika.kata.hashcode.model;


import com.google.common.collect.Sets;
import org.graalvm.util.CollectionsUtil;

import java.util.Set;

public class InterestFactor {

    static public int computeInterestFactor(Slide slide1, Slide slide2){
        int nbTags1 = slide1.tags.size();
        int nbTags2 = slide2.tags.size();

        Set<String> Intersect = Sets.intersection(slide1.tags, slide2.tags);
        int nbTagsIntersect = Intersect.size();

        return Math.min(Math.min(nbTags1 - nbTagsIntersect, nbTags2 - nbTagsIntersect), nbTagsIntersect);
    }
}