package com.example.a15squares;
/**
 * The purpose of this class is to make the array where the squares will be going into.
 * This class also shuffles the squares in a random position.
 * This class makes moves possible, switching the positions of the blank square and an adjacent square.
 * This class deciphers whether the square is in the right spot and assists in changing its color.
 */

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.Collections;

public class Playground {
    private float widthScreen;
    private ArrayList<Square> groundPlay = new ArrayList();

    // Draws the squares and adds the blank square (spot)
    // Squares are already shuffled as soon as the app is ran
    public Playground(float screenWidth) {
        widthScreen = screenWidth;

        for (int i = 0; i < 15; i++) {
            groundPlay.add(new Square(widthScreen, i + 1));
        }
        groundPlay.add(new Square(screenWidth, 0));
        groundPlay.get(groundPlay.size() - 1).setBlankSquare();
        Shuffling();
    }

    // Draws the square in the arrangements of the array
    public void drawGrounds(Canvas canvas) {
        int j = 0;
        {
            for (int i = 0; i <= 15; i++) {
                groundPlay.get(i).drawSquare(canvas, (float) ((i % 4)) / 4 * widthScreen, (float) j / 4 * widthScreen);
                // Creates another row in the array, places squares in this row
                if ((i % 4 == 3) && (i != 0)) {
                    j++;
                }
            }
        }
    }

    // Shuffles and/or resets the array
    // Also checks if any of the squares are already in their corresponding position
    public void Shuffling() {
        for (Square square : groundPlay) {
            square.setCorrectPosition(false);
        }
        Collections.shuffle(groundPlay);
        posIsCorrect();
    }

    // Finds where the blank square is in the groundPlay array
    public Square findBlankSquare() {
        for (Square square : groundPlay) {
            if (square.getBlankSquare()) {
                return square;
            }
        }
        return null;
    }

    // Finds where the user touches on the screen
    // Is assisted by onTouchListener
    public Square findTouching(float _x, float _y) {
        for (Square square : groundPlay) {
            if (square.checkSpace((int)_x, (int)_y)) {
                return square;
            }
        }
        return null;
    }

    // Checks whether square being touched by user is adjacent to the blank square
    // If not, nothing happens
    public boolean checking(Square blankSquare, Square touching) {
        int posTouching = groundPlay.indexOf(touching);
        int posBlankSquare = groundPlay.indexOf(blankSquare);

        // Top row bounds checking
        if ((posBlankSquare >= 0) && (posBlankSquare < 3)) {
            if ((posTouching == posBlankSquare + 1) || (posTouching == posBlankSquare - 1) || (posTouching == posBlankSquare + 4)) {
                return true;

            }
        }
        // Most left column bounds checking
        else if (posBlankSquare % 4 == 0) {
            if ((posTouching == posBlankSquare + 1) || (posTouching == posBlankSquare - 4) || (posTouching == posBlankSquare + 4)) {
                return true;

            }
        }
        // Most right column bounds checking
        else if (posBlankSquare % 4 == 3) {
            if ((posTouching == posBlankSquare - 1) || (posTouching == posBlankSquare - 4) || (posTouching == posBlankSquare + 4)) {
                return true;

            }
        }
        // Bottom row bounds checking
        else if ((posBlankSquare >= 12) && (posBlankSquare <= 15)) {
            if ((posTouching == posBlankSquare + 1) || (posTouching == posBlankSquare - 1) || (posTouching == posBlankSquare - 4)) {
                return true;
            }
        }
        // Middle row/column bounds checking
            else {
                if ((posTouching == posBlankSquare + 1) || (posTouching == posBlankSquare - 1) || (posTouching == posBlankSquare + 4) || (posTouching == posBlankSquare - 4)) {
                    return true;

                }
            }
            // Nothing happens if squares are not adjacent to the blank square
            return false;
    }

    // Switches the position of the square touched by the user and the blank square
    // Checks whether the square being moved is in its corresponding position based on number
    public void moveSquares(float _x, float _y) {
        Square theSquare = findTouching((int)_x, (int)_y);
        Square theBlankSquare = findBlankSquare();

        if (checking(theSquare, theBlankSquare)) {
            Collections.swap(groundPlay, groundPlay.indexOf(theSquare), groundPlay.indexOf(theBlankSquare));
            posIsCorrect();

        }

    }

    // Checks whether the square is in the right position
    // Checks the number of the square and sees if the square is positioned in its corresponding place in the array
    public boolean posIsCorrect() {
        for (Square nicePos : groundPlay) {
            if (nicePos.getNumInSquare() == groundPlay.indexOf(nicePos) + 1) {
                nicePos.setCorrectPosition(true);
            }
            else {
                nicePos.setCorrectPosition(false);
            }
        }
        return false;
    }

}

