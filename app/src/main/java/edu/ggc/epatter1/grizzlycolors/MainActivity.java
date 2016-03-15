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
    private Color color = new Color();
    private int redProgress, greenProgress, blueProgress;
    private String hex;

    public MainActivity() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        redSeekBar = (SeekBar) findViewById(R.id.redSeekBar);
        redSeekBar.setMax(255);

        blueSeekBar = (SeekBar) findViewById(R.id.blueSeekBar);
        blueSeekBar.setMax(255);

        greenSeekBar = (SeekBar) findViewById(R.id.greenSeekBar);
        greenSeekBar.setMax(255);
        alphaSeekBar = (SeekBar) findViewById(R.id.alphaSeekBar);


        swatchTextView = (TextView) findViewById(R.id.swatchTextView);


        redSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                redProgress = progress;
                hex = String.format("#%02x%02x%02x", redProgress, greenProgress, blueProgress);
                Log.d("RED PROGRESS", ": " + progress);
                swatchTextView.setBackgroundColor(Color.parseColor(hex));
//                swatchTextView.setTextColor();


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        blueSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                blueProgress = progress;
                hex = String.format("#%02x%02x%02x", redProgress, greenProgress, blueProgress);
                Log.d("BLUE PROGRESS", ": " + progress);
                swatchTextView.setBackgroundColor(Color.parseColor(hex));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        greenSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                greenProgress = progress;
                hex = String.format("#%02x%02x%02x", redProgress, greenProgress, blueProgress);
                Log.d("GREEN PROGRESS", ": " + progress);
                swatchTextView.setBackgroundColor(Color.parseColor(hex));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }


        });

        alphaSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float value = ((float) progress/100.0f );
//                String s = String.valueOf(value);
//                int number = Integer.parseInt(s);
                hex = Integer.toHexString(progress) + hex;
                swatchTextView.setAlpha(value);
// setBackgroundColor(Color.parseColor(hex));

//                swatchTextView.setAlpha(Float.valueOf(hex));
//                Log.i("alpha seekbar value: ", String.valueOf(value));
            }
            //format to hex value
            public void updateHex (int a, int r, int g, int b){
                swatchTextView = (TextView) findViewById(R.id.swatchTextView);
                String alphaHex = String.format("%02X", a);
                String redHex = String.format("%02X", r);
                String greenHex = String.format("%02X", g);
                String blueHex = String.format("%02X", b);

                String hexCode = "#" + alphaHex + redHex + greenHex + blueHex;
                swatchTextView.setText(hexCode);
                swatchTextView.setBackgroundColor(Color.argb(a,r,g,b));
                swatchTextView.setTextColor(Color.rgb(255 - r, 255 - g, 255 - b));



            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });





        Button about = (Button) findViewById(R.id.btnAbout);
        about.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, About.class));
            }
        });


    }
}





