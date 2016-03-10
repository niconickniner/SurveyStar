package com.cqu.tangdwx.surveystar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class welComeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wel_come);
    }
    public void goStart(View v) {
        Intent it = new Intent(this,firstActivity.class);
        startActivity(it);
    }
}
