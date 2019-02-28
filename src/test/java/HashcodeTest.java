import java.util.List;

import com.zenika.kata.hashcode.InputLoader;
import com.zenika.kata.hashcode.model.SlideShow;
import org.junit.Test;

import com.zenika.kata.hashcode.model.Photo;
import com.zenika.kata.hashcode.reader.Calculator;
import com.zenika.kata.hashcode.reader.Reader;

public class HashcodeTest {

	@Test
	public void hashcodeInput1() {
		Reader reader = new Reader();
		List<Photo>photos = reader.readInputs("a_example.txt");

		SlideShow slideShow = new SlideShow();
		slideShow.addPhotos(photos);
		
		slideShow.slides = Calculator.sortSlides(slideShow.slides);

		InputLoader.writeSlideShow(slideShow, "slideshow1.txt");
	}

	
	@Test
	public void hashcodeInput2() {
		Reader reader = new Reader();
		List<Photo>photos = reader.readInputs("b_lovely_landscapes.txt");

		SlideShow slideShow = new SlideShow();
		slideShow.addPhotos(photos);

		slideShow.slides = Calculator.sortSlides(slideShow.slides);
		
		InputLoader.writeSlideShow(slideShow, "slideshow2.txt");
	}
	
	@Test
	public void hashcodeInput3() {
		Reader reader = new Reader();
		List<Photo>photos = reader.readInputs("c_memorable_moments.txt");

		SlideShow slideShow = new SlideShow();
		slideShow.addPhotos(photos);
		
		slideShow.slides = Calculator.sortSlides(slideShow.slides);

		InputLoader.writeSlideShow(slideShow, "slideshow3.txt");
	}
	
	@Test
	public void hashcodeInput4() {
		Reader reader = new Reader();
		List<Photo>photos = reader.readInputs("d_pet_pictures.txt");

		SlideShow slideShow = new SlideShow();
		slideShow.addPhotos(photos);
		
		slideShow.slides = Calculator.sortSlides(slideShow.slides);

		InputLoader.writeSlideShow(slideShow, "slideshow4.txt");
	}
	
	@Test
	public void hashcodeInput5() {
		Reader reader = new Reader();
		List<Photo>photos = reader.readInputs("e_shiny_selfies.txt");

		SlideShow slideShow = new SlideShow();
		slideShow.addPhotos(photos);
		
		slideShow.slides = Calculator.sortSlides(slideShow.slides);

		InputLoader.writeSlideShow(slideShow, "slideshow5.txt");
	}
}
