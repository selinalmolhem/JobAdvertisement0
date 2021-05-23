package com.sallymulhem.job;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SiginActivity extends AppCompatActivity {
    Button kayıt;
    TextView donus;
    EditText email,pass1,pass2;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        email = findViewById(R.id.ad);
        pass1 =findViewById(R.id.p1);
        pass2 =findViewById(R.id.p2);
        kayıt = findViewById(R.id.button);
        donus = findViewById(R.id.button2);
        DB = new DBHelper(this);

        kayıt.setOnClickListener(new View.OnClickListener() {// button yani sigin e pasarsak ne olacak
            @Override
            public void onClick(View v) {
                String user  = email.getText().toString();
                String pasword  = pass1.getText().toString();
                String pasword2  = pass2.getText().toString();
                if(user.equals("")||pasword.equals("")||pasword2.equals(""))
                    Toast.makeText(SiginActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    if(pasword.equals(pasword2)){
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user, pasword);
                            if(insert==true){
                                Toast.makeText(SiginActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(SiginActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(SiginActivity.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(SiginActivity.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        donus.setOnClickListener(new View.OnClickListener() {// button yani yukardaki login e pasarsak ne olacak
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ( SiginActivity.this , LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}