package com.example.a15squares;
/**
 * The purpose of this class is to make the squares that will be placed in a 4x4 array.
 * Three different squares will are drawn in this class depending on the position of the square in the array.
 * The third square is the blank square, which makes moves possible.
 */

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Square {
    private float sideLength; // Creates a variable, dimensions for 15/16 squares
    private Paint squareColor = new Paint(); // Main color of the squares
    private Paint textColor = new Paint(); // Color of the text in the squares
    private Paint squareCorrect = new Paint(); // Secondary color of the squares (when in the right position)
    private int numInSquare; // Creates a number in the square, representing the order in which squares need to be manoeuvred into
    private Rect theRectangle; // Rect object in creating and drawing the squares
    private boolean blankSquare = false; // An aspect of finding where blankSquare is placed in 4x4 array
    private boolean correctPosition = false; // An aspect of displaying whether number of square -> the position of the square

    // Creates the square with a color, creates text with a color
    public Square(float screenWidth, int squareNum) { // Square method, parameter of screenWidth
        sideLength = screenWidth / 4;
        numInSquare = squareNum;
        squareColor.setColor(0xFFFDD3CE); // A shade of pink
        squareColor.setStyle(Paint.Style.FILL);
        textColor.setColor(Color.WHITE);
        textColor.setTextSize(sideLength / 2);
        textColor.setTextAlign(Paint.Align.CENTER);

        squareCorrect.setColor(0xFFDFA8C0); // A darker shade of pink
        squareCorrect.setStyle(Paint.Style.FILL);
    }

    // Draws the square with the color, adds text into the square
    // Text is a number and the number represents the order in which squares need to be placed in to be solved

    // If the position of the square corresponds to number of the square, a different shade of the square is drawn in the array
    public void drawSquare(Canvas canvas, float _x, float _y) {
        theRectangle = new Rect((int) _x, (int) _y, (int) (_x + sideLength), (int) (_y + sideLength));
        // Draws the square on the screen
        if (!blankSquare) {
            if (!correctPosition) {
                canvas.drawRect(theRectangle, squareColor);
            } else {
                canvas.drawRect(theRectangle, squareCorrect);
            }
            canvas.drawText(Integer.toString(numInSquare), theRectangle.centerX(), theRectangle.centerY() + ((sideLength / 2) / 3), textColor);
        }
    }

    // Setters and getters

    // Blank squares making moves possible
    public void setBlankSquare() {
        blankSquare = true;
    }

    public boolean getBlankSquare() {
        return blankSquare;
    }

    // Getting the number that corresponds to the square, which creates possible "correct" position
    public int getNumInSquare() {
        return numInSquare;
    }

    // Checks if x and y coordinates of where the user touched are within the square bonds method
    public boolean checkSpace(float _x, float _y) {
        return theRectangle.contains((int)_x, (int)_y);
    }

    public void setCorrectPosition(boolean yup) {
        correctPosition = yup;
    }
}


