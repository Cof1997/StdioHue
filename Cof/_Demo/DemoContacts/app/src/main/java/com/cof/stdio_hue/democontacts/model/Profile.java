package com.cof.stdio_hue.democontacts.model;

/**
 * Created by Cof on 04/09/2018.
 */
public class Profile {
    private int mID;
    private String mName;
    private String mPhoneNumber;
    private String mEmail;

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

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public Profile(int mID, String mName, String mPhoneNumber, String mEmail) {
        this.mID = mID;
        this.mName = mName;
        this.mPhoneNumber = mPhoneNumber;
        this.mEmail = mEmail;
    }

}
