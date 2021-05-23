package com.sallymulhem.job;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class kulancidetayel extends AppCompatActivity {
    Button bb;
    EditText e2,e4,e5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kulancidetayel);

        e2 = findViewById(R.id.d1);
        e4 = findViewById(R.id.d6);
        e5 = findViewById(R.id.d7);
        bb = findViewById(R.id.deta);

        Intent i =getIntent();
        String d=i.getStringExtra( "ic1");
        e5.setText(d);





        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mailGonder( d,e2.getText().toString(), e4.getText().toString());

                //Intent intent = new Intent ( MainActivity5.this ,MainActivity6.class);
                // startActivity(intent);
            }
        });
    }
        private void mailGonder(String adres, String konu, String icerik) {
            String [] dizi = {adres};
            Intent mailIntent = new Intent(Intent.ACTION_SEND);
            mailIntent.setType("message/rfc822");
            mailIntent.putExtra(Intent.EXTRA_EMAIL, new String []{adres} ); // gonderilecek mailller, dizi seklinde
            mailIntent.putExtra(Intent.EXTRA_SUBJECT,konu);
            mailIntent.putExtra(Intent.EXTRA_TEXT,icerik);
            try{
                startActivity(mailIntent);
            }catch (ActivityNotFoundException hata){
                Toast.makeText(getApplicationContext(),"hata olustu\n"+hata.getMessage(),Toast.LENGTH_LONG);
            }
        }
    }
