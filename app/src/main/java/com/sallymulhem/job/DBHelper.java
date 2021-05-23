package com.sallymulhem.job;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class DBHelper extends SQLiteOpenHelper {
    private static final String DBNAME = "VV";
    private static final int DB_VERSION = 2;
    private static final String KUrum_TABLE = "KURUM_ilan";
    public static final String R0W_kod = "kod";
    public static final String  ROW_AD= "ad";
    public static final String kulancı_ad = "kulancıAd";
    public static final String ROW_TEL = "tel";
    public static final String ROW_ACIKLAMA= "acıklama";
    public static final String ROW_ADRESS= "adress";
    public static final String ROW_OZELİKLER = "ozelıkler";
    public static final String ROW_ZAMMAN = "zaman";
    public static final String ROW_MAAS = "maas";
    public static final String ROW_photo = "kurumimage";
    //çalışan
    private static final String calısan_TABLE = "calisan_ilan";
    public static final String calısan_ID = "id";
    public static final String calısan_ad = "ad";
    public static final String calısan_bolum = "bolum";
    public static final String calısan_tel = "tel";
    public static final String calısan_yas = "yas";
    public static final String calısan_deneyimler = "deneymler";
    public static final String calısan_kurslar = "kurslar";
    Job job =new Job();








    public DBHelper(Context context) {
        super(context, DBNAME, null, DB_VERSION);
//        SQLiteDatabase db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create Table users(username TEXT primary key, password TEXT)");
       //MyDB.execSQL("create Table KURUM_ilan(Ad TEXT, Adress TEXT, Acıklama TEXT, tel TEXT, ozelıkler TEXT, zaman TEXT, maas TEXT)");
        db.execSQL("create Table calisan_ilan(Ad TEXT NOT NULL, bolum TEXT NOT NULL, tel TEXT NOT NULL, yas TEXT NOT NULL, deneymler TEXT NOT NULL, kurslar TEXT NOT NULL, kulancimage BLOB)");

        // MyDB.execSQL("CREATE TABLE " +KUrum_TABLE+ " ("+ R0W_ID+" INTEGER primary key, "+ ROW_AD+" TEXT NOT NULL , "+ ROW_ADRESS+" TEXT NOT NULL, "+ ROW_ACIKLAMA+" TEXT NOT NULL, "+ ROW_TEL+" TEXT NOT NULL, "+ ROW_OZELİKLER+" TEXT NOT NULL, "+ ROW_ZAMMAN+" INTEGER, "+ ROW_MAAS+" INTEGER)");
        db.execSQL("CREATE TABLE " +KUrum_TABLE+ " ("+ ROW_AD+" TEXT NOT NULL , "+ ROW_ADRESS+" TEXT NOT NULL, "+ ROW_ACIKLAMA+" TEXT NOT NULL, "+ ROW_TEL+" TEXT NOT NULL, "+ ROW_OZELİKLER+" TEXT NOT NULL, "+ ROW_ZAMMAN+" INTEGER, "+ ROW_MAAS+" INTEGER,"+kulancı_ad+" TEXT NOT NULL,"+ROW_photo+" BLOB)");

    }
    public void VeriEklekulancılı(String Ad,String Adress,String Acıklama,String tel,String ozelıkler,String zaman,int maas,String kulancı){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues cv =new ContentValues();

        cv.put(ROW_AD,Ad.trim());
        cv.put(ROW_ADRESS,Adress.trim());
        cv.put(ROW_ACIKLAMA,Acıklama.trim());
        cv.put(ROW_TEL,tel.trim());
        cv.put(ROW_OZELİKLER,ozelıkler.trim());
        cv.put(ROW_ZAMMAN,zaman);
        cv.put(ROW_MAAS,maas);
        cv.put(kulancı_ad,kulancı);
        System.out.println("DB"+kulancı);
        job.setTel(tel);
        job.setAd(Ad);
        db.insert(KUrum_TABLE,null, cv);
        db.close();
    }
    public void VeriEklekulancısız(String Ad,String Adress,String Acıklama,String tel,String ozelıkler,String zaman,int maas){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues cv =new ContentValues();

        cv.put(ROW_AD,Ad.trim());
        cv.put(ROW_ADRESS,Adress.trim());
        cv.put(ROW_ACIKLAMA,Acıklama.trim());
        cv.put(ROW_TEL,tel.trim());
        cv.put(ROW_OZELİKLER,ozelıkler.trim());
        cv.put(ROW_ZAMMAN,zaman);
        cv.put(ROW_MAAS,maas);
        job.setTel(tel);
        job.setAd(Ad);
        db.insert(KUrum_TABLE,null, cv);
        System.out.println("DBBBBBBBB"+tel);
        db.close();
    }
    public List<String> VeriListelekulancılı(){
        List<String> veriler = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] sutunler = {ROW_AD,ROW_ADRESS,ROW_ACIKLAMA,ROW_TEL,ROW_OZELİKLER,ROW_ZAMMAN, ROW_MAAS,kulancı_ad};
        Cursor cursor = db.query(KUrum_TABLE , sutunler ,null , null , null , null , null );

            while (cursor.moveToNext()) {
                veriler.add("Kulancı " + cursor.getString(7) + " bu ilanı ekledi \n" + "Ad : " + cursor.getString(0) + "\nAdress : " + cursor.getString(1) + "\nAçıklama : " + cursor.getString(2) + "\nTel : " + cursor.getString(3) + "\nİstenlen : " + cursor.getString(4) + "\nZamman : " + cursor.getInt(5) + "\nMaaş : " + cursor.getInt(6));
              // job= new Job(cursor.getInt(8),cursor.getString(1),cursor.getString(3),cursor.getString(2),cursor.getString(1),cursor.getString(4),cursor.getString(5),cursor.getInt(6));

            }

        return veriler;
    }
    public List<String> VeriListelekulancısız(){
        List<String> veriler = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] sutunler = {ROW_AD,ROW_ADRESS,ROW_ACIKLAMA,ROW_TEL,ROW_OZELİKLER,ROW_ZAMMAN, ROW_MAAS,ROW_photo};
        Cursor cursor = db.query(KUrum_TABLE , sutunler ,null , null , null , null , null );
        while (cursor.moveToNext()){
            veriler.add("Ad : "+cursor.getString(0)+"\nAdress : "+cursor.getString(1)+"\nAçıklama : "+cursor.getString(2)+"\nTel : "+cursor.getString(3)+"\nİstenlen : "+cursor.getString(4)+"\nZamman : "+cursor.getInt(5)+"\nMaaş : "+cursor.getInt(6));
            job.setAd(cursor.getString(0));
        }


        return veriler;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop Table if exists users");
        db.execSQL("drop Table if exists "+KUrum_TABLE);
        db.execSQL("drop Table if exists "+calısan_TABLE);
        onCreate( db);

    }
    public void VeriEkle1(String Ad,String bolum,String tel,int yas,String deneymler,String kurslar){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put(calısan_ad,Ad.trim());
        cv.put(calısan_bolum,bolum.trim());
        cv.put(calısan_tel,tel.trim());
        cv.put(calısan_yas,yas);
        cv.put(calısan_deneyimler,deneymler.trim());
        cv.put(calısan_kurslar,kurslar.trim());
        db.insert(calısan_TABLE,null, cv);
        db.close();
    }
    public List<String> VeriListele1(){
        List<String> veriler1 = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] sutunler1 = {calısan_ad,calısan_bolum,calısan_tel,calısan_yas,calısan_deneyimler,calısan_kurslar};
        Cursor cursor = db.query(calısan_TABLE , sutunler1 ,null , null , null , null , null );
        while (cursor.moveToNext()){
            veriler1.add("AD : "+cursor.getString(0)+"\nbolum : "+cursor.getString(1)+"\ntel : "+cursor.getString(2)+"\nyas : "+cursor.getInt(3)+"\ndeneyimler : "+cursor.getString(4)+"\nkurslar : "+cursor.getString(5));
        }
        /*String query = "SELECT * FROM "+KUrum_TABLE;
       db.rawQuery()*/
     //   System.out.println("ufhhhfuufcdkjkjkckccmcöckckkdkld**d*d*d**d**********************d*d**d*d*d*dd*d*d*d*d*d*d*d**f*f*f*f**rr*r**f*f**c**c*d**dd*d*d**d*d*dd**d*dd*d*d**d*d*d**dd**d*d*d**dd**dd**d*d*dd**d*d**d*d*d*d");
        return veriler1;

    }

    public Boolean insertData(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = MyDB.insert("users", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkkulancıname(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select *from KURUM_ilan where kulancıAd = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }
    public void deletedata (String id)
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        MyDB.execSQL("delete from  KURUM_ilan where ad ="+id);

    }

    public void deleteSell(String ad,String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete("KURUM_ilan","ad=? and kulancıAd=?", new String[]{ad,username});
       // db.execSQL("delete from  KURUM_ilan where ad ="+ad+"and kulancıAd ="+username);
    }
    public void updatasell(String add, String phonee, String acıklama, String adress, byte[] kurumResim, String ozelıkler, String zaman, String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ROW_AD, add);
        cv.put(ROW_TEL, phonee);
        cv.put(ROW_ACIKLAMA, acıklama);
        cv.put(ROW_ADRESS, adress);
        cv.put(ROW_OZELİKLER, ozelıkler);
        cv.put(ROW_ZAMMAN, zaman);
        cv.put(ROW_photo, kurumResim);
        long result = db.update("KURUM_ilan",cv,"ad=? and kulancıAd=?", new String[]{add,username});
        db.close();


    }

    public void deleteSell1(String ad) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete("calisan_ilan","Ad=?", new String[]{ad});
    }
}

