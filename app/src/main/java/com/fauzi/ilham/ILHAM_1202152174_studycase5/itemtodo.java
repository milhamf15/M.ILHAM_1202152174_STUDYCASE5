package com.fauzi.ilham.ILHAM_1202152174_studycase5;

/**
 * Created by dwima on 25/03/2018.
 */
//class ini digunakan untuk mengambil variable/objek yang digunakan di dalam database
public class itemtodo {
    String nama, deskripsi, prioritas;

    public itemtodo(String nama, String deskripsi, String prioritas) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.prioritas = prioritas;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getPrioritas() {
        return prioritas;
    }

    public void setPrioritas(String prioritas) {
        this.prioritas = prioritas;
    }
}
