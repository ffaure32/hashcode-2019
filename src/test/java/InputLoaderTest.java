import com.zenika.kata.hashcode.InputLoader;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;

public class InputLoaderTest {
    @Test
    public void testWriteFile() {
        List<String> lines = Lists.newArrayList("toto", "titi", "tata");
        InputLoader.writeList("tutu.txt", lines);
    }


    @Test
    public void testReadWriteFile() {
        List<String> lines = InputLoader.loadInputList("a_example.in");
        InputLoader.writeList("output.txt", lines);
    }

}
