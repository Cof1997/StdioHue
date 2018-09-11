package com.cof.stdio_hue.demoparcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class AccountItem implements Parcelable{
    private int mImage;
    private String mName;
    private String mAddress;

    public AccountItem(int mImage, String mName, String mAddress) {
        this.mImage = mImage;
        this.mName = mName;
        this.mAddress = mAddress;
    }

    protected AccountItem(Parcel in) {
        mImage = in.readInt();
        mName = in.readString();
        mAddress = in.readString();
    }

    public static final Creator<AccountItem> CREATOR = new Creator<AccountItem>() {
        @Override
        public AccountItem createFromParcel(Parcel in) {
            return new AccountItem(in);
        }

        @Override
        public AccountItem[] newArray(int size) {
            return new AccountItem[size];
        }
    };

    public int getImage() {
        return mImage;
    }

    public void setImage(int Image) {
        this.mImage = Image;
    }

    public String getName() {
        return mName;
    }

    public void setName(String Name) {
        this.mName = Name;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String Address) {
        this.mAddress = Address;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mImage);
        dest.writeString(mName);
        dest.writeString(mAddress);
    }
}
