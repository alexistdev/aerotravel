package com.calistasakralya.response;

import com.calistasakralya.model.InboxModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetInbox {

    @SerializedName("result")
    List<InboxModel> listInbox;

    @SerializedName("message")
    final private String message;

    public GetInbox(List<InboxModel> listInbox, String message) {
        this.listInbox = listInbox;
        this.message = message;
    }

    public List<InboxModel> getListInbox() {
        return listInbox;
    }

    public String getMessage() {
        return message;
    }
}
