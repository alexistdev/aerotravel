package com.calistasakralya.response;

import com.calistasakralya.model.InboxModel;
import com.calistasakralya.model.InboxbalasModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetBalas {
    @SerializedName("result")
    List<InboxbalasModel> listInbox;

    @SerializedName("message")
    final private String message;

    public GetBalas(List<InboxbalasModel> listInbox, String message) {
        this.listInbox = listInbox;
        this.message = message;
    }

    public List<InboxbalasModel> getListInbox() {
        return listInbox;
    }

    public String getMessage() {
        return message;
    }
}
