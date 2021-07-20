package com.calistasakralya.model;

import com.google.gson.annotations.SerializedName;

public class ClientModel {
    @SerializedName("email")
    private final String email;
    @SerializedName("nama_lengkap")
    private final String nama_lengkap;
    @SerializedName("no_ktp")
    private final String no_ktp;
    @SerializedName("alamat")
    private final String alamat;
    @SerializedName("no_telp")
    private final String no_telp;


    public ClientModel( String email, String nama_lengkap, String no_ktp, String alamat, String no_telp) {
        this.email = email;
        this.nama_lengkap = nama_lengkap;
        this.no_ktp = no_ktp;
        this.alamat = alamat;
        this.no_telp = no_telp;
    }

    public String getEmail() {
        return email;
    }

    public String getNama_lengkap() {
        return nama_lengkap;
    }

    public String getNo_ktp() {
        return no_ktp;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNo_telp() {
        return no_telp;
    }
}
