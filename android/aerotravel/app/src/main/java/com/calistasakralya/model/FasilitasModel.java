package com.calistasakralya.model;

import com.google.gson.annotations.SerializedName;

public class FasilitasModel {
    @SerializedName("nama_fasilitas")
    private final String nama_fasilitas;

    public FasilitasModel(String nama_fasilitas) {
        this.nama_fasilitas = nama_fasilitas;
    }

    public String getNama_fasilitas() {
        return nama_fasilitas;
    }
}
