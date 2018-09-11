package com.cof.stdio_hue.serializable_vs_parcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class Parcelable_Class implements Parcelable{
    String name;
    String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parcelable_Class(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(name);
        out.writeString(desc);
    }

    public static final Parcelable.Creator<Parcelable_Class> CREATOR = new Parcelable.Creator<Parcelable_Class>() {
        @Override
        public Parcelable_Class createFromParcel(Parcel in) {
            return new Parcelable_Class(in);
        }
        @Override
        public Parcelable_Class[] newArray(int size) {
            return new Parcelable_Class[size];
        }
    };

    protected Parcelable_Class(Parcel in) {
        this.name = in.readString();
        this.desc = in.readString();
    }
}
