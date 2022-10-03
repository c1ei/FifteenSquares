package com.example.a15squares;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;

public class SquareView extends SurfaceView implements View.OnClickListener, View.OnTouchListener{
    Playground SQUARE;
    private float widthScreen;

    public SquareView(Context context, AttributeSet attrs) {
        super(context, attrs);
        widthScreen = context.getResources().getDisplayMetrics().widthPixels;
        SQUARE = new Playground (widthScreen);

        setWillNotDraw(false);
    }

    @Override
    public void onDraw(Canvas canvas) {
        SQUARE.drawGrounds(canvas);
        invalidate();
    }

    @Override
    public void onClick(View v) {
        SQUARE.Shuffling();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            float x = event.getX();
            float y = event.getY();
            SQUARE.moveSquares(x, y);
            // tell to draw again soon
            invalidate();
            return true;
        }
        return false; // Nothing is done
    }
}

