package com.calistasakralya.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DestinasiModel implements Serializable {
    @SerializedName("id_destinasi")
    private final String id_destinasi;
    @SerializedName("judul_destinasi")
    private final String judul_destinasi;
    @SerializedName("deskripsi")
    private final String deskripsi;
    @SerializedName("gambar1")
    private final String gambar1;
    @SerializedName("gambar2")
    private final String gambar2;
    @SerializedName("gambar3")
    private final String gambar3;
    @SerializedName("gambar4")
    private final String gambar4;
    @SerializedName("gambar5")
    private final String gambar5;
    @SerializedName("like_destinasi")
    private final String like_destinasi;

    public DestinasiModel(String id_destinasi, String judul_destinasi, String deskripsi, String gambar1, String gambar2, String gambar3, String gambar4, String gambar5, String like_destinasi) {
        this.id_destinasi = id_destinasi;
        this.judul_destinasi = judul_destinasi;
        this.deskripsi = deskripsi;
        this.gambar1 = gambar1;
        this.gambar2 = gambar2;
        this.gambar3 = gambar3;
        this.gambar4 = gambar4;
        this.gambar5 = gambar5;
        this.like_destinasi = like_destinasi;
    }

    public String getId_destinasi() {
        return id_destinasi;
    }

    public String getJudul_destinasi() {
        return judul_destinasi;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getGambar1() {
        return gambar1;
    }

    public String getGambar2() {
        return gambar2;
    }

    public String getGambar3() {
        return gambar3;
    }

    public String getGambar4() {
        return gambar4;
    }

    public String getGambar5() {
        return gambar5;
    }

    public String getLike_destinasi() {
        return like_destinasi;
    }
}
