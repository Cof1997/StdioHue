package com.cof.stdio_hue.appdemo.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.FragmentPagerAdapter;

import com.cof.stdio_hue.appdemo.ui.fragment.FragmentLogin;
import com.cof.stdio_hue.appdemo.ui.fragment.FragmentRegister;


public class ViewPagerAdapterAccount extends FragmentPagerAdapter{

    public ViewPagerAdapterAccount(android.support.v4.app.FragmentManager fm) {
        super(fm);
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FragmentLogin();
            case 1:
                return new FragmentRegister();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return "Login";
            case 1: return "Register";
        }
        return super.getPageTitle(position);
    }
}
