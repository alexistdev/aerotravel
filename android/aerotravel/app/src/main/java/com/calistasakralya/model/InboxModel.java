package com.calistasakralya.model;

import com.google.gson.annotations.SerializedName;

public class InboxModel {
    @SerializedName("judul")
    private final String judul;
    @SerializedName("pesan")
    private final String pesan;
    @SerializedName("key_token")
    private final String key_token;
    @SerializedName("time")
    private final String time;
    @SerializedName("status_pesan")
    private final String status;

    public InboxModel(String judul, String pesan, String key_token, String time, String status) {
        this.judul = judul;
        this.pesan = pesan;
        this.key_token = key_token;
        this.time = time;
        this.status = status;
    }

    public String getJudul() {
        return judul;
    }

    public String getPesan() {
        return pesan;
    }

    public String getKey_token() {
        return key_token;
    }

    public String getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }
}
