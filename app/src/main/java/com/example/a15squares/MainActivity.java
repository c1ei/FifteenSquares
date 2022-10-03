package com.example.a15squares;
/**
 * Author: Cleithon Paguirigan
 * Date: October 03, 2022
 *
// Code heavily assisted by Alex Leonor
 *
 * Problems and errors along the way
// Unable to move back to the previous move (Oct 2 @ 2210)
// Unable to make a move if first move was to the left (Oct 2 @ 2223)
// Unable to move down without crashing app (Oct 2 @ 2224)
// Unable to move right without crashing app (Oct 2 @ 2224)
// Unable to make a move if left move is made in the 2nd, 3rd, and 4th row (Oct 2 @ 2226)
 *
// The Rectangle = new... code in Square was moved out of the if(!blankSquare) statement
// Moves to the up, down, left, right are now possible, however, still unable to access column 2 and 3 of bottom row (Oct 3 @ 0210)
 *
// Nested if statement problem in Playground class, checking method
// Missing bracket which altered which statement paired with what, while also changing what statement executes
// All possible action are now possible without the app crashing (Oct 3 @ 0220)
 *
// Implemented a correct position indicator
// The squares are a darker shade of pink when in the right position
// Correct position indicator was assisted by Brent Torres (Oct 3 @ 0248)
 */

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SquareView view = findViewById(R.id.Squares); // Finds the surfaceView Squares

        Button shuffle = findViewById(R.id.shuffles); // Finds the button Shuffle/Reset

        shuffle.setOnClickListener(view); // Establishes the shuffle/rest button

        view.setOnTouchListener(view); // Establishes touch listener, enabling the user to affect squares in surfaceView
    }
}