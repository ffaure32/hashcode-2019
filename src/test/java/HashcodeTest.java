import java.util.List;

import org.junit.Test;

import com.zenika.kata.hashcode.model.Photo;
import com.zenika.kata.hashcode.reader.Reader;

public class HashcodeTest {

	@Test
	public void hashcode() {
		Reader reader = new Reader();
		List<Photo> photos = reader.readInputs("a_example.txt");
	}
}
