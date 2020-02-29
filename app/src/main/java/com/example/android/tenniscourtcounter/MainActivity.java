package com.example.android.tenniscourtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    boolean setComplete = false;
    int pointPlayerA = 0;
    int pointPlayerB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Gives points for player A
     *
     * @param view
     */
    public void pointForPlayerA(View view) {
        if (setComplete) {
            return;
        }

        pointPlayerA++;
        displayForPlayerA(pointPlayerA);

        setScore();
    }

    /**
     * Gives points for player B
     *
     * @param view
     */
    public void pointForPlayerB(View view) {
        if (setComplete) {
            return;
        }

        pointPlayerB++;
        displayForPlayerB(pointPlayerB);

        setScore();
    }

    /**
     * Reset the scores
     *
     * @param view
     */
    public void resetScores(View view) {
        setComplete = false;
        pointPlayerA = 0;
        pointPlayerB = 0;
        displayForPlayerA(0);
        displayForPlayerB(0);
        setScoreTextBox("");
    }

    /**
     * Displays the given score for Player A.
     *
     * @param score
     */
    private void displayForPlayerA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_a_score);
        scoreView.setText(convertScoreToCall(score));
    }

    /**
     * Displays the given score for Player B.
     *
     * @param score
     */
    private void displayForPlayerB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_b_score);
        scoreView.setText(convertScoreToCall(score));
    }

    /**
     * Sets score text
     */
    private void setScore() {
        if ((pointPlayerA == 4) && (pointPlayerB <= 2)) {
            setScoreTextBox("Set Player A");
            setComplete = true;
        } else if ((pointPlayerB == 4) && (pointPlayerA <= 2)) {
            setScoreTextBox("Set Player B");
            setComplete = true;
        } else if ((pointPlayerA == pointPlayerB) && (pointPlayerA >= 3) && (pointPlayerB >= 3)) {
            setScoreTextBox("Deuce");
        } else if (((pointPlayerA - pointPlayerB) == 1) && (pointPlayerA >= 3) && (pointPlayerB >= 3)) {
            setScoreTextBox("Advantage Player A");
        } else if (((pointPlayerB - pointPlayerA) == 1) && (pointPlayerA >= 3) && (pointPlayerB >= 3)) {
            setScoreTextBox("Advantage Player B");
        } else if (((pointPlayerA - pointPlayerB) == 2) && (pointPlayerA >= 3) && (pointPlayerB >= 3)) {
            setScoreTextBox("Set Player A");
            setComplete = true;
        } else if (((pointPlayerB - pointPlayerA) == 2) && (pointPlayerA >= 3) && (pointPlayerB >= 3)) {
            setScoreTextBox("Set Player B");
            setComplete = true;
        } else {
            setScoreTextBox(convertScoreToCall(pointPlayerA) + "-" + convertScoreToCall(pointPlayerB));
        }
    }

    /**
     * Sets text of TextView with the id of score_text
     *
     * @param text
     */
    private void setScoreTextBox(String text) {
        TextView winnerView = (TextView) findViewById(R.id.score_text);
        winnerView.setText(text);
    }

    /**
     * Converts number of points won to corresponding call
     *
     * @param score
     * @return
     */
    private String convertScoreToCall(int score) {
        if (score == 0) {
            return "0";
        } else if (score == 1) {
            return "15";
        } else if (score == 2) {
            return "30";
        } else if (score == 3) {
            return "40";
        } else if (score >= 4) {
            return "Game";
        } else {
            return "";
        }
    }
}
