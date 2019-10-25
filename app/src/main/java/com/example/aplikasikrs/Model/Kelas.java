package com.example.aplikasikrs.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Kelas implements Parcelable {

    private String kode_krs;
    private String nama;
    private String hari;
    private String sesi;
    private String dosen;
    private String jumlah;

    public Kelas(String kode_krs, String nama, String hari, String sesi, String dosen, String jumlah) {
        this.kode_krs = kode_krs;
        this.nama = nama;
        this.hari = hari;
        this.sesi = sesi;
        this.dosen = dosen;
        this.jumlah = jumlah;
    }

    protected Kelas(Parcel in) {
        kode_krs = in.readString();
        nama = in.readString();
        hari = in.readString();
        sesi = in.readString();
        dosen = in.readString();
        jumlah = in.readString();
    }

    public static final Creator<Kelas> CREATOR = new Creator<Kelas>() {
        @Override
        public Kelas createFromParcel(Parcel in) {
            return new Kelas(in);
        }

        @Override
        public Kelas[] newArray(int size) {
            return new Kelas[size];
        }
    };

    public String getKode_krs() {
        return kode_krs;
    }

    public void setKode_krs(String kode_krs) {
        this.kode_krs = kode_krs;
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

    public String getSesi() {
        return sesi;
    }

    public void setSesi(String sesi) {
        this.sesi = sesi;
    }

    public String getDosen() {
        return dosen;
    }

    public void setDosen(String dosen) {
        this.dosen = dosen;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(kode_krs);
        parcel.writeString(nama);
        parcel.writeString(hari);
        parcel.writeString(sesi);
        parcel.writeString(dosen);
        parcel.writeString(jumlah);
    }
}
