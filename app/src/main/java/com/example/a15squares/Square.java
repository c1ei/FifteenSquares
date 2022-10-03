package com.example.a15squares;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Square {
    private float sideLength;
    private Paint squareColor = new Paint();
    private Paint textColor = new Paint();
    private float xPos;
    private float yPos;
    private int numInSquare;
    private Rect theRectangle;
    private boolean blankSquare = false;

    // Creates the square with a color, creates text with a color
    public Square(float screenWidth, int squareNum) { // Square method, parameter of screenWidth
        sideLength = screenWidth / 4;
        numInSquare = squareNum;
        squareColor.setColor(0xFFFDD3CE); // A shade of pink
        squareColor.setStyle(Paint.Style.FILL);
        textColor.setColor(Color.BLACK);
        textColor.setTextSize(sideLength / 2);
        textColor.setTextAlign(Paint.Align.CENTER);
    }

    // Draws the square with the color, adds text into the square
    // Text is a number and the number represents the order in which squares need to be placed in to be solved
    public void drawSquare(Canvas canvas, float _x, float _y) {
        // Draws the square on the screen
        if (!blankSquare) {
            theRectangle = new Rect((int) _x, (int) _y, (int) (_x + sideLength), (int) (_y + sideLength));
            canvas.drawRect(theRectangle, squareColor);
            canvas.drawText(Integer.toString(numInSquare), theRectangle.centerX(), theRectangle.centerY() + ((sideLength / 2) / 3), textColor);
        }
    }

    public void setBlankSquare() {
        blankSquare = true;
    }
    public boolean checkSpace(float _x, float _y) {
        return theRectangle.contains((int) _x, (int) _y);
    }
    public boolean getBlankSquare() {
        return blankSquare;
    }

}

