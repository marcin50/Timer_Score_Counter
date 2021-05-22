package com.example.scorecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreHome = 0;
    int scoreAway = 0;
    Chronometer timer;
    Boolean timeIsRunning=false;
    long stopOffset=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer = findViewById(R.id.timer);
    }

    /**
     * Toggles the timer start/stop
     */
    public void startStopTimer(View v) {
        Button startStopBtn = findViewById(R.id.startStopBtn);
        if (!timeIsRunning) {
            timer.setBase(SystemClock.elapsedRealtime() - stopOffset);
            timer.start();
            startStopBtn.setText("Stop");
        }else{
            timer.stop();
            stopOffset = SystemClock.elapsedRealtime() - timer.getBase();
            startStopBtn.setText("Start");
        }
        timeIsRunning = !timeIsRunning;
    }
    /**
     * reset the timer to 0
     */
    public void resetTimer(View v) {
        timer.setBase(SystemClock.elapsedRealtime());
        stopOffset = 0;
    }

    /**
     * add 1 point to home score
     */
    public void addOneForHome(View v) {
        scoreHome++;
        displayForHome(scoreHome);
    }

    /**
     * add 2 points to home score
     */
    public void addTwoForHome(View v) {
        scoreHome = scoreHome + 2;
        displayForHome(scoreHome);
    }

    /**
     * add 3 points to home score
     */
    public void addThreeForHome(View v) {
        scoreHome = scoreHome + 3;
        displayForHome(scoreHome);
    }

    /**
     * add 1 point to away score
     */
    public void addOneForAway(View v) {
        scoreAway++;
        displayForAway(scoreAway);
    }

    /**
     * add 2 points to away score
     */
    public void addTwoForAway(View v) {
        scoreAway = scoreAway + 2;
        displayForAway(scoreAway);
    }

    /**
     * add 3 points to away score
     */
    public void addThreeForAway(View v) {
        scoreAway = scoreAway + 3;
        displayForAway(scoreAway);
    }

    /**
     * resets the scores for both teams
     */
    public void resetScore(View v) {
        scoreHome = 0;
        scoreAway = 0;
        displayForHome(scoreHome);
        displayForAway(scoreAway);
    }

    /**
     * update score for Home
     */
    public void displayForHome(int score) {
        TextView scoreView = (TextView) findViewById(R.id.home_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * update score for away
     */
    public void displayForAway(int score) {
        TextView scoreView = (TextView) findViewById(R.id.away_score);
        scoreView.setText(String.valueOf(score));
    }


}