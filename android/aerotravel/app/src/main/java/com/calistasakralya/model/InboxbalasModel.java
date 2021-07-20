package com.calistasakralya.model;

import com.google.gson.annotations.SerializedName;

public class InboxbalasModel {

    @SerializedName("is_admin")
    private final String is_admin;


    @SerializedName("pesan")
    private final String pesan;
    @SerializedName("time")
    private final String time;

    public InboxbalasModel(String is_admin, String pesan, String time) {
        this.is_admin = is_admin;
        this.pesan = pesan;
        this.time = time;
    }


    public String getIs_admin() {
        return is_admin;
    }



    public String getPesan() {
        return pesan;
    }

    public String getTime() {
        return time;
    }
}
