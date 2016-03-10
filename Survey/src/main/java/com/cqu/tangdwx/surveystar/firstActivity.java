package com.cqu.tangdwx.surveystar;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;

public class firstActivity extends AppCompatActivity {

    private String gender;
    private String starname;
    private String iflikestar;
    private String age;
    private boolean ifValidInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitialQ1_RadioGroup();
        InitialQ2_RadioGroup();
        InitialQ3_RadioGroup();
    }

    public void InitialQ1_RadioGroup() {
        RadioGroup rg1 = (RadioGroup) findViewById(R.id.radioGroup);
        final RadioButton yes = (RadioButton) findViewById(R.id.radioButton);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == yes.getId()) {
                    //select yes button.
                    TextView hidet = (TextView) findViewById(R.id.hidedText);
                    EditText hidee = (EditText) findViewById(R.id.hidedEdit);
                    hidet.setVisibility(View.VISIBLE);
                    hidee.setVisibility(View.VISIBLE);
                    iflikestar = "Yes";
                } else {
                    //no button
                    iflikestar = "No";
                }
            }
        });
    }
    public void InitialQ2_RadioGroup() {
        RadioGroup rg2 = (RadioGroup) findViewById(R.id.radioGroup2);
        final RadioButton male = (RadioButton) findViewById(R.id.radioButton3);
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == male.getId()) {
                    //if male
                    gender = "Male";
                }
                else {
                    gender = "Female";
                }
            }
        });
    }
    public void InitialQ3_RadioGroup() {
        RadioGroup rg3 = (RadioGroup) findViewById(R.id.botGroup);
        final RadioButton a = (RadioButton) findViewById(R.id.radioButton5);
        final RadioButton b = (RadioButton) findViewById(R.id.radioButton6);
        final RadioButton c = (RadioButton) findViewById(R.id.radioButton7);
        final RadioButton d = (RadioButton) findViewById(R.id.radioButton8);
        final RadioButton e = (RadioButton) findViewById(R.id.radioButton9);
        rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == a.getId()) {
                    age = "Below 15";
                }
                else if(checkedId == b.getId()) {
                    age = "16~20";
                }
                else if(checkedId == c.getId()) {
                    age = "21~25";
                }
                else if (checkedId == d.getId()) {
                    age = "26~30";
                }
                else if (checkedId == e.getId()) {
                    age = "Above 30";
                }
            }
        });
    }
    public void writeFile() throws IOException {
        FileOutputStream fos = openFileOutput("Survey.stg",MODE_APPEND);
        fos.write("If like star:".getBytes());
        fos.write(iflikestar.getBytes());
        String endl = "\n";
        fos.write(endl.getBytes());
        fos.write("Gender:".getBytes());
        fos.write(gender.getBytes());
        fos.write(endl.getBytes());
        fos.write("Age:".getBytes());
        fos.write(age.getBytes());
        fos.write(endl.getBytes());
        fos.close();
    }
    public void goNext(View v) {
        if(iflikestar == null) {
            Toast.makeText(getApplicationContext(),"You havn't choose Q1!",Toast.LENGTH_LONG).show();
            ifValidInput = false;
        }
        else if(iflikestar == "Yes") {
            EditText sn = (EditText) findViewById(R.id.hidedEdit);
            starname = sn.getText().toString();
            if(starname.length() == 0) {
                Toast.makeText(getApplicationContext(), "You havn't write star name!", Toast.LENGTH_LONG).show();
                ifValidInput = false;
            }
            else
                ifValidInput = true;
        }
        else {
            ifValidInput = true;
        }

        if(gender == null) {
            Toast.makeText(getApplicationContext(), "You havn't choose gender!", Toast.LENGTH_LONG).show();
            ifValidInput = false;
        }
        else {
            ifValidInput = true;
        }

        if(age == null) {
            Toast.makeText(getApplicationContext(), "You havn't choose ages!", Toast.LENGTH_LONG).show();
            ifValidInput = false;
        }
        else {
            ifValidInput = true;
        }

        if(ifValidInput) {
            try {
                writeFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //go to next activity
        }
    }
}
