package com.zenika.kata.hashcode.reader;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.zenika.kata.hashcode.InputLoader;
import com.zenika.kata.hashcode.model.Orientation;
import com.zenika.kata.hashcode.model.Photo;

public class Reader {

	public List<Photo> readInputs(String fileName) {
		List<String> input = InputLoader.loadInputList(fileName);
		
		List<Photo> photos = new ArrayList<Photo>();
		
		int countPhoto = Integer.parseInt(input.get(0));
		
		for (int i=1; i < countPhoto+1;i++) {
			
			String[] photoDesc = input.get(i).split(" ");
			
			Orientation o = Orientation.VERTICAL;
			if (photoDesc[0].equals("H")) {
				o = Orientation.HORIZONTAL;
			}
			
			Set<String> tags = new HashSet();
			for (int j=2;j<Integer.parseInt(photoDesc[1])+2; j++) {
				tags.add(photoDesc[j]);
			}
			photos.add(new Photo(i -1, o, tags));
		}
		return photos;
	}
	
	
}
