package com.cof.stdio_hue.appcontacts.model;

/**
 * Created by Cof on 05/09/2018.
 */
public class Profile {

    private int mID;
    private String mName;
    private String mPhoneNumber;

    public Profile(int mID,String mName,String mPhoneNumber) {
        this.mID = mID;
        this.mName = mName;
        this.mPhoneNumber = mPhoneNumber;
    }

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

    public void setmPhoneNumberl(String mPhoneNumber) {
        this.mPhoneNumber = mPhoneNumber;
    }
}
