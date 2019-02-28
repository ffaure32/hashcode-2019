import java.util.List;

import com.zenika.kata.hashcode.InputLoader;
import com.zenika.kata.hashcode.model.SlideShow;
import org.junit.Test;

import com.zenika.kata.hashcode.model.Photo;
import com.zenika.kata.hashcode.reader.Reader;

public class HashcodeTest {

	private List<Photo> photos;

	@Test
	public void hashcode() {
		Reader reader = new Reader();
		photos = reader.readInputs("a_example.txt");

		SlideShow slideShow = new SlideShow();
		slideShow.addPhotos(photos);

		InputLoader.writeSlideShow(slideShow);
	}
}
