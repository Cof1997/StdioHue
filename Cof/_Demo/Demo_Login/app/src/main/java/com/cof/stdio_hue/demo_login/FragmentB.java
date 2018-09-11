package com.cof.stdio_hue.demo_login;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentB extends Fragment implements OnClickItem {
    TextView tvFragmentB;
    OnClickItem onClickItem = this;

    public FragmentB() {
        // Required empty public constructor
    }

    public OnClickItem getOnClickItem() {
        return onClickItem;
    }

    public static FragmentB getInstance(){
        return new FragmentB();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        tvFragmentB = view.findViewById(R.id.tv_FragmentB);
        return view;
    }


    @Override
    public void onClickItem(String text) {
        tvFragmentB.setText(text);
    }
}