package com.sallymulhem.job;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity11 extends AppCompatActivity {
    ListView l;
    Context context =this;
    DBHelper DB =new DBHelper(context);
    String gecme;

    Job jj=new Job();
    List<String> gelenler = new ArrayList<>();


    private RecyclerView mReclerView;
    private kulanc_ialnadepter adapter;
    static  public  kulancı_ılanDetay kulancı_ılanDetay;
    static  public  kulanc_ilan kulancı_ilan;



    public void setGecme(String gecme) {
        this.gecme = gecme;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);
        mReclerView =(RecyclerView)findViewById(R.id.main_activity_recyclerView1);
        adapter = new kulanc_ialnadepter(kulancı_ilan.getData(this),this);
        mReclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mReclerView.setLayoutManager(manager);
        mReclerView.setAdapter(adapter);

        adapter.setOnItemClıckLıstener(new kulanc_ialnadepter.OnItemClickListener() {
            @Override

            public void onItemClıck(kulanc_ilan kulancı_ılan) {
                kulancı_ılanDetay = new kulancı_ılanDetay(kulancı_ılan.getAd(), kulancı_ılan.getBolum(), kulancı_ılan.getDeneymler(), kulancı_ılan.getKurslar(), kulancı_ılan.getTel(), kulancı_ılan.getYas(), kulancı_ılan.getKurumResim());
                String addd= kulancı_ılan.getAd();
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity11.this);
                builder.setTitle("Eminmisiniz?");
                builder.setMessage("Bu ilanı silecekmisiniz??");
                builder.setCancelable(false);
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setNegativeButton("hayır", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "vazgeçtiniz silinmedi...", Toast.LENGTH_LONG).show();
                    }
                });
                builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    //    Intent intent = new Intent(MainActivity11.this, icerikler1.class);
                       // startActivity(intent);
                        DB.deleteSell1(addd);
                        Toast.makeText(getApplicationContext(), "silindi...", Toast.LENGTH_LONG).show();

                    }
                });
                builder.setNeutralButton("iptal", null);
                builder.show();

            }
        });







        l=findViewById(R.id.l1);

        DB = new DBHelper(this);
        gelenler = DB.VeriListelekulancılı();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity11.this, android.R.layout.simple_list_item_1, android.R.id.text1, gelenler);
        l.setAdapter(adapter);


        l.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity11.this);
                builder.setTitle("KABUL EDECEKMİSİN");
                builder.setMessage("Eminmisinin");
                builder.setCancelable(false);
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setNegativeButton("hayır", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Hayrır gönderilmedi",Toast.LENGTH_LONG).show();
                    }
                });
                builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //MainActivity9 mm = new MainActivity9();
                       // Intent intent = new Intent(MainActivity11.this,MainActivity9.class);
                     //   intent.
                      // mm.kabul();



                        //Intent intent = new Intent(MainActivity11.this,MainActivity9.class);
                       // Bundle bundle = new Bundle();
                     //   bundle.putParcelableArrayList("LİST", gelenler);

                        String templisview=gelenler.get(position);
                        Intent intent = new Intent(MainActivity11.this,MainActivity9.class);
                        intent.putExtra("list",templisview);
                        System.out.println("mmmmmmmmmmmmm11"+templisview);
                        //Toast.makeText(getApplicationContext(),"Evet gönderildi",Toast.LENGTH_LONG).show();
                        startActivity(intent);
                    }
                });
                builder.setNeutralButton("iptal",null);
                builder.show();
                return false;
            }
        });
    }
}