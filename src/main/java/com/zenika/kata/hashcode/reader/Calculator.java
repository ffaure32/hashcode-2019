package com.zenika.kata.hashcode.reader;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomUtils;

import com.zenika.kata.hashcode.model.InterestFactor;
import com.zenika.kata.hashcode.model.Slide;

public class Calculator {
	
	
	public static List<Slide> sortSlides(List<Slide> slides) {
		slides = sortOnce(slides);
		slides = sortOnce(slides);
		slides = sortOnce(slides);
		return sortOnce(slides);
	}
	
	
	public static List<Slide> sortOnce(List<Slide> slides) {
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

	
	
	public static List<Slide> sortRandom(List<Slide> slides) {
		LinkedList<Slide> linkedSlides = new LinkedList<>();
		int elementToTry = 3;
		
		linkedSlides.add(slides.get(0));
		slides.remove(0);
		
		for (Slide slide : slides) {
			int scoreStart = InterestFactor.computeInterestFactor(slide, linkedSlides.getFirst());
			int scoreEnd = InterestFactor.computeInterestFactor(slide, linkedSlides.getLast());
			
			if (linkedSlides.size() <= elementToTry) {
				if (scoreStart < scoreEnd) {
					linkedSlides.addLast(slide);
				} else {
					linkedSlides.addFirst(slide);
				}
			} else {
				int rand = RandomUtils.nextInt(0, linkedSlides.size() - 1);

				
			}
		}
		return linkedSlides;
	}
	
}
