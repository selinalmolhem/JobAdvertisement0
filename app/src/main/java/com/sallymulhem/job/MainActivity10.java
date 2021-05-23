package com.sallymulhem.job;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.widget.ArrayAdapter;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.List;

public class MainActivity10 extends AppCompatActivity {
    SearchView mysearch;

    public DBHelper DB;

    private RecyclerView mReclerView;
    private kulanc_ialnadepter adapter;
    static  public  kulancı_ılanDetay kulancı_ılanDetay;
    static  public  kulanc_ilan kulancı_ilan;


    Context context =this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
        mReclerView =(RecyclerView)findViewById(R.id.main_activity_recyclerView1);
        adapter = new kulanc_ialnadepter(kulancı_ilan.getData(this),this);
        mReclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mReclerView.setLayoutManager(manager);
        mReclerView.setAdapter(adapter);

        adapter.setOnItemClıckLıstener(new kulanc_ialnadepter.OnItemClickListener() {
            @Override
                public void onItemClıck(kulanc_ilan kulancı_ılan) {
                    kulancı_ılanDetay =new kulancı_ılanDetay(kulancı_ılan.getAd(),kulancı_ılan.getBolum(),kulancı_ılan.getDeneymler(),kulancı_ılan.getKurslar(),kulancı_ılan.getTel(),kulancı_ılan.getYas(),kulancı_ılan.getKurumResim());
                    Intent intent = new Intent(MainActivity10.this,icerikler1.class);
                    startActivity(intent);
                }

        });

    //    final ListView L1 ;
    //    L1=(ListView)findViewById(R.id.v);

    //    DB = new DBHelper(MainActivity10.this);
     //  List<String> veriler2 = DB.VeriListele1();
     //   ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,android.R.id.text1, veriler2);
     //   L1.setAdapter(adapter);

        mysearch =findViewById(R.id.ss);
        mysearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
             //   adapter.getFilter().filter(newText);
                return false;
            }
        });

    }}