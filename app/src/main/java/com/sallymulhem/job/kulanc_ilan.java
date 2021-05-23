package com.sallymulhem.job;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;

public class kulanc_ilan {
    String ad;
    String bolum;
    String tel;
    String yas;
    String deneymler,kurslar;
    Bitmap kulancıResim;

    public Bitmap getKurumResim() {
        return kulancıResim;
    }

    public void setKurumResim(Bitmap kurumResim) {
        this.kulancıResim = kurumResim;
    }

    public kulanc_ilan() {
    }


    public kulanc_ilan(String ad, String bolum, String tel, String yas, String deneymler, String kurslar, Bitmap kurumResim) {
        this.ad = ad;
        this.bolum = bolum;
        this.tel = tel;
        this.yas = yas;
        this.deneymler = deneymler;
        this.kurslar = kurslar;
        this.kulancıResim = kurumResim;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getYas() {
        return yas;
    }

    public void setYas(String yas) {
        this.yas = yas;
    }

    public String getDeneymler() {
        return deneymler;
    }

    public void setDeneymler(String deneymler) {
        this.deneymler = deneymler;
    }

    public String getKurslar() {
        return kurslar;
    }

    public void setKurslar(String kurslar) {
        this.kurslar = kurslar;
    }

    static public ArrayList<kulanc_ilan> getData(Context context) {

        ArrayList<kulanc_ilan> kulancıList = new ArrayList<>();
        ArrayList<String> adList = new ArrayList<>();
        ArrayList<String> bolumlList = new ArrayList<>();
        ArrayList<String> telList = new ArrayList<>();
        ArrayList<String> yasList = new ArrayList<>();
        ArrayList<String> denyemlerList = new ArrayList<>();
        ArrayList<String> kurslarList = new ArrayList<>();
        ArrayList<Bitmap> kulancıResimList = new ArrayList<>();
        try {
            SQLiteDatabase database = context.openOrCreateDatabase("VV", Context.MODE_PRIVATE, null);
            Cursor c = database.rawQuery("SELECT * FROM calisan_ilan", null);
            int w1 = c.getColumnIndex("Ad");
            int w2 = c.getColumnIndex("bolum");
            int w3 = c.getColumnIndex("tel");
            int w5 = c.getColumnIndex("yas");
            int w4 = c.getColumnIndex("deneymler");
            int w6 = c.getColumnIndex("kurslar");
            int w7 = c.getColumnIndex("kulancimage");
            while (c.moveToNext()) {
                adList.add(c.getString(w1));
                bolumlList.add(c.getString(w2));
                System.out.println("cursorrrrr2222"+c.getString(w2));
                telList.add(c.getString(w3));
                yasList.add(c.getString(w5));
                denyemlerList.add(c.getString(w4));
                kurslarList.add(c.getString(w6));
                byte[] gelenResimByte = c.getBlob(w7);
                Bitmap gelenResim = BitmapFactory.decodeByteArray(gelenResimByte, 0, gelenResimByte.length);
                kulancıResimList.add(gelenResim);
                //    kulanciadList.add(cursor.getString(w9));
            }
            c.close();
            for (int i = 0; i < adList.size(); i++) {
                System.out.println("buraya geldi SELL");
                kulanc_ilan kulancı_ilan = new kulanc_ilan();
                kulancı_ilan.setAd(adList.get(i));
                kulancı_ilan.setTel(telList.get(i));
                kulancı_ilan.setBolum(bolumlList.get(i));
                kulancı_ilan.setYas(yasList.get(i));
                kulancı_ilan.setDeneymler(denyemlerList.get(i));
                kulancı_ilan.setKurslar(kurslarList.get(i));
//                    kurum_ilan.setKulanciad(kulanciadList.get(i));
                kulancı_ilan.setKurumResim(kulancıResimList.get(i));

                kulancıList.add(kulancı_ilan);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("returnselllist" + kulancıList);
        return kulancıList;
    }
}
