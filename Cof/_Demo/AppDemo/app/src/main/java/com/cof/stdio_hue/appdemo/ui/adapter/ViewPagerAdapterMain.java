package com.cof.stdio_hue.appdemo.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.FragmentPagerAdapter;

import com.cof.stdio_hue.appdemo.ui.fragment.FragmentAccount;
import com.cof.stdio_hue.appdemo.ui.fragment.FragmentCart;
import com.cof.stdio_hue.appdemo.ui.fragment.FragmentHome;


public class ViewPagerAdapterMain extends FragmentPagerAdapter{

    public ViewPagerAdapterMain(android.support.v4.app.FragmentManager fm) {
        super(fm);
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FragmentHome();
            case 1:
                return new FragmentCart();
            case 2:
                return new FragmentAccount();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return "Home";
            case 1: return "Cart";
            case 2: return "Account";
        }
        return super.getPageTitle(position);
    }
}