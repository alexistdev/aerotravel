package com.calistasakralya.model;

import com.google.gson.annotations.SerializedName;

public class JadwalModel {

    @SerializedName("waktu")
    private final String waktu;
    @SerializedName("keterangan")
    private final String keterangan;

    public JadwalModel(String waktu, String keterangan) {
        this.waktu = waktu;
        this.keterangan = keterangan;
    }


    public String getWaktu() {
        return waktu;
    }

    public String getKeterangan() {
        return keterangan;
    }
}
