package com.example.aplikasikrs.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Dosen implements Parcelable {
    private String nidn;
    private String nama;
    private String gelar;
    private String email;
    private String alamat;
    private int foto;

    public Dosen(String nidn, String nama, String gelar, String email, String alamat, int foto) {
        this.nidn = nidn;
        this.nama = nama;
        this.gelar = gelar;
        this.email = email;
        this.alamat = alamat;
        this.foto = foto;
    }

    protected Dosen(Parcel in) {
        nidn = in.readString();
        nama = in.readString();
        gelar = in.readString();
        email = in.readString();
        alamat = in.readString();
        foto = in.readInt();
    }

    public static final Creator<Dosen> CREATOR = new Creator<Dosen>() {
        @Override
        public Dosen createFromParcel(Parcel in) {
            return new Dosen(in);
        }

        @Override
        public Dosen[] newArray(int size) {
            return new Dosen[size];
        }
    };

    public void setNidn(String nidn) {
        this.nidn = nidn;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setGelar(String gelar) {
        this.gelar = gelar;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNidn() {
        return nidn;
    }

    public String getNama() {
        return nama;
    }

    public String getGelar() {
        return gelar;
    }

    public String getEmail() {
        return email;
    }

    public String getAlamat() {
        return alamat;
    }

    public int getFoto() {
        return foto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nidn);
        parcel.writeString(nama);
        parcel.writeString(gelar);
        parcel.writeString(email);
        parcel.writeString(alamat);
        parcel.writeInt(foto);
    }
}
