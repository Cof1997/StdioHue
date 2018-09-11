package com.cof.stdio_hue.appdemo.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cof.stdio_hue.appdemo.AccountInterface;
import com.cof.stdio_hue.appdemo.R;
import com.cof.stdio_hue.appdemo.ui.adapter.ViewPagerAdapterAccount;

public class FragmentAccount extends Fragment {

    ViewPager vpAccount;
    TabLayout tlAccount;
    ViewPagerAdapterAccount viewPagerAdapterAccount;

    AccountInterface accountInterface;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            accountInterface = (AccountInterface) context;
        } catch (ClassCastException e) {
            throw new ClassCastException("Error in retrieving data. Please try again");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        vpAccount = view.findViewById(R.id.vp_account);
        tlAccount = view.findViewById(R.id.tl_account);

        viewPagerAdapterAccount = new ViewPagerAdapterAccount(getFragmentManager());
        vpAccount.setAdapter(viewPagerAdapterAccount);
        tlAccount.setupWithViewPager(vpAccount);
        vpAccount.setOffscreenPageLimit(2);

        return view;
    }


}
