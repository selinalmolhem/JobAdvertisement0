package com.sallymulhem.job;

import android.graphics.Bitmap;

public class Kurum_ilanDetay {
    String add;
    String phonee;
    String acıklama;
    String adress;
    Bitmap kurumResim;
    String  ozelıkler;
    String  zaman;
    int  maas;

    public Kurum_ilanDetay(String add, String phonee, String acıklama, String adress, Bitmap kurumResim, String ozelıkler, String zaman, int maas) {
        this.add = add;
        this.phonee = phonee;
        this.acıklama = acıklama;
        this.adress = adress;
        this.kurumResim = kurumResim;
        this.ozelıkler = ozelıkler;
        this.zaman = zaman;
        this.maas = maas;
    }

    public Kurum_ilanDetay() {
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
}
