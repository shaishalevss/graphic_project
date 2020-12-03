package Unittests;

import java.awt.Color;
import java.util.Random;

import org.junit.jupiter.api.Test;

import Renderer.ImageWriter;

class ImageWriterTest {

    @Test
    public void test() {
        ImageWriter imageWriter = new ImageWriter("imgWriterTest", 1600, 1000, 800, 500);
        int nX = imageWriter.getNx();
        int nY = imageWriter.getNy();

        for (int i = 0; i < nY; ++i)
            for (int j = 0; j < nX; ++j)
                imageWriter.writePixel(j, i,
                        j % 50 == 0 || i % 50 == 0 ? new Color(255,0,0) : new Color(255,255,0));

        imageWriter.writeToImage();
    }

    @Test
    public void test2() {
        ImageWriter imageWriter = new ImageWriter("anotherImageTest", 1600, 1000, 800, 500);
        int nX = imageWriter.getNx();
        int nY = imageWriter.getNy();

        for (int i = 0; i < nY; ++i)
            for (int j = 0; j < nX; ++j)
                imageWriter.writePixel(j, i,
                        j % 50 == 0  ? new Color(0,204,204) : new Color(102,204,0));

        imageWriter.writeToImage();
    }

    @Test
    public void test3() {
        ImageWriter imageWriter = new ImageWriter("anotherTwoImageTest", 1600, 1000, 800, 500);
        int nX = imageWriter.getNx();
        int nY = imageWriter.getNy();

        for (int i = 0; i < nY; ++i)
            for (int j = 0; j < nX; ++j)
                imageWriter.writePixel(j, i,
                        j % 50 != 0  ? new Color(0,204,204) : new Color(102,204,0));

        imageWriter.writeToImage();
    }
}