package com.example.a15squares;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.Collections;

public class Playground {
    private float widthScreen;
    private ArrayList<Square> groundPlay = new ArrayList();

    // Draws the squares and adds the blank square (spot)
    public Playground(float screenWidth) {
        widthScreen = screenWidth;

        for (int i = 0; i < 15; i++) {
            groundPlay.add(new Square(widthScreen, i + 1));
        }
        groundPlay.add(new Square(screenWidth, 0));
        groundPlay.get(groundPlay.size() - 1).setBlankSquare();
    }

    // Draws the square in the arrangements of the array
    public void drawGrounds(Canvas canvas) {
        int j = 0;
        {
            for (int i = 0; i <= 15; i++) {
                groundPlay.get(i).drawSquare(canvas, (float) ((i % 4)) / 4 * widthScreen, (float) j / 4 * widthScreen);
                if ((i % 4 == 3) && (i != 0)) {
                    j++;
                }
            }
        }
    }

    // Shuffles and/or resets the array
    public void Shuffling() {
        Collections.shuffle(groundPlay);
    }

    public int findBlankSquare() {
        for (int i = 0; i < groundPlay.size(); i++) {
            if (groundPlay.get(i).getBlankSquare() == true) {
                return groundPlay.indexOf(groundPlay.get(i));
            }
        }
        return 0;
    }

    public int findTouching(float _x, float _y) {
        for (int i = 0; i < groundPlay.size(); i++) {
            if (groundPlay.get(i).checkSpace((int) _x, (int) _y) == true) {
                return groundPlay.indexOf(groundPlay.get(i));
            }
        }
        return 0;
    }

    public boolean checking(int blankSquare, int touching) {
        boolean rValid = false;

        if ((blankSquare >= 0) && (blankSquare <= 3)) {
            if ((touching == blankSquare + 1) || (touching == blankSquare - 1) || (touching == blankSquare + 4)) {
                rValid = true;
                return rValid;
            }
        }
        else if (blankSquare % 4 == 0) {
            if ((touching == blankSquare + 1) || (touching == blankSquare - 4) || (touching == blankSquare + 4)) {
                rValid = true;
                return rValid;
            }
        }
        else if (blankSquare % 4 == 3) {
            if ((touching == blankSquare - 1) || (touching == blankSquare - 4) || (touching == blankSquare + 4)) {
                rValid = true;
                return rValid;
            }
        }
        else if ((blankSquare >= 12) && (blankSquare <= 15)) {
            if ((touching == blankSquare + 1) || (touching == blankSquare - 1) || (touching == blankSquare - 4)) {
            } else {

                if ((touching == blankSquare + 1) || (touching == blankSquare - 1) || (touching == blankSquare + 4) || (touching == blankSquare - 4)) {
                    rValid = true;
                    return rValid;
                }
            }
        }

            return rValid;
    }

    public void moveSquares(float _x, float _y) {
        if (checking(findBlankSquare(), findTouching(_x, _y))) {
            Collections.swap(groundPlay, findBlankSquare(), findTouching(_x, _y));

        }

    }
}

