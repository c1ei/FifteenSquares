package com.example.a15squares;
// Code heavily assisted by Alex Leonor
// Unable to move back to the previous move (Oct 2 @ 2210)
// Unable to make a move if first move was to the left (Oct 2 @ 2223)
// Unable to move down without crashing app (Oct 2 @ 2224)
// Unable to move right without crashing app (Oct 2 @ 2224)
// Unable to make a move if left move is made in the 2nd, 3rd, and 4th row (Oct 2 @ 2226)

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SquareView view = findViewById(R.id.Squares);

        Button shuffle = findViewById(R.id.shuffles);

        shuffle.setOnClickListener(view);

        view.setOnTouchListener(view);
    }
}