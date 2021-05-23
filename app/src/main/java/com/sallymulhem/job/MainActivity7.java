package com.sallymulhem.job;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class MainActivity7 extends AppCompatActivity {
    Button button8;

    EditText t1, t2, t3, t4, t5, t6, t7;
    int imgIzınAlmaKodu = 0, imgIzınAlaKodu = 1;
    TextView tt ;
    int id=0;
    Context context;
    ImageView imageResim;
    private Bitmap secilenresim;
    DBHelper DB = new DBHelper(context);
    Bitmap kucultulenResim,enbastakıResım;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        t1 = findViewById(R.id.ad);
        t2 = findViewById(R.id.adres);
        t3 = findViewById(R.id.acıklama);
        t4 = findViewById(R.id.emaıl);
        t5 = findViewById(R.id.Özelık);
        t6 = findViewById(R.id.zaman);
        t7 = findViewById(R.id.maas);
        imageResim=findViewById(R.id.kk);
        tt =findViewById(R.id.textView4);
        DB.job.setAd(t1.getText().toString());
        Intent i =getIntent();
        String d=i.getStringExtra( "s1");
        System.out.println(""+d);
        tt.setText(d);




        button8 = findViewById(R.id.button8);

        Context context = this;
        Job jj =new Job();

        jj.setTel(t1.getText().toString());
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String xx = t4.getText().toString();
                // int d = Integer.parseInt(t6.getText().toString());
                DBHelper dbHelper = new DBHelper(context);
                //dbHelper.VeriEklekulancılı(t1.getText().toString(), t2.getText().toString(), t3.getText().toString(), t4.getText().toString(), t5.getText().toString(), t6.getText().toString(), Integer.parseInt(t7.getText().toString()),tt.getText().toString());



                String e10TEXT =t1.getText().toString();
                String e11TEXT =t2.getText().toString();
                String e12TEXT =t3.getText().toString();
                String e13TEXT =t4.getText().toString();
                String e14TEXT =t5.getText().toString();
                String e15TEXT =t6.getText().toString();
                String e16TEXT =t7.getText().toString();
                System.out.println("hhhhhiiiii"+t1.getText().toString());

                ByteArrayOutputStream outputStream =new ByteArrayOutputStream();
                kucultulenResim = resimKucult(secilenresim);
                secilenresim.compress(Bitmap.CompressFormat.PNG,50, outputStream);
                byte[] kayitEdilecekRseim = outputStream.toByteArray();
                try {
                    // db.VeriEkle1(e10.getText().toString(), e11.getText().toString(), e12.getText().toString(), e13.getText().toString(), e14.getText().toString(),kayitEdilecekRseim);
                    SQLiteDatabase database = openOrCreateDatabase("VV",MODE_PRIVATE,null);
                    database.execSQL("CREATE TABLE IF NOT EXISTS KURUM_ilan (ad TEXT NOT NULL, tel TEXT NOT NULL, acıklama TEXT NOT NULL, adress TEXT NOT NULL, ozelıkler TEXT NOT NULL, zaman TEXT NOT NULL, maas int, kurumimage BLOB, kulancıAd TEXT NOT NULL)");
                    String sqlsorgu ="INSERT INTO KURUM_ilan(ad, tel, acıklama, adress, ozelıkler, zaman, maas, kurumimage, kulancıAd) VALUES (?,?,?,?,?,?,?,?,?)";
                    SQLiteStatement statement = database.compileStatement(sqlsorgu);
                    statement.bindString(1, e10TEXT);
                    statement.bindString(2, e11TEXT);
                    statement.bindString(3, e12TEXT);
                    statement.bindString(4, e14TEXT);
                    statement.bindString(5, e13TEXT);
                    statement.bindString(6, e15TEXT);
                    statement.bindString(7, e16TEXT);
                    System.out.println("jfjjfjjf"+e10TEXT);
                    statement.bindBlob(8,kayitEdilecekRseim);
                    statement.bindString(9, d);
                    statement.execute();

                    nesnelerıTemızle();
                    Toast.makeText(MainActivity7.this, "Save Successfully", Toast.LENGTH_SHORT).show();
                    System.out.println("Main7"+xx);
                    jj.setTel(t4.getText().toString());
                    Intent intent = new Intent(MainActivity7.this, MainActivity9.class);
                    intent.putExtra("user",d);
                    intent.putExtra("email",xx);
                    startActivity(intent);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
        //Buradan bilgileri mainactivty9'a getirecek.....
    }
    private  void nesnelerıTemızle(){
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t6.setText("");
        t7.setText("");
        enbastakıResım = BitmapFactory.decodeResource(this.getResources(),R.drawable.pp);
        imageResim.setImageBitmap(enbastakıResım);

    }
    private Bitmap resimKucult(Bitmap resim){
        return Bitmap.createScaledBitmap(resim,90,70,true);
    }
    public void resimSec(View v) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, imgIzınAlmaKodu);

        } else {
            Intent resimAL = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(resimAL, imgIzınAlaKodu);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == imgIzınAlmaKodu) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent resimAL = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(resimAL, imgIzınAlaKodu);
            }
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if ((requestCode == imgIzınAlaKodu)) {
            if (resultCode == RESULT_OK && data != null) {
                Uri resimUri = data.getData();

                try {
                    if (Build.VERSION.SDK_INT >= 28) {
                        ImageDecoder.Source resimSOURc = ImageDecoder.createSource(this.getContentResolver(), resimUri);
                        secilenresim = ImageDecoder.decodeBitmap(resimSOURc);
                        imageResim.setImageBitmap(secilenresim);
                    } else {
                        secilenresim = MediaStore.Images.Media.getBitmap(this.getContentResolver(), resimUri);
                        imageResim.setImageBitmap(secilenresim);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}