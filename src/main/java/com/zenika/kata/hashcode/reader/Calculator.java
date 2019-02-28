package com.zenika.kata.hashcode.reader;

import java.util.LinkedList;
import java.util.List;

import com.zenika.kata.hashcode.model.InterestFactor;
import com.zenika.kata.hashcode.model.Slide;

public class Calculator {
	
	
	public static List<Slide> sortSlides(List<Slide> slides) {
		LinkedList<Slide> linkedSlides = new LinkedList<>();
		
		linkedSlides.add(slides.get(0));
		
		slides.remove(0);
		
		for (Slide slide : slides) {
			if (InterestFactor.computeInterestFactor(slide, linkedSlides.getFirst()) > InterestFactor.computeInterestFactor(slide, linkedSlides.getLast())) {
				linkedSlides.addFirst(slide);
			} else {
				linkedSlides.addLast(slide);
			}
		}
		
		return linkedSlides;
	}

}
