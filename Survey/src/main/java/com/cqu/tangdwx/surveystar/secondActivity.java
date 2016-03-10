package com.cqu.tangdwx.surveystar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class secondActivity extends AppCompatActivity {

    private int ifq4;
    private int ifq5;
    private String q4;
    private String q5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        qus4();
        qus5();
    }
    public void qus4() {
        ifq4 = 0;
        CheckBox c1 = (CheckBox) findViewById(R.id.checkBox);
        CheckBox c2 = (CheckBox) findViewById(R.id.checkBox2);
        CheckBox c3 = (CheckBox) findViewById(R.id.checkBox3);
        CheckBox c4 = (CheckBox) findViewById(R.id.checkBox4);
        CheckBox c5 = (CheckBox) findViewById(R.id.checkBox5);
        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ifq4++;
                    Toast.makeText(getApplicationContext(), "HERE!", Toast.LENGTH_SHORT).show();
                    q4 = q4 + "News ";
                }
                else ifq4--;
            }
        });
        c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ifq4++;
                    q4 = q4 + "Films and Musics ";
                }
                else ifq4--;
            }
        });
        c3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ifq4++;
                    q4 = q4 + "Variety ";
                }
                else ifq4--;
            }
        });
        c4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ifq4++;
                    q4 = q4 + "Ins ";
                }
                else ifq4--;
            }
        });
        c5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ifq4++;
                    q4 = q4 + "Offline works.";
                }
                else ifq4--;
            }
        });
    }
    public void qus5() {
        ifq5 =0;
        CheckBox c6 = (CheckBox) findViewById(R.id.checkBox6);
        CheckBox c7 = (CheckBox) findViewById(R.id.checkBox7);
        CheckBox c8 = (CheckBox) findViewById(R.id.checkBox8);
        CheckBox c9 = (CheckBox) findViewById(R.id.checkBox9);
        c6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    ifq5++;
                    q5 = q5+"Facebook ";
                }
                else ifq5--;
            }
        });
        c7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    ifq5++;
                    q5 = q5+"Socialty ";
                }
                else ifq5--;
            }
        });
        c8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    ifq5++;
                    q5 = q5+"Search engine ";
                }
                else ifq5--;
            }
        });
        c9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    ifq5++;
                    q5 = q5+"News website";
                }
                else ifq5--;
            }
        });
    }

    public void writeFile() throws IOException {
        FileOutputStream fos = openFileOutput("Survey.stg",MODE_APPEND);
        fos.write("Concerns:".getBytes());
        fos.write(q4.getBytes());
        String endl = "\n";
        fos.write(endl.getBytes());
        fos.write("Ways:".getBytes());
        fos.write(q5.getBytes());
        fos.write(endl.getBytes());
        fos.close();
    }

    public void goNext(View v) {
        if(ifq4 == 0)
            Toast.makeText(getApplicationContext(), "You havn't answer Q4!", Toast.LENGTH_SHORT).show();
        else if(ifq5 == 0)
            Toast.makeText(getApplicationContext(), "You havn't choose Q5!", Toast.LENGTH_SHORT).show();
        else {
            try {
                writeFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //go to next activity
            Toast.makeText(getApplicationContext(), "SUCCEED!", Toast.LENGTH_SHORT).show();
            Intent it = new Intent(this,finalActivity.class);
            startActivity(it);
        }
    }
}
