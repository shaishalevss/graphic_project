package Unittests;
import java.math.*;
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
                        j % 50 == 0 || i % 50 == 0 ? new Color(0,204,204) : new Color(102,204,0));

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

    @Test
    public void test4() {
        ImageWriter imageWriter = new ImageWriter("new", 1600, 1000, 800, 500);
        int nX = imageWriter.getNx();
        int nY = imageWriter.getNy();
        int centerX = nX/2;
        int centerY = nY/2;
        final int cell = 25;

        for (int i = 0; i < nY; ++i) {
            for (int j = 0; j < nX; ++j) {
                imageWriter.writePixel(j, i,
                       new Color(154,202,254));
            }
        }

        //legs
        for (int i = 424; i < nY; ++i) {
            for (int j = 0; j < nX; ++j) {
                imageWriter.writePixel(j, i,
                        (j  >= (14*cell)-1 && j<= (16*cell)-1) || (j  >= (18*cell)-1 && j<= (20*cell)-1) ? new Color(0,0,0) : new Color(154,202,254));
            }
        }

        //belly fatttt
        for (int i = 199; i < 424; ++i) {
            for (int j = 0; j < nX; ++j) {
                imageWriter.writePixel(j, i,
                        (j  >= (12*cell)-1 && j<= (22*cell)-1) ? new Color(0,0,0) : new Color(154,202,254));
            }
        }

        //abs
        for (int i = 290; i < 405; ++i) {
            for (int j = (15*cell)-1; j < (19*cell); ++j) {
                imageWriter.writePixel(j, i,
                        new Color(147,7,154));
            }
        }

        //abs line up-down
        for (int i = 290; i < 405; ++i) {
            for (int j = (17*cell)-2; j < (17*cell)+1; ++j) {
                imageWriter.writePixel(j, i,
                        new Color(255,255,255));
            }
        }

        //abs line left-right first
        for (int i = 327; i < 329; ++i) {
            for (int j = (15*cell)-1; j < (19*cell); ++j) {
                imageWriter.writePixel(j, i,
                        new Color(255,255,255));
            }
        }

        //abs line left-right second
        for (int i = 363; i < 365; ++i) {
            for (int j = (15*cell)-1; j < (19*cell); ++j) {
                imageWriter.writePixel(j, i,
                        new Color(255,255,255));
            }
        }

        //neck
        for (int i = 174; i < 199; ++i) {
            for (int j = 0; j < nX; ++j) {
                imageWriter.writePixel(j, i,
                        (j  >= (16*cell)-1 && j<= (18*cell)-1) ? new Color(126,126,126) : new Color(154,202,254));
            }
        }

        //head
        for (int i = 74; i < 174; ++i) {
            for (int j = 0; j < nX; ++j) {
                imageWriter.writePixel(j, i,
                        (j  >= (14*cell)-1 && j<= (20*cell)-1) ? new Color(0,0,0) : new Color(154,202,254));
            }
        }

        //left eye
        for (int i = 99; i < 124; ++i) {
            for (int j = (15*cell)-5; j < (16*cell)+8; ++j) {
                imageWriter.writePixel(j, i, new Color(255,0,0));
            }
        }

        //right eye
        for (int i = 99; i < 120; ++i) {
            for (int j = (18*cell)-5; j < (19*cell)+8; ++j) {
                imageWriter.writePixel(j, i, new Color(255,255,255));
            }
        }

        //mouth
        for (int i = 136; i < 150; ++i) {
            for (int j = (16*cell)+6; j < (18*cell)-3; ++j) {
                imageWriter.writePixel(j, i, new Color(0,87,0));
            }
        }

        //left pupil
        for (int i = 102; i < 112; ++i) {
            for (int j = (15*cell)+9; j < (16*cell)-6; ++j) {
                imageWriter.writePixel(j, i, new Color(11,242,96));
            }
        }

        //right pupil
        for (int i = 110; i < 120; ++i) {
            for (int j = (18*cell)+9; j < (19*cell)-6; ++j) {
                imageWriter.writePixel(j, i, new Color(215,90,15));
            }
        }


        //left shoulder
        for (int i = 199; i < 249; ++i) {
            for (int j = (9*cell)-1; j < (12*cell); ++j) {
                imageWriter.writePixel(j, i,
                        new Color(242,85,89));
            }
        }

        //right shoulder
        for (int i = 199; i < 249; ++i) {
            for (int j = (22*cell)-1; j < (25*cell); ++j) {
                imageWriter.writePixel(j, i, new Color(242,85,89));
            }
        }

        //right arm
        for (int i = 249; i < 349; ++i) {
            for (int j = (23*cell)-1; j < (25*cell); ++j) {
                imageWriter.writePixel(j, i, new Color(0,0,0));
            }
        }

        //left arm
        for (int i = 249; i < 349; ++i) {
            for (int j = (9*cell)-1; j < (11*cell); ++j) {
                imageWriter.writePixel(j, i,
                        new Color(0,0,0));
            }
        }

        //left finger
        for (int i = 349; i < 390; ++i) {
            for (int j = (9*cell)-1; j < (11*cell); ++j) {
                imageWriter.writePixel(j, i,
                        (j >= (9*cell)+8 && j<= (10*cell)-6) ? new Color(255,255,0) : new Color(154,202,254));
            }
        }

        //left another finger
        for (int i = 349; i < 399; ++i) {
            for (int j = (10*cell)-1; j < (11*cell); ++j) {
                imageWriter.writePixel(j, i,
                        (j >= (10*cell)+8 && j<= (11*cell)-6) ? new Color(255,0,255) : new Color(154,202,254));
            }
        }

        //right finger
        for (int i = 349; i < 390; ++i) {
            for (int j = (23*cell)-1; j < (25*cell); ++j) {
                imageWriter.writePixel(j, i,
                        (j >= (23*cell)+15 && j<= (25*cell)-15) ? new Color(97,65,50) : new Color(154,202,254));
            }
        }


        //left antenna
        for (int i = 39; i < 74; ++i) {
            for (int j = (15*cell)-1; j < (16*cell); ++j) {
                imageWriter.writePixel(j, i, new Color(247,119,231));
            }
        }

        //right antenna
        for (int i = 24; i < 74; ++i) {
            for (int j = (18*cell)-1; j < (19*cell); ++j) {
                imageWriter.writePixel(j, i, new Color(43,36,159));
            }
        }


            imageWriter.writeToImage();
    }
}

//new Color(154,202,254)