package com.zenika.kata.hashcode;

import com.zenika.kata.hashcode.model.Slide;
import com.zenika.kata.hashcode.model.SlideShow;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputLoader {
    public static final String INPUT_PREFIX = "in/";
    public static final String OUTPUT_PREFIX = "src/main/resources/out/";
    public static List<String> loadInputList(String fileName) {
        try {
            Path path = Paths.get(InputLoader.class.getClassLoader()
                    .getResource(INPUT_PREFIX+fileName).toURI());
            return Files.readAllLines(path);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Stream<String> loadInputStream(String fileName) {
        try {
            Path path = Paths.get(InputLoader.class.getClassLoader()
                    .getResource(INPUT_PREFIX+fileName).toURI());
            return Files.lines(path);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String loadInputAsString(String fileName) {
        try {
            Path path = Paths.get(InputLoader.class.getClassLoader()
                    .getResource(INPUT_PREFIX+fileName).toURI());
            return new String(Files.readAllBytes(path));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeList(String fileName, List<String> lines) {
        try {
            Path path = Paths.get(OUTPUT_PREFIX+fileName);
            Files.write(path, lines);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeSlideShow(SlideShow slideShow, String fileName) {
        List<String> lines = new ArrayList<>();

        lines.add(String.valueOf(slideShow.slides.size()));
        lines.addAll(
            slideShow.slides.stream()
                .map(Slide::toString)
                .collect(Collectors.toList())
        );

        writeList(fileName, lines);
    }

}
