package com.sallymulhem.job;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class icerikler1 extends AppCompatActivity {
    Context context =this;
    List<String> veriler1;
    DBHelper DB;
    TextView ic1,ic2,ic3,ic4,ic5,ic6,ic7;
    ImageView icview;
    Button btnsil,btngun;
    String adtext;
    String teltext;
    String bolumltext;
    String yasext;
    String deneymlertext,kurslartext;
    Bitmap kulancıResimimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icerikler1);
        icview = findViewById(R.id.icerik_activity_imageViewsellResim);
        ic1 = findViewById(R.id.d1);
        ic2 = findViewById(R.id.detay2);
        ic3 = findViewById(R.id.d7);
        ic4 = findViewById(R.id.detay4);
        ic5 = findViewById(R.id.detay5);
        ic6 = findViewById(R.id.d6);
        btnsil = findViewById(R.id.deta);


        adtext = MainActivity10.kulancı_ılanDetay.getAd();
        teltext = MainActivity10.kulancı_ılanDetay.getTel();
        bolumltext = MainActivity10.kulancı_ılanDetay.getBolum();
        yasext = MainActivity10.kulancı_ılanDetay.getYas();
        deneymlertext = MainActivity10.kulancı_ılanDetay.getDeneymler();
        kurslartext = MainActivity10.kulancı_ılanDetay.getKurslar();
        // maastext=MainActivity9.kurum_ilanDetay.getMaas();
        kulancıResimimage = MainActivity10.kulancı_ılanDetay.getKulancıResim();

        ic1.setText(adtext);
        ic2.setText(teltext);
        ic3.setText(bolumltext);
        ic4.setText(yasext);
        ic5.setText(deneymlertext);
        ic6.setText(kurslartext);
        icview.setImageBitmap(kulancıResimimage);





        btnsil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                 //   DB = new DBHelper(context);
                 //   DB.deleteSell1(ic1.getText().toString());
                //    Toast.makeText(getApplicationContext(), "İlan silindi", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(icerikler1.this, kulancidetayel.class);
                    intent.putExtra( "ic1",ic4.getText().toString());
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }}