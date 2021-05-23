package com.sallymulhem.job;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class guncele extends AppCompatActivity {
    Button btngunc;
    Context context =this;
    List<String> veriler1;
    DBHelper DB;

    ImageView icview;
    Button btnsil,btngun;
    EditText ic1,ic2,ic3,ic4,ic5,ic6,ic7;
    String addtext;
    String phoneetext;
    String adressltext;
    String ozelkext;
    String acıktext,zammatext,kulantext;
    Bitmap kurumResimimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guncele);

        icview = findViewById(R.id.icerik_activity_imageViewsellResim);
        ic1=findViewById(R.id.d1);
        ic2=findViewById(R.id.d2);
        ic3=findViewById(R.id.d3);
        ic4=findViewById(R.id.d4);
        ic5=findViewById(R.id.d5);
        ic6=findViewById(R.id.d6);
        ic7=findViewById(R.id.d7);
        btnsil=findViewById(R.id.deta);
        btngun=findViewById(R.id.guu1);

        kulantext=MainActivity4.kk.getIsim();
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



        btngunc= findViewById(R.id.guu);
        btngunc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ByteArrayOutputStream outputStream =new ByteArrayOutputStream();
                kurumResimimage.compress(Bitmap.CompressFormat.PNG,75, outputStream);
                byte[] kayitEdilecekRseim = outputStream.toByteArray();
                try {
                    DB =new DBHelper(context);
                    DB.updatasell(ic1.getText().toString(),ic2.getText().toString(),ic6.getText().toString(),ic3.getText().toString(),kayitEdilecekRseim,ic4.getText().toString(),ic5.getText().toString(),kulantext);
                    Toast.makeText(getApplicationContext(),"İlanınız guncelendi",Toast.LENGTH_LONG).show();
                    Intent intent= new Intent(guncele.this,MainActivity9.class);
                    startActivity(intent);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}