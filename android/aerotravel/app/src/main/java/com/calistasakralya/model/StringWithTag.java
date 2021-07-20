package com.calistasakralya.model;

import androidx.annotation.NonNull;

public class StringWithTag {
    public String string;
    public String tag;

    public StringWithTag(String stringPart, String tagPart) {
        this.string = stringPart;
        this.tag = tagPart;
    }

    @NonNull
    @Override
    public String toString() {
        return string;
    }
}
