package com.calistasakralya.model;

import com.google.gson.annotations.SerializedName;

public class HargaModel {

    @SerializedName("keterangan")
    final private String keterangan;
    @SerializedName("harga_standar")
    final private String harga_standar;

    public HargaModel(String keterangan, String harga_standar) {
        this.keterangan = keterangan;
        this.harga_standar = harga_standar;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public String getHarga_standar() {
        return harga_standar;
    }
}
