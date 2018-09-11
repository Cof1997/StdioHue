package com.cof.stdio_hue.serializable_vs_parcelable;

import java.io.Serializable;

public class Serializable_Class implements Serializable{
    String name;

    public Serializable_Class(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
