package com.zenika.kata.hashcode.model;

import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;

public class InterestFactor {

    static public int computeInterestFactor(Slide slide1, Slide slide2){
        int nbTags1 = slide1.tags.size();
        int nbTags2 = slide2.tags.size();

        Set<String> Intersect = Sets.intersection(slide1.tags, slide2.tags);
        int nbTagsIntersect = Intersect.size();

        return Math.min(Math.min(nbTags1 - nbTagsIntersect, nbTags2 - nbTagsIntersect), nbTagsIntersect);
    }
    
    static public int computeFullScore(List<Slide> slides) {
    	int score = 0;
    	for (int i=0; i< slides.size() -1; i++) {
    		score += computeInterestFactor(slides.get(i), slides.get(i+1));
    	}
    	return score;
    }
}