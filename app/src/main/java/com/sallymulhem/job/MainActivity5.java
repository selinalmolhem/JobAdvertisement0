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

public class MainActivity5 extends AppCompatActivity {
Button button4;
EditText e1,e2,e3,e4,e5;
TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        t1=findViewById(R.id.ee);

        DBHelper dbHelper =new DBHelper(this);
        Job jj =new Job();
        //dbHelper.VeriEklekulancısız(jj.getAd(),jj.getAdress(),jj.getAcıklama(),jj.getTel(),jj.getOzelıkler(),jj.getZaman(),jj.getMaas());
        String k=jj.getTel();
        e2=findViewById(R.id.toEmail);
        e4=findViewById(R.id.m3);
        e5=findViewById(R.id.m4);

       // Intent ı=getIntent();
       // String geledi =ı.getStringExtra("email");
       // System.out.println("main5"+geledi);
        System.out.println("main5dddd"+k);

        e2.setText(k);

        Intent i =getIntent();
        String d=i.getStringExtra( "man5");
        e2.setText(d);
        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mailGonder(e2.getText().toString(),e4.getText().toString(),e5.getText().toString());

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