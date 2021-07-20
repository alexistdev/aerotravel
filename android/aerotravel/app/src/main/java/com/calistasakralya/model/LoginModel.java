package com.calistasakralya.model;

import com.google.gson.annotations.SerializedName;

public class LoginModel {
    @SerializedName("id_user")
    private final String idUser;
    @SerializedName("token")
    private final String token;

    public LoginModel(String idUser, String token) {
        this.idUser = idUser;
        this.token = token;
    }

    public String getIdUser() {
        return idUser;
    }

    public String getToken() {
        return token;
    }

}
