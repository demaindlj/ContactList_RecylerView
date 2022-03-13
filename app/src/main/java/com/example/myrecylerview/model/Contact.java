package com.example.myrecylerview.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Contact implements Parcelable {

    private String nama;
    private String telp;
    private int  gambar;

    public Contact(String nama, String telp, int gambar) {
        this.nama = nama;
        this.telp = telp;
        this.gambar = gambar;
    }

    public Contact(){}

    protected Contact(Parcel in) {
        nama = in.readString();
        telp = in.readString();
        gambar = in.readInt();
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }

    @Override
    public String toString() {
        return "contact{" +
                "nama='" + nama + '\'' +
                ", telp=" + telp +
                ", gambar=" + gambar +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(telp);
        dest.writeInt(gambar);
    }
}
