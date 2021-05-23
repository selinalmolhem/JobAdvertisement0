package com.sallymulhem.job;

import android.content.Context;

public class kulanci {
    int id;
    String isim;
    String Pas;

    public kulanci(int id, String isim, String pas) {
        this.id = id;
        this.isim = isim;
        Pas = pas;
    }

    public kulanci() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;

    }
Context context;
    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getPas() {
        return Pas;
    }

    public void setPas(String pas) {
        Pas = pas;
    }

    @Override
    public String toString() {
        return "kulanci{" +
                "id=" + id +
                ", isim='" + isim + '\'' +
                ", Pas='" + Pas + '\'' +
                '}';
    }
}
