package com.cof.stdio_hue.demo_login;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FragmentA extends Fragment {

    RecyclerView mRecyclerView;
    CustomAdapter adapter;
    ArrayList listItem = new ArrayList();
    OnClickItem onClickItem;

    public FragmentA() {
        // Required empty public constructor
    }

    public void setOnClickItem(OnClickItem onClickItem) {
        this.onClickItem = onClickItem;
    }

    public static FragmentA getInstance(){
        return new FragmentA();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        mRecyclerView = view.findViewById(R.id.rv_FragmentA);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        setup();
        adapter = new CustomAdapter(listItem, getContext(), onClickItem);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(manager);
        return view;
    }

    private void setup() {
        for(int i=0; i<10; i++){
            listItem.add(i);
        }
    }
}