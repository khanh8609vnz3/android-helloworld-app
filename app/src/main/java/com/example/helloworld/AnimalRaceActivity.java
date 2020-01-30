package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static java.lang.Integer.parseInt;

public class AnimalRaceActivity extends AppCompatActivity {

    TextView txtMoney;
    Button btnPlay;
    TextView txtStatus;
    CheckBox cbA;
    CheckBox cbB;
    CheckBox cbC;
    SeekBar sbA;
    SeekBar sbB;
    SeekBar sbC;

    String selected = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_race);

        initVar();
        playFunction();
    }

    private void initVar() {
        txtMoney = findViewById(R.id.textViewMoney);
        btnPlay = findViewById(R.id.buttonPlay);
        txtStatus = findViewById(R.id.textViewStatus);
        cbA = findViewById(R.id.checkBoxA);
        cbB = findViewById(R.id.checkBoxB);
        cbC = findViewById(R.id.checkBoxC);
        sbA = findViewById(R.id.seekBarA);
        sbB = findViewById(R.id.seekBarB);
        sbC = findViewById(R.id.seekBarC);

        Integer money = 100;
        txtMoney.setText(money + "");
    }

    private void playFunction() {

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!cbA.isChecked() && !cbB.isChecked() && !cbC.isChecked()) {
                    Toast.makeText(AnimalRaceActivity.this, "Please chose one", Toast.LENGTH_SHORT).show();
                    return;
                }

                disableButton();
                resetProgress();

                CountDownTimer cdTimer = new CountDownTimer(500, 250) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        running(sbA);
                        running(sbB);
                        running(sbC);
                        txtStatus.setText("Running");
                    }

                    @Override
                    public void onFinish() {
                        if (checkFinish(sbA) || checkFinish(sbB) || checkFinish(sbC)) {
                            if (checkFinish(sbA)) {
                                txtStatus.setText("A win");
                                checkWin(selected, "A");
                            }
                            if (checkFinish(sbB)) {
                                txtStatus.setText("B win");
                                checkWin(selected, "B");
                            }
                            if (checkFinish(sbC)) {
                                txtStatus.setText("C win");
                                checkWin(selected, "C");
                            }
                            enableButton();
                            Toast.makeText(AnimalRaceActivity.this, "Finish", Toast.LENGTH_SHORT).show();
                        } else {
                            this.start();
                        }
                    }
                };
                cdTimer.start();

            }
        });

        cbA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                resetCheck();
                if (isChecked) {
                    cbA.setChecked(true);
                    txtStatus.setText("Select A");
                    selected = "A";
                }
            }
        });

        cbB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                resetCheck();
                if (isChecked) {
                    cbB.setChecked(true);
                    txtStatus.setText("Select B");
                    selected = "B";
                }
            }
        });

        cbC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                resetCheck();
                if (isChecked) {
                    cbC.setChecked(true);
                    txtStatus.setText("Select C");
                    selected = "C";
                }
            }
        });
    }

    private void running(SeekBar sb) {
        Random rd = new Random();
        Integer distance = rd.nextInt(10);

        Integer currentDistance = sb.getProgress();
        sb.setProgress(currentDistance + distance);
    }

    private Boolean checkFinish(SeekBar sb) {
        return sb.getProgress() == 100;
    }

    private void resetProgress() {
        sbA.setProgress(0);
        sbB.setProgress(0);
        sbC.setProgress(0);
    }

    private void resetCheck() {
        cbA.setChecked(false);
        cbB.setChecked(false);
        cbC.setChecked(false);
    }

    private void checkWin(String selected, String result) {
        String currentMoney = txtMoney.getText().toString();
        if (selected.equals(result)) {
            txtMoney.setText((parseInt(currentMoney) + 10) + "");
        } else {
            txtMoney.setText((parseInt(currentMoney) - 10) + "");
        }
    }

    private void disableButton(){
        cbA.setEnabled(false);
        cbB.setEnabled(false);
        cbC.setEnabled(false);
        btnPlay.setEnabled(false);
    }

    private void enableButton(){
        cbA.setEnabled(true);
        cbB.setEnabled(true);
        cbC.setEnabled(true);
        btnPlay.setEnabled(true);
    }
}
