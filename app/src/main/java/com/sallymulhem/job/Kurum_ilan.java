package com.sallymulhem.job;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;

public class Kurum_ilan {
        String add;
        String phonee;
        String acıklama;
        String adress;
        Bitmap kurumResim;
        String  ozelıkler;
        String  zaman;
        String kulanciad;
        int  maas;

    public Kurum_ilan(String add, String phonee, String acıklama, String adress, Bitmap kurumResim, String ozelıkler, String zaman, int maas) {
        this.add = add;
        this.phonee = phonee;
        this.acıklama = acıklama;
        this.adress = adress;
        this.kurumResim = kurumResim;
        this.ozelıkler = ozelıkler;
        this.zaman = zaman;
        this.maas = maas;
    }

    public Kurum_ilan() {
    }

    public String getKulanciad() {
        return kulanciad;
    }

    public void setKulanciad(String kulanciad) {
        this.kulanciad = kulanciad;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getPhonee() {
        return phonee;
    }

    public void setPhonee(String phonee) {
        this.phonee = phonee;
    }

    public String getAcıklama() {
        return acıklama;
    }

    public void setAcıklama(String acıklama) {
        this.acıklama = acıklama;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Bitmap getKurumResim() {
        return kurumResim;
    }

    public void setKurumResim(Bitmap kurumResim) {
        this.kurumResim = kurumResim;
    }

    public String getOzelıkler() {
        return ozelıkler;
    }

    public void setOzelıkler(String ozelıkler) {
        this.ozelıkler = ozelıkler;
    }

    public String getZaman() {
        return zaman;
    }

    public void setZaman(String zaman) {
        this.zaman = zaman;
    }

    public int getMaas() {
        return maas;
    }

    public void setMaas(int maas) {
        this.maas = maas;
    }

    static public ArrayList<Kurum_ilan> getData(Context context) {
            ArrayList<Kurum_ilan> kurumList = new ArrayList<>();
            ArrayList<String> addList = new ArrayList<>();
            ArrayList<String> phoneeList = new ArrayList<>();
            ArrayList<String> acıklamalList = new ArrayList<>();
            ArrayList<String> adressList = new ArrayList<>();
            ArrayList<String> ozelıklerList = new ArrayList<>();
            ArrayList<String> zamanList = new ArrayList<>();
            ArrayList<Integer> maasList = new ArrayList<>();
            ArrayList<String> kulanciadList = new ArrayList<>();
            ArrayList<Bitmap> kurumResimList = new ArrayList<>();
            try {
                SQLiteDatabase database = context.openOrCreateDatabase("VV", Context.MODE_PRIVATE, null);
                Cursor cursor = database.rawQuery("SELECT * FROM KURUM_ilan", null);
                int w1 = cursor.getColumnIndex("ad");
                int w2 = cursor.getColumnIndex("tel");
                int w3 = cursor.getColumnIndex("acıklama");
                int w5 = cursor.getColumnIndex("adress");
                int w4 = cursor.getColumnIndex("ozelıkler");
                int w6 = cursor.getColumnIndex("zaman");
                int w7 = cursor.getColumnIndex("maas");
                int w8 = cursor.getColumnIndex("kurumimage");
                int w9 = cursor.getColumnIndex("kulancıAd");

                while (cursor.moveToNext()) {
                    addList.add(cursor.getString(w1));
                    phoneeList.add(cursor.getString(w2));
                    acıklamalList.add(cursor.getString(w3));
                    adressList.add(cursor.getString(w5));
                    ozelıklerList.add(cursor.getString(w4));
                    zamanList.add(cursor.getString(w6));
                    maasList.add(cursor.getInt(w7));
                    System.out.println("cursorrr"+cursor.getBlob(w8));
                    byte[] gelenResimByte = cursor.getBlob(w8);
                    Bitmap gelenResim = BitmapFactory.decodeByteArray(gelenResimByte, 0, gelenResimByte.length);
                    kurumResimList.add(gelenResim);
                //    kulanciadList.add(cursor.getString(w9));
                }
                cursor.close();
                for (int i = 0; i < addList.size(); i++) {
                    System.out.println("buraya geldi SELL");
                    Kurum_ilan kurum_ilan = new Kurum_ilan();
                    kurum_ilan.setAdd(addList.get(i));
                    kurum_ilan.setAdress(adressList.get(i));
                    kurum_ilan.setPhonee(phoneeList.get(i));
                    kurum_ilan.setAcıklama(acıklamalList.get(i));
                    kurum_ilan.setOzelıkler(ozelıklerList.get(i));
                    kurum_ilan.setZaman(zamanList.get(i));
//                    kurum_ilan.setKulanciad(kulanciadList.get(i));
                    kurum_ilan.setMaas(maasList.get(i));
                    kurum_ilan.setKurumResim(kurumResimList.get(i));

                    kurumList.add(kurum_ilan);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("returnselllist" + kurumList);
            return kurumList;
        }
    }





