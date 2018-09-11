package com.cof.stdio_hue.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageButton ibtnBack, ibtnNext;
    TextView txtMain;
    Fragment1 fragment1;
    Fragment2 fragment2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectView();
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        initFragment(fragment1);
        ibtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(fragment2);
            }
        });
        ibtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               backFragment();
            }
        });
    }

    private void connectView(){
        txtMain = (TextView) findViewById(R.id.textViewMain);
        ibtnNext = (ImageButton) findViewById(R.id.imageButtonNext);
        ibtnBack = (ImageButton) findViewById(R.id.imageButtonBack);
    }

    private void initFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_layout_main, fragment);
        fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());        // Back Fragment.
        fragmentTransaction.commit();
    }
    private void backFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentManager.popBackStack();
        fragmentTransaction.commit();
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //----------------------------- SEND DATA
        Bundle bundle = new Bundle();
        bundle.putString("Data_Send", "SEND BY MAIN ACTIVITY");
        fragment.setArguments(bundle);
        //-----------------------------
        fragmentTransaction.replace(R.id.fragment_layout_main, fragment);
        fragmentTransaction.addToBackStack("Add");
        fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());        // Back Fragment.
        fragmentTransaction.commit();
    }

//    @Override
//    public void onBackPressed() {
//        if(getSupportFragmentManager().getBackStackEntryCount() > 0){
//            getSupportFragmentManager().popBackStack();
//        }else{
//            super.onBackPressed();
//        }
//
//    }
}
