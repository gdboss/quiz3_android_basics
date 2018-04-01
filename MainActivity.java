package com.example.android.gdquiz;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Correctly typed answer for editable text question
     *  Add correct answers and increment score for each answer
     * */

    public void GradeAnswers (View view) {
        EditText myEditText = findViewById(R.id.oath_text);
        String myEditTextValue = myEditText.getText().toString();
        if (myEditTextValue.matches("Hippocratic Oath")) {
            score = score + 1;
        }

        int[] radios = new int[]{R.id.q1bCorrect, R.id.q2aCorrect, R.id.q5ccorrect};
        RadioButton[] arrayButton = new RadioButton[radios.length];
        int[] checks = new int[]{R.id.q3acorrect, R.id.q3bcorrect, R.id.q3ccorrect, R.id.q3dcorrect};
        CheckBox[] arrayChecks = new CheckBox[checks.length];

        for (int i = 0; i < arrayButton.length; i++) {
            arrayButton[i] = findViewById(radios[i]);
        }

        for (int i = 0; i < arrayChecks.length; i++) {
            arrayChecks[i] = findViewById(checks[i]);
        }

        for (RadioButton button : arrayButton) {
            if (button.isChecked()) {
                score += 1;
            }
        }

        for (CheckBox box : arrayChecks) {
            if (box.isChecked()) {
                score += 1;
            }
        }

        /** Pop up a message with score out of 10
         * */

        Toast.makeText(this, "You got " + String.valueOf(score) + " out of 8 correct!", Toast.LENGTH_SHORT).show();

        /** Reset all answers after user submits
         *
         */

        Intent intent = getIntent();
        finish();
        startActivity(intent);


    }


}

