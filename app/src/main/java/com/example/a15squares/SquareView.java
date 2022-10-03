package com.example.a15squares;
/**
 * The purpose of this class is to implement views, on draws, and listeners.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;

public class SquareView extends SurfaceView implements View.OnClickListener, View.OnTouchListener {
    Playground SQUARE;
    private float widthScreen;

    // Gets the width of the screen, square dimensions are dependent on the width of the display
    public SquareView(Context context, AttributeSet attrs) {
        super(context, attrs);
        widthScreen = context.getResources().getDisplayMetrics().widthPixels;
        SQUARE = new Playground(widthScreen);

        setWillNotDraw(false);
    }

    // Drawing the square
    @Override
    public void onDraw(Canvas canvas) {
        SQUARE.drawGrounds(canvas);
        invalidate();
    }

    // Implementing the shuffling button
    @Override
    public void onClick(View v) {
        SQUARE.Shuffling();

    }

    // Implementing onTouch, ensuring that the users touch and the position of so is registered
    // Square being touched by the user also moves
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            float x = event.getX();
            float y = event.getY();
            SQUARE.moveSquares(x, y);
            // tell to draw again soon
            invalidate();
        }
        return false;
    }
}

