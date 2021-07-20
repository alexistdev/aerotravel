package com.calistasakralya.response;

import com.calistasakralya.model.DestinasiModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetDestinasi {

    @SerializedName("result")
    List<DestinasiModel> listDestinasi;

    @SerializedName("message")
    final private String message;

    public GetDestinasi(List<DestinasiModel> listDestinasi, String message) {
        this.listDestinasi = listDestinasi;
        this.message = message;
    }

    public List<DestinasiModel> getListDestinasi() {
        return listDestinasi;
    }

    public String getMessage() {
        return message;
    }
}
