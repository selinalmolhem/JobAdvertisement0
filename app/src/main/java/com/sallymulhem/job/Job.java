package com.sallymulhem.job;

import android.app.Activity;

import androidx.appcompat.app.AppCompatActivity;

public class Job extends Activity {
    private int id;
    private String ad;
    private String tel;
    private String acıklama;
    private String adress;
    private String ozelıkler;
    private String zaman;
    private int maas;
    public Job() {
    }

    public Job(int id, String ad, String tel, String acıklama, String adress, String ozelıkler, String zaman, int maas) {
        this.id = id;
        this.ad = ad;
        this.tel = tel;
        this.acıklama = acıklama;
        this.adress = adress;
        this.ozelıkler = ozelıkler;
        this.zaman = zaman;
        this.maas = maas;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTel() {

        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getAcıklama() {
        return acıklama;
    }

    public void setAcıklama(String acıklama) {
        this.acıklama = acıklama;
    }

    @Override
    public String toString() {
        return "Job{" +
                "tel='" + tel + '\'' +
                '}';
    }
}
