package com.cof.stdio_hue.demo_login;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import android.widget.TextView;

import static com.cof.stdio_hue.demo_login.R.id.tv_UserHome;

public class MainActivity extends AppCompatActivity {
    TextView tvUser;
    ViewPager mViewPager;
    TabLayout mTabLayout;
    FragmentB fragmentB;
    FragmentA fragmentA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connectView();
        // User Name
        Intent intent = getIntent();
        Account account = intent.getParcelableExtra("KEY_TO_MAIN");
        if(account != null)
            tvUser.setText(account.userName);

        fragmentB = FragmentB.getInstance();
        fragmentA = FragmentA.getInstance();

        fragmentA.setOnClickItem(fragmentB.getOnClickItem());
        mViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void connectView() {
        mViewPager = findViewById(R.id.vp_Home);
        mTabLayout = findViewById(R.id.tl_Home);
        tvUser = (TextView) findViewById(tv_UserHome);
    }

    // TAB
    class ViewPagerAdapter extends FragmentPagerAdapter{

        public ViewPagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            switch (position){
                case 0:
                    return fragmentA;
                case 1:
                    return fragmentB;
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
                case 0: return "FRAGMENT A";
                case 1: return "FRAGMENT B";
            }
            return super.getPageTitle(position);
        }
    }
}
