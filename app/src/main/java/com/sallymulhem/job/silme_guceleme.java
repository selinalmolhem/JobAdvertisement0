package com.sallymulhem.job;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class silme_guceleme extends AppCompatActivity {
    Context context;
    DBHelper DB= new DBHelper(context);
    kulanci kk =new kulanci();
    Button delete;
    EditText name1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_silme_guceleme);
        String ad=DB.job.getAd();
        System.out.println("silmmmmmmmme"+ad);
        Intent intent = getIntent();
        String dd = intent.getStringExtra("list");
        name1 = (EditText) findViewById(R.id.name);
        name1.setText(dd);


        delete = findViewById(R.id.btnDelete);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nameTXT = name1.getText().toString();
                DB.deletedata(ad);
                System.out.println("silmeeeee"+DB.job.getAd());
                Toast.makeText(getApplicationContext(),"silindi",Toast.LENGTH_LONG).show();
            }
        });


    }
    }
