package com.calistasakralya.response;

import com.calistasakralya.model.HargaModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetHarga {

    @SerializedName("result")
    List<HargaModel> listHarga;

    @SerializedName("message")
    final private String message;

    public GetHarga(List<HargaModel> listHarga, String message) {
        this.listHarga = listHarga;
        this.message = message;
    }


    public List<HargaModel> getListHarga() {
        return listHarga;
    }

    public String getMessage() {
        return message;
    }
}
