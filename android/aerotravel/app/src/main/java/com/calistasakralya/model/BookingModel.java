package com.calistasakralya.model;

import com.google.gson.annotations.SerializedName;

public class BookingModel {
    @SerializedName("kode_booking")
    private final String kode_booking;
    @SerializedName("tanggal_wisata")
    private final String tanggal_wisata;
    @SerializedName("total_harga")
    private final String total_harga;
    @SerializedName("status")
    private final String status;
    @SerializedName("judul_paket")
    private final String judul_paket;

    public BookingModel(String kode_booking, String tanggal_wisata, String total_harga, String status, String judul_paket) {
        this.kode_booking = kode_booking;
        this.tanggal_wisata = tanggal_wisata;
        this.total_harga = total_harga;
        this.status = status;
        this.judul_paket = judul_paket;
    }

    public String getKode_booking() {
        return kode_booking;
    }

    public String getTanggal_wisata() {
        return tanggal_wisata;
    }

    public String getTotal_harga() {
        return total_harga;
    }

    public String getStatus() {
        return status;
    }

    public String getJudul_paket() {
        return judul_paket;
    }
}
