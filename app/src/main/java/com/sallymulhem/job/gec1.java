package com.sallymulhem.job;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class gec1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent =getIntent();
        String qq =intent.getStringExtra("man9");

        setContentView(R.layout.activity_gec1);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent ( gec1.this , MainActivity9.class);
                intent.putExtra("man9",qq);
                startActivity(intent);
                finish();
            }
        },500);
    }
}