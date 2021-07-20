package com.calistasakralya.response;

import com.calistasakralya.model.BookingModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetBooking {
    @SerializedName("status")
    final private String status;

    @SerializedName("result")
    List<BookingModel> listBooking;

    @SerializedName("message")
    final private String message;

    public GetBooking(String status, List<BookingModel> listBooking, String message) {
        this.status = status;
        this.listBooking = listBooking;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public List<BookingModel> getListBooking() {
        return listBooking;
    }

    public String getMessage() {
        return message;
    }
}
