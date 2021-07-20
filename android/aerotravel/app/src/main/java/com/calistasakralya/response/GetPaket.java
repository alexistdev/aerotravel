package com.calistasakralya.response;

import com.calistasakralya.model.PaketModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetPaket {
    @SerializedName("result")
    final private List<PaketModel> listPaketModel;

    public GetPaket(List<PaketModel> listPaketModel) {
        this.listPaketModel = listPaketModel;
    }

    public List<PaketModel> getListPaketModel() {
        return listPaketModel;
    }
}
