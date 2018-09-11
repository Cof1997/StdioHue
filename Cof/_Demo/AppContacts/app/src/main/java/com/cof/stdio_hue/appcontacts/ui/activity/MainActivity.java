package com.cof.stdio_hue.appcontacts.ui.activity;


import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.cof.stdio_hue.appcontacts.R;
import com.cof.stdio_hue.appcontacts.adapter.MyAdapter;
import com.cof.stdio_hue.appcontacts.databinding.ActivityMainBinding;
import com.cof.stdio_hue.appcontacts.model.Profile;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private MyAdapter myAdapter;
    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setData();
        mainBinding.rvHome.setLayoutManager(new LinearLayoutManager(this));
        mainBinding.rvHome.setAdapter(myAdapter);
    }
    private void setData(){
        ArrayList<Profile> profileList = new ArrayList<>();
        for(int i = 1; i <= 10; i++){
            profileList.add(new Profile(i, "Duc", "0123456789"));
        }
        myAdapter = new MyAdapter(profileList);
    }
}
