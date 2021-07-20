package com.calistasakralya.response;

import com.calistasakralya.model.JadwalModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetJadwal {

    @SerializedName("result")
    List<JadwalModel> listJadwal;

    @SerializedName("message")
    final private String message;

    public GetJadwal(List<JadwalModel> listJadwal, String message) {
        this.listJadwal = listJadwal;
        this.message = message;
    }

    public List<JadwalModel> getListJadwal() {
        return listJadwal;
    }

    public String getMessage() {
        return message;
    }
}
