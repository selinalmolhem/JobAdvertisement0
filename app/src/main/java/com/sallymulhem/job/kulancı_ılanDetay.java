package com.sallymulhem.job;

import android.graphics.Bitmap;

public class kulancı_ılanDetay {

        String ad;
        String bolum;
        String tel;
        String yas;
        String deneymler,kurslar;
        Bitmap kulancıResim;

        public kulancı_ılanDetay() {
        }

    public kulancı_ılanDetay(String ad, String bolum, String tel, String yas, String deneymler, String kurslar, Bitmap kulancıResim) {
        this.ad = ad;
        this.bolum = bolum;
        this.tel = tel;
        this.yas = yas;
        this.deneymler = deneymler;
        this.kurslar = kurslar;
        this.kulancıResim = kulancıResim;
    }

    public Bitmap getKulancıResim() {
        return kulancıResim;
    }

    public void setKulancıResim(Bitmap kulancıResim) {
        this.kulancıResim = kulancıResim;
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
    }

