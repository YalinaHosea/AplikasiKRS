package com.example.aplikasikrs.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Matkul implements Parcelable {
    private String kode_matkul;
    private String nama;
    private String hari;
    private String sks;
    private String sesi;

    public Matkul(String kode_matkul, String nama, String hari, String sks, String sesi) {
        this.kode_matkul = kode_matkul;
        this.nama = nama;
        this.hari = hari;
        this.sks = sks;
        this.sesi = sesi;
    }

    protected Matkul(Parcel in) {
        kode_matkul = in.readString();
        nama = in.readString();
        hari = in.readString();
        sks = in.readString();
        sesi = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(kode_matkul);
        dest.writeString(nama);
        dest.writeString(hari);
        dest.writeString(sks);
        dest.writeString(sesi);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Matkul> CREATOR = new Creator<Matkul>() {
        @Override
        public Matkul createFromParcel(Parcel in) {
            return new Matkul(in);
        }

        @Override
        public Matkul[] newArray(int size) {
            return new Matkul[size];
        }
    };

    public String getKode_matkul() {
        return kode_matkul;
    }

    public void setKode_matkul(String kode_matkul) {
        this.kode_matkul = kode_matkul;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getSks() {
        return sks;
    }

    public void setSks(String sks) {
        this.sks = sks;
    }

    public String getSesi() {
        return sesi;
    }

    public void setSesi(String sesi) {
        this.sesi = sesi;
    }
}
