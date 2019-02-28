import java.util.List;
import java.util.stream.Collectors;

import com.zenika.kata.hashcode.InputLoader;
import com.zenika.kata.hashcode.model.*;
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

    @Test
    public void hashcodeInput22() {
	    tata("a_example.txt", "a.txt");
	    tata("b_lovely_landscapes.txt", "b.txt");
	    tata("c_memorable_moments.txt", "c.txt");
	    tata("d_pet_pictures.txt", "d.txt");
	    tata("e_shiny_selfies.txt", "e.txt");
    }

    private void tata(String inputFile, String outputFile) {

        Reader reader = new Reader();
        List<Photo> photos = reader.readInputs(inputFile);

        SlideShow slideShow = new SlideShow();
        slideShow.addPhotos(photos);


        List<Slide> slides = slideShow.slides;
        List<SlideGroup> slideGroups = slides.stream()
            .map(SlideGroup::new)
            .collect(Collectors.toList());


        // TODO : handle last slide
        toto(slideGroups);
        toto(slideGroups);
        toto(slideGroups);
        toto(slideGroups);

        slideShow.slides = slideGroups.stream()
            .flatMap(g -> g.slides.stream())
            .collect(Collectors.toList());

        System.out.println(InterestFactor.computeFullScore(slideShow.slides));
        InputLoader.writeSlideShow(slideShow, outputFile);
    }

    private void toto(List<SlideGroup> slideGroups) {
        int i = 0;
        while (i < slideGroups.size() - 1) {
            SlideGroup slideGroup = slideGroups.get(i);

            SlideGroupInterestFactor bestInterest = null;

            int nbIter = 0;
            for (SlideGroup other : slideGroups) {
                nbIter++;
                if (nbIter == 1) {
                    continue;
                }

                SlideGroupInterestFactor interest = InterestFactor.computeInterestFactor(slideGroup, other, slideGroup.slides.size() < 2);

                if (bestInterest == null || interest.score > bestInterest.score) {
                    bestInterest = interest;
                }

                if (nbIter > 2000) {
                    break;
                }
            }

            slideGroup.merge(bestInterest.second, bestInterest.reverseFirst, bestInterest.reverseSecond);
            slideGroups.remove(bestInterest.second);

            i++;
        }
    }
}
