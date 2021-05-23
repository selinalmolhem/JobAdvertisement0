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
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class MainActivity8 extends AppCompatActivity {
    Button button4;
    EditText t1, t2, t3, t4, t5, t6, t7;
    Bitmap kucultulenResim, enbastakıResım;
    int imgIzınAlmaKodu0 = 0, imgIzınAlaKodu1 = 1;
    private Bitmap secilenresim;
    ImageView imageResim;
    Context context;
    DBHelper DB = new DBHelper(context);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        button4 = findViewById(R.id.button4);
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);
        t5 = findViewById(R.id.t5);
        t6 = findViewById(R.id.t6);
        imageResim = findViewById(R.id.kk);
        Context context = this;
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String e10TEXT = t1.getText().toString();
                String e11TEXT = t2.getText().toString();
                String e12TEXT = t3.getText().toString();
                String e13TEXT = t4.getText().toString();
                String e14TEXT = t5.getText().toString();
                String e15TEXT = t6.getText().toString();

                System.out.println("hhhhhiiiii" + t1.getText().toString());

                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                kucultulenResim = resimKucult(secilenresim);
                secilenresim.compress(Bitmap.CompressFormat.PNG, 50, outputStream);
                byte[] kayitEdilecekRseim = outputStream.toByteArray();
                try {
                    // db.VeriEkle1(e10.getText().toString(), e11.getText().toString(), e12.getText().toString(), e13.getText().toString(), e14.getText().toString(),kayitEdilecekRseim);
                    SQLiteDatabase database = openOrCreateDatabase("VV", MODE_PRIVATE, null);
                    database.execSQL("CREATE TABLE IF NOT EXISTS calisan_ilan (Ad TEXT NOT NULL, bolum TEXT NOT NULL, tel TEXT NOT NULL, yas TEXT NOT NULL, deneymler TEXT NOT NULL, kurslar TEXT NOT NULL, kulancimage BLOB)");
                    String sqlsorgu = "INSERT INTO calisan_ilan(Ad, bolum, tel, yas, deneymler, kurslar, kulancimage) VALUES (?,?,?,?,?,?,?)";
                    SQLiteStatement statement = database.compileStatement(sqlsorgu);
                    statement.bindString(1, e10TEXT);
                    statement.bindString(2, e11TEXT);
                    statement.bindString(3, e12TEXT);
                    statement.bindString(4, e14TEXT);
                    statement.bindString(5, e13TEXT);
                    statement.bindString(6, e15TEXT);
                    System.out.println("jfjjfjjf" + e10TEXT);
                    statement.bindBlob(7, kayitEdilecekRseim);
                    statement.execute();

                    nesnelerıTemızle();
                    Toast.makeText(MainActivity8.this, "Save Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity8.this, MainActivity10.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        //Buradan bilgileri mainactivty9'a getirecek.....
    }

    private void nesnelerıTemızle() {
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t6.setText("");
        enbastakıResım = BitmapFactory.decodeResource(this.getResources(), R.drawable.pp);
        imageResim.setImageBitmap(enbastakıResım);

    }

    private Bitmap resimKucult(Bitmap resim) {
        return Bitmap.createScaledBitmap(resim, 80, 70, true);
    }

    public void resimSec(View v) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, imgIzınAlmaKodu0);

        } else {
            Intent resimAL = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(resimAL, imgIzınAlaKodu1);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == imgIzınAlmaKodu0) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent resimAL = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(resimAL, imgIzınAlaKodu1);
            }
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if ((requestCode == imgIzınAlaKodu1)) {
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







                //dbHelper.onUpgrade(dbHelper.getWritableDatabase(),1,2);
           //     dbHelper.VeriEkle1(t1.getText().toString(),t2.getText().toString(),t3.getText().toString(),Integer.parseInt(t4.getText().toString()),t5.getText().toString(),t6.getText().toString());
          //      Intent intent = new Intent ( MainActivity8.this ,MainActivity6.class);
          //      startActivity(intent);



