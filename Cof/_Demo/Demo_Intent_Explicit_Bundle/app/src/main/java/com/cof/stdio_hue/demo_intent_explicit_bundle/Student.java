package com.cof.stdio_hue.demo_intent_explicit_bundle;

import java.io.Serializable;

public class Student implements Serializable{
    private String hoTen;
    private int Tuoi;

    public Student(String ten, int tuoi){
        hoTen = ten;
        Tuoi = tuoi;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getTuoi() {
        return Tuoi;
    }

    public void setTuoi(int tuoi) {
        Tuoi = tuoi;
    }
}
