package edu.ggc.epatter1.grizzlycolors;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import edu.ggc.epatter1.grizzlycolors.About;
import edu.ggc.epatter1.grizzlycolors.R;


/**
 * Author: Elisha Patterson
 * March 12, 2016
 */
public class MainActivity extends AppCompatActivity {

    public SeekBar redSeekBar;
    public SeekBar blueSeekBar;
    public SeekBar greenSeekBar;
    private SeekBar alphaSeekBar;
    private TextView swatchTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        init();
    }

    private void init() {
        setImageBackgroundImageAlpha();
        createSeekBars();

        swatchTextView = (TextView) findViewById(R.id.swatchTextView);
        //TODO need to initialize textView setText with default value
        swatchTextView.setText("#00000000");

        createSeekBar(redSeekBar);
        createSeekBar(greenSeekBar);
        createSeekBar(blueSeekBar);
        createSeekBar(alphaSeekBar);
        createAboutButton();
    }


    private void setImageBackgroundImageAlpha() {

        View backgroundView = (View) findViewById(R.id.MainView);
        backgroundView.getBackground().setAlpha(120);

    }

    private void createSeekBars() {

        //TODO need to set sliders to default position
        redSeekBar = (SeekBar) findViewById(R.id.redSeekBar);
        redSeekBar.setMax(255);

        blueSeekBar = (SeekBar) findViewById(R.id.blueSeekBar);
        blueSeekBar.setMax(255);

        greenSeekBar = (SeekBar) findViewById(R.id.greenSeekBar);
        greenSeekBar.setMax(255);

        alphaSeekBar = (SeekBar) findViewById(R.id.alphaSeekBar);
        alphaSeekBar.setMax(255);
    }

    private void createAboutButton() {

        Button about = (Button) findViewById(R.id.btnAbout);
        about.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, About.class));
            }
        });
    }


    private void createSeekBar(SeekBar seekbar) {

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                changeTextView();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }


    private void changeTextView() {
    //TODO get current value off of the seekBar
         int redProgress = redSeekBar.getProgress();
         int greenProgress = greenSeekBar.getProgress();
         int blueProgress = blueSeekBar.getProgress();
         int alphaProgress = alphaSeekBar.getProgress();

        // determine the color for the background

        int backgroundColor = Color.argb(alphaProgress, redProgress, greenProgress, blueProgress);

        //inverse the color from the text so we can see it at all times
        int textColor = Color.argb(255, 255 - redProgress, 255 - greenProgress, 255 - blueProgress);


//apply color to the background

        swatchTextView.setBackgroundColor(backgroundColor);

        // set the color on the text and NOT the background
        swatchTextView.setTextColor(textColor);

        //this is where we set the text in the format FFFFFFFF

        swatchTextView.setText(String.format("#%02x%02x%02x%02x", alphaProgress, redProgress, greenProgress, blueProgress));

    }
}




