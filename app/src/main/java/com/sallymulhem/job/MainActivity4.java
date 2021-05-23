package com.sallymulhem.job;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {
    TextView button4,button5,button6,button7;
    TextView t1,t2;
    static  public kulanci kk=new kulanci();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        t1=findViewById(R.id.qq);
        t2=findViewById(R.id.vv);

        Intent i =getIntent();
        String d=i.getStringExtra( "log");
        System.out.println("Hoş geldiniz "+d);
        t2.setText("Hoş geldiniz "+","+d);
        kk.setIsim(d);

        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ( MainActivity4.this ,gec2.class);
                startActivity(intent);
            }
        });
        button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1  = new Intent(MainActivity4.this, MainActivity7.class);
                i1.putExtra( "s1",d);
                kulanci k = new kulanci();
                k.setIsim(d);
                startActivity(i1);
            }
        });
        button6 = findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ( MainActivity4.this ,gec3.class);
                startActivity(intent);
            }
        });
        button7 = findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ( MainActivity4.this ,gec4.class);
                startActivity(intent);
            }
        });
    }
}