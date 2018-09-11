package com.cof.stdio_hue.democontacts.ui.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cof.stdio_hue.democontacts.R;
import com.cof.stdio_hue.democontacts.adapter.ProfileAdapter;
import com.cof.stdio_hue.democontacts.databinding.ActivityMainBinding;
import com.cof.stdio_hue.democontacts.model.Profile;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private ArrayList<Profile> listProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initRecyclerView();
    }

    private void initRecyclerView(){
        mRecyclerView = findViewById(R.id.rv_Home);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        listProfile = new ArrayList<>();
        for(int i = 1; i <= 10; i++){
            listProfile.add(new Profile(1, "Cof1997", "0962304867", "Aboypham@gmail.com"));
        }

        mAdapter = new ProfileAdapter(listProfile);
        mRecyclerView.setAdapter(mAdapter);
    }
}
