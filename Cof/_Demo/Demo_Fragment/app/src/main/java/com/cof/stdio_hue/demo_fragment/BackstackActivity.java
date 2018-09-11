package com.cof.stdio_hue.demo_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class BackstackActivity extends AppCompatActivity {
    Button btnNext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backstack);

        btnNext = (Button) findViewById(R.id.buttonNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
//                replaceFragmentContent(new Fragment2());
            addFragment(new Fragment2());
        }
    });

    initFragment();
}


    private void initFragment() {

        Fragment1 firstFragment = new Fragment1();

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction ft = fragmentManager.beginTransaction();

        ft.replace(R.id.container_body, firstFragment);

        ft.commit();

    }

    protected void addFragment(Fragment fragment) {

        FragmentManager frmm = getSupportFragmentManager();

        FragmentTransaction ft = frmm.beginTransaction();

        ft.add(R.id.container_body, fragment);

        ft.addToBackStack(fragment.getClass().getSimpleName());     // Back


        ft.commit();

    }


}