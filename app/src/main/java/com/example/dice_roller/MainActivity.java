package com.example.dice_roller;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void on_button_click(View view) {
        TextView tv = this.findViewById(R.id.numberTextView);
        TextView inputBox = this.findViewById(R.id.inputBox);
        TextView scoreBox = this.findViewById(R.id.scoreNumberTextView);

        Random r = new Random();
        int number = r.nextInt(7);
        int numberFrominputBox;
        int score = Integer.parseInt(scoreBox.getText().toString());

        try {
            numberFrominputBox = Integer.parseInt(inputBox.getText().toString());
            if (number == numberFrominputBox && numberFrominputBox >= 1 && numberFrominputBox <= 6) {
                tv.setText("Congratulations");
                score++;
                scoreBox.setText(Integer.toString(score));
            } else if (numberFrominputBox < 1 || numberFrominputBox > 6) {
                tv.setText("Not a number between 1 and 6");
            } else {
                tv.setText(Integer.toString(number));

            }
        } catch (Exception e) {

        }
    }
}




