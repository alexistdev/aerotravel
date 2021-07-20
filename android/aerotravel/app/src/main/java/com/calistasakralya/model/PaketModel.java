package com.calistasakralya.model;

import com.google.gson.annotations.SerializedName;

public class PaketModel {
    @SerializedName("id_paket")
    final private String id_paket;
    @SerializedName("judul_paket")
    final private String judul_paket;

    public PaketModel(String id_paket, String judul_paket) {
        this.id_paket = id_paket;
        this.judul_paket = judul_paket;
    }

    public String getId_paket() {
        return id_paket;
    }

    public String getJudul_paket() {
        return judul_paket;
    }
}
