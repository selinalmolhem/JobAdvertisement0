package com.sallymulhem.job;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.List;

public class MainActivity9 extends AppCompatActivity {
    SearchView mysearch;
    ImageView imageview1;
    DBHelper DB;
    Context context = this;
    List<String> gelenler;
    TextView g;
    private RecyclerView mReclerView;
    private kurum_ilanadapter adapter;
    static  public  Kurum_ilanDetay kurum_ilanDetay;
    static  public  Kurum_ilan kurum_ilan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        Intent i =getIntent();
        String dd =i.getStringExtra("user");


        mReclerView =(RecyclerView)findViewById(R.id.main_activity_recyclerView);
        adapter = new kurum_ilanadapter(kurum_ilan.getData(this),this);
        System.out.println(kurum_ilan.getData(this));
        mReclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mReclerView.setLayoutManager(manager);
        mReclerView.setAdapter(adapter);



        Intent intent1 =getIntent();
        String dd1 =getIntent().getStringExtra("man9");
        System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm"+dd1);


        adapter.setOnItemClıckLıstener(new kurum_ilanadapter.OnItemClickListener() {
            @Override
            public void onItemClıck(Kurum_ilan kurum_ilan) {
                kurum_ilanDetay =new Kurum_ilanDetay(kurum_ilan.getAdd(),kurum_ilan.getPhonee(),kurum_ilan.getAcıklama(),kurum_ilan.getAdress(),kurum_ilan.getKurumResim(),kurum_ilan.getOzelıkler(),kurum_ilan.getZaman(),kurum_ilan.getMaas());
                Intent intent = new Intent(MainActivity9.this,icerikler.class);
                startActivity(intent);
            }

        });


        DB = new DBHelper(this);
        Job jj= new Job();
        gelenler = DB.VeriListelekulancısız();


        Intent ı=getIntent();
        String gelenemail = ı.getStringExtra("email");
        Intent i2 =getIntent();
       // Bundle extras = i2.getExtras();
       // ArrayList<String> arrayList = extras.getStringArrayList("list");
       // System.out.println("mmmmmmmmmmmmmm9"+extras.getStringArrayList("list"));
       // if(extras != null){
          //  ArrayAdapter<String> items = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, arrayList);
        //    L1.setAdapter(items);
       //     extras.clear();
      // }
  /*      ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity9.this, android.R.layout.simple_list_item_1, android.R.id.text1, gelenler);
        L1.setAdapter(adapter);
        L1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                    DBHelper DB= new DBHelper(context);
                 //   Boolean checkuser = DB.checkkulancıname(dd);
                   // if(checkuser == true ){
                        String templisview=gelenler.get(position);
                        Intent intent = new Intent(MainActivity9.this,silme_guceleme.class);
                        intent.putExtra("list",templisview);
                        System.out.println("mmmmmmmmmmmmm11"+templisview);
                        startActivity(intent);
                  //  }
                    //else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity9.this);
                        builder.setTitle("UYARI");
                        builder.setMessage("SİZ bu ilanı eklemediniz!!!");
                        builder.setCancelable(false);
                        builder.setIcon(android.R.drawable.ic_dialog_alert);

                        builder.setNeutralButton("iptal",null);
                        builder.show();
                    //}
                return false;
            }
        });*/


        mysearch =findViewById(R.id.search);
        mysearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
           //     adapter.getFilter().filter(newText);
                return false;
            }
        });


       // Bundle bundle = getIntent().getExtras();
            //Intent i =getIntent();
   //     if(!bundle.isEmpty()) {
  //          ArrayList<String> arrayList = bundle.getStringArrayList("list");
    //        ArrayAdapter<String> items = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, arrayList);
      //      L1.setAdapter(items);
        //    bundle.clear();
    //    }
      //  else{




       /* L1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity9.this, MainActivity5.class);
                intent.putExtra("email",gelenemail);
                System.out.println("main9"+gelenemail);
                startActivity(intent);
            }
        });*/
    }
}