package com.cof.stdio_hue.databinding.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;

import com.cof.stdio_hue.databinding.BR;

/**
 * Created by Cof on 10/09/2018.
 */

public class User extends BaseObservable{
    private String userName;
    private String email;
    private String profileImage;

    public static ObservableField<Long> numberOfLike = new ObservableField<>();
    public static ObservableField<Long> numberOfShare = new ObservableField<>();

    public User() {
    }

    @Bindable
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        notifyPropertyChanged(BR.userName);
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }

    @Bindable
    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
        notifyPropertyChanged(BR.profileImage);
    }

    public ObservableField<Long> getNumberOfLike() {
        return numberOfLike;
    }

    public ObservableField<Long> getNumberOfShare() {
        return numberOfShare;
    }

}
