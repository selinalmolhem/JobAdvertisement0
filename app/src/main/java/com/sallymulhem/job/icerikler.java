package com.sallymulhem.job;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class icerikler extends AppCompatActivity {
    Context context =this;
    List<String> veriler1;
    DBHelper DB;
    TextView ic1,ic2,ic3,ic4,ic5,ic6,ic7;
    ImageView icview;
    Button btnsil,btngun;
    String addtext;
    String phoneetext;
    String adressltext;
    String ozelkext;
    String acıktext,zammatext,kulanctext;
    Bitmap kurumResimimage;
    ImageButton imBU;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icerikler);
        icview = findViewById(R.id.icerik_activity_imageViewsellResim);
        ic1=findViewById(R.id.d1);
        ic2=findViewById(R.id.detay2);
        ic3=findViewById(R.id.detay3);
        ic4=findViewById(R.id.detay4);
        ic5=findViewById(R.id.detay5);
        ic6=findViewById(R.id.d6);
        ic7=findViewById(R.id.d7);
        btnsil=findViewById(R.id.deta);
        btngun=findViewById(R.id.guu1);

        kulanctext=MainActivity4.kk.getIsim();

        addtext =MainActivity9.kurum_ilanDetay.getAdd();
        phoneetext=MainActivity9.kurum_ilanDetay.getPhonee();
        adressltext=MainActivity9.kurum_ilanDetay.getAdress();
        ozelkext=MainActivity9.kurum_ilanDetay.getOzelıkler();
        acıktext=MainActivity9.kurum_ilanDetay.getAcıklama();
        zammatext=MainActivity9.kurum_ilanDetay.getZaman();
       // maastext=MainActivity9.kurum_ilanDetay.getMaas();
        kurumResimimage=MainActivity9.kurum_ilanDetay.getKurumResim();

        ic1.setText(addtext);
        ic2.setText(phoneetext);
        ic3.setText(adressltext);
        ic4.setText(ozelkext);
        ic5.setText(zammatext);
        ic6.setText(acıktext);
      //  ic7.setText(adresstext);
        icview.setImageBitmap(kurumResimimage);






        btnsil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    DB =new DBHelper(context);
                    DB.deleteSell(ic1.getText().toString(),kulanctext);
                  //  Toast.makeText(getApplicationContext(),"İlanınız silindi",Toast.LENGTH_LONG).show();
                    Intent intent= new Intent(icerikler.this,MainActivity9.class);
                    startActivity(intent);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
        btngun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(icerikler.this,guncele.class);
                startActivity(intent);
            }
        });

        imBU=findViewById(R.id.imageButton);
        imBU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ee = ic4.getText().toString();
                Intent intent = new Intent(icerikler.this, MainActivity5.class);
                intent.putExtra( "man5",ee);
                startActivity(intent);
            }
        });
    }






}