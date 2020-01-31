package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.helloworld.api.ApiClient;
import com.example.helloworld.api.StudentApi;
import com.example.helloworld.models.Student;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

import static java.lang.Integer.parseInt;

public class LearingJavaActivity extends AppCompatActivity {

    TextView txtLoginTitle;
    EditText edtName;
    Button btnClickMe;

    EditText edtNumberMin;
    EditText edtNumberMax;
    Button btnRandomNumber;
    TextView txtResult;

    Switch swtWifi;
    CheckBox cbA;
    CheckBox cbB;
    CheckBox cbC;
    Button btnSubmitCheckBox;

    RadioGroup radioGroup;

    ProgressBar progressBar;

    SeekBar seekBar;

    Button btnPlayGame;

    Button btnListView;
    Button btnGridView;

    Button btnVolley;
    Button btnRetrofit;

    EditText edtDate;

    TextView txtTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learing_java);

        initVar();
        learningJava();
    }

    private void initVar() {
        // Hello name element
        txtLoginTitle = findViewById(R.id.textViewLoginTitle);
        edtName = findViewById(R.id.editTextName);
        btnClickMe = findViewById(R.id.buttonClickMe);

        // Random number element
        edtNumberMin = findViewById(R.id.editTextNumberMin);
        edtNumberMax = findViewById(R.id.editTextNumberMax);
        btnRandomNumber = findViewById(R.id.buttonRandomNumber);
        txtResult = findViewById(R.id.textViewResult);

        // Switch and Checkbox
        swtWifi = findViewById(R.id.switchWifi);
        cbA = findViewById(R.id.checkBoxA);
        cbB = findViewById(R.id.checkBoxB);
        cbC = findViewById(R.id.checkBoxC);
        btnSubmitCheckBox = findViewById(R.id.buttonSubmitCheckBox);

        // Radio group and radio button
        radioGroup = findViewById(R.id.radioGroup);

        // ProgressBar
        progressBar = findViewById(R.id.progressBar);

        // SeekBar
        seekBar = findViewById(R.id.seekBar);

        // Buttons go to another view
        btnPlayGame = findViewById(R.id.buttonPlayGame);
        btnListView = findViewById(R.id.buttonListView);
        btnGridView = findViewById(R.id.buttonGridView);

        // Buttons api call
        btnVolley = findViewById(R.id.buttonVolleyCall);
        btnRetrofit = findViewById(R.id.buttonRetrofitCall);

        // Datetimepicker dialog
        edtDate = findViewById(R.id.editTextDate);

        // Timepicker dialog
        txtTime = findViewById(R.id.textViewTime);
    }

    private void learningJava() {
        ArrayList<String> nameList = new ArrayList<>();
        nameList.add("Khanh");
        nameList.add(1, "Huy");
        nameList.add(2, "Long");

        Log.d("KHANH", "nameList size : " + nameList.size());

        for (int i = 0; i < nameList.size(); i++) {
            Log.d("KHANH", "nameList index " + i + ": " + nameList.get(i));
        }

        for (String name : nameList) {
            Log.d("KHANH", name);
        }

        // Event click button to show name
        btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                Toast.makeText(LearingJavaActivity.this, name, Toast.LENGTH_SHORT).show();
            }
        });

        // Event check and show random number between min and max
        btnRandomNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();

                String textMin = edtNumberMin.getText().toString().trim();
                String textMax = edtNumberMax.getText().toString().trim();

                if (textMin.length() == 0 || textMax.length() == 0) {
                    Toast.makeText(LearingJavaActivity.this, "Please input Min and Max number", Toast.LENGTH_SHORT).show();
                    return;
                }

                Integer numMin = parseInt(textMin);
                Integer numMax = parseInt(textMax);

                if (numMax >= numMin) {
                    Integer randomNumber;
                    randomNumber = random.nextInt((numMax - numMin) + 1) + numMin;
                    txtResult.setText(randomNumber.toString());
                } else {
                    Toast.makeText(LearingJavaActivity.this, "Please input Max > Min!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Event switch
        swtWifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(LearingJavaActivity.this, "Turn wifi on", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LearingJavaActivity.this, "Turn wifi off", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Event checkbox
        cbA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(LearingJavaActivity.this, "Checked A", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LearingJavaActivity.this, "Uncheck A", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cbB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(LearingJavaActivity.this, "Checked B", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LearingJavaActivity.this, "Uncheck B", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cbC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(LearingJavaActivity.this, "Checked C", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LearingJavaActivity.this, "Uncheck C", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Event submit checkBox
        btnSubmitCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selected = "Selected: \n";
                if (cbA.isChecked()) {
                    selected += cbA.getText() + "\n";
                }
                if (cbB.isChecked()) {
                    selected += cbB.getText() + "\n";
                }
                if (cbC.isChecked()) {
                    selected += cbC.getText() + "\n";
                }
                Toast.makeText(LearingJavaActivity.this, selected, Toast.LENGTH_LONG).show();
            }
        });

        // Event radio group change
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String selected = "";
                switch (checkedId) {
                    case R.id.radioButtonA:
                        selected = "Selected A";
                        break;
                    case R.id.radioButtonB:
                        selected = "Selected B";
                        break;
                    case R.id.radioButtonC:
                        selected = "Selected C";
                        break;
                }
                Toast.makeText(LearingJavaActivity.this, selected, Toast.LENGTH_SHORT).show();
            }
        });

        // Countdown timer make progress bar run interval
        // 10000: Function will stop after 10s
        // 1000: Function run each 1s
        CountDownTimer countDownTimer = new CountDownTimer(10000, 500) {
            @Override
            public void onTick(long millisUntilFinished) {
                Integer currentProgress = progressBar.getProgress();
                if (currentProgress >= progressBar.getMax()) {
                    currentProgress = 0;
                }
                progressBar.setProgress(currentProgress + 5);
            }

            @Override
            public void onFinish() {
                this.start();
//                Toast.makeText(LearingJavaActivity.this, "Complete", Toast.LENGTH_SHORT).show();
            }
        };
        countDownTimer.start();

        // Seekbar change
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                Toast.makeText(LearingJavaActivity.this, "Volume: "+progress,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // Go to animal race activity
        btnPlayGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(LearingJavaActivity.this, AnimalRaceActivity.class);
                startActivity(k);
            }
        });

        btnListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(LearingJavaActivity.this, ListViewActivity.class);
                startActivity(k);
            }
        });

        btnGridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(LearingJavaActivity.this, GridViewActivity.class);
                startActivity(k);
            }
        });

        btnVolley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callApiVolley();
            }
        });

        btnRetrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callApiRetrofit();
            }
        });

        // Show datepicker dialog
        edtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectDate();
            }
        });

        // Show timepicker dialog
        txtTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectTime();
            }
        });

    }

    private void callApiVolley() {
        // Simple request
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://www.google.com";

        // Request a string response from the url
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(LearingJavaActivity.this, response.substring(0, 500), Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LearingJavaActivity.this, error.toString(), Toast.LENGTH_LONG).show();
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    private void callApiRetrofit() {
        Retrofit retrofit = ApiClient.getClient();

        StudentApi studentApi = retrofit.create(StudentApi.class);

        Call<Student> call = studentApi.getAllStudent();

        call.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, retrofit2.Response<Student> response) {
                Toast.makeText(LearingJavaActivity.this, response.toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Student> call, Throwable t) {
                Toast.makeText(LearingJavaActivity.this, t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void selectDate() {

        final Calendar calendar = Calendar.getInstance();
        int date = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                calendar.set(year, month, dayOfMonth);
                edtDate.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, year, month, date);
        datePickerDialog.show();
    }

    private void selectTime() {

        final Calendar time = Calendar.getInstance();
        int hour = time.get(Calendar.HOUR_OF_DAY);
        int minute = time.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm a");
                time.set(0, 0, 0, hourOfDay, minute);
                txtTime.setText(simpleDateFormat.format(time.getTime()));
            }
        }, hour, minute, false);
        timePickerDialog.show();
    }
}
