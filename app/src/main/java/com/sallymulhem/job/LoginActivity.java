package com.sallymulhem.job;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button button;
    TextView button2;
    EditText email,pass,etısım;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        etısım =findViewById(R.id.isim);
        button = findViewById(R.id.button);
        email = findViewById(R.id.ad);
        pass = findViewById(R.id.p1);
        kulanci k =new kulanci();

        String ee ="";

        DB =new DBHelper(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user ="";
                String password= "";
                user = email.getText().toString();
                password =pass.getText().toString();
                String ee = etısım.getText().toString();

                k.setIsim(user);
                if(user.equals("selin")||user.equals("raghad")&& password.equals("123")){
                    Intent intent = new Intent(LoginActivity.this,MainActivity11.class);
                    startActivity(intent);
                }
                else if(user.equals("")||password.equals("")) {
                    Toast.makeText(LoginActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user, password);
                    if(checkuserpass==true){
                        Toast.makeText(LoginActivity.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                        Intent intent1  = new Intent(LoginActivity.this, gec1.class);
                        intent1.putExtra( "man9",ee);
                        startActivity(intent1);
                        Intent intent  = new Intent(LoginActivity.this, MainActivity4.class);
                        intent.putExtra( "log",ee);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ( LoginActivity.this , SiginActivity.class);
                startActivity(intent);
            }
        });
    }
}