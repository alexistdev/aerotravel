package com.calistasakralya.response;

import com.calistasakralya.model.FasilitasModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetFasilitas {
    @SerializedName("result")
    List<FasilitasModel> fasilitasModelList;

    @SerializedName("message")
    final private String message;

    public GetFasilitas(List<FasilitasModel> fasilitasModelList, String message) {
        this.fasilitasModelList = fasilitasModelList;
        this.message = message;
    }

    public List<FasilitasModel> getFasilitasModelList() {
        return fasilitasModelList;
    }

    public String getMessage() {
        return message;
    }
}
