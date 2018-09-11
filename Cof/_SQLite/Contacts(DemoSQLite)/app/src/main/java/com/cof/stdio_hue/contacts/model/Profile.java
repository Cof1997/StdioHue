package com.cof.stdio_hue.contacts.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

/**
 * Created by Cof on 01/09/2018.
 */
public class Profile implements Parcelable{
    private int mID;
    private String mName;
    private String mPhoneNumber;
    private String mAddress;
    private String mEmail;

    public Profile() {
    }

    public Profile(int mID, String mName, String mPhoneNumber, String mAddress, String mEmail) {
        this.mID = mID;
        this.mName = mName;
        this.mPhoneNumber = mPhoneNumber;
        this.mAddress = mAddress;
        this.mEmail = mEmail;
    }

    public Profile(String mName, String mPhoneNumber, String mAddress, String mEmail) {
        this.mName = mName;
        this.mPhoneNumber = mPhoneNumber;
        this.mAddress = mAddress;
        this.mEmail = mEmail;
    }


    protected Profile(Parcel in) {
        mID = in.readInt();
        mName = in.readString();
        mPhoneNumber = in.readString();
        mAddress = in.readString();
        mEmail = in.readString();
    }

    public static final Creator<Profile> CREATOR = new Creator<Profile>() {
        @Override
        public Profile createFromParcel(Parcel in) {
            return new Profile(in);
        }

        @Override
        public Profile[] newArray(int size) {
            return new Profile[size];
        }
    };

    public int getmID() {
        return mID;
    }

    public void setmID(int mID) {
        this.mID = mID;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPhoneNumber() {
        return mPhoneNumber;
    }

    public void setmPhoneNumber(String mPhoneNumber) {
        this.mPhoneNumber = mPhoneNumber;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mID);
        dest.writeString(mName);
        dest.writeString(mPhoneNumber);
        dest.writeString(mAddress);
        dest.writeString(mEmail);
    }
}
