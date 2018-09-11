package com.cof.stdio_hue.demopassingobject;

import android.app.NotificationManager;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements InterfaceAccount{

    private Account account;

    private TextView tvUserName, tvPassword;
    private FrameLayout flFragmentA, flFragmentB;

    FragmentManager fragmentManager = getSupportFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        connectView();

        Bundle bundle = getIntent().getBundleExtra("KEY_BUNDLE");
        if(bundle != null){
        //    account = bundle.getParcelable("KEY_ACCOUNT");
            account = getIntent().getParcelableExtra("KEY");
            tvUserName.setText(account.getUserName());
            tvPassword.setText(account.getPassword());
        }
    }

    private void connectView(){
        tvUserName = findViewById(R.id.tv_UserName);
        tvPassword = findViewById(R.id.tv_Password);
        flFragmentA = findViewById(R.id.fl_FragmentA);
        flFragmentB = findViewById(R.id.fl_FragmentB);
    }
    public void GETDATA(View view){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putParcelable("KEY_ACCOUNT_SECOND_ACTIVIY", account);
        FragmentA fragmentA = new FragmentA();
        fragmentA.setArguments(bundle);
        fragmentTransaction.replace(R.id.fl_FragmentA, fragmentA, "ADD_A");
        fragmentTransaction.addToBackStack("Add_A");
        fragmentTransaction.commit();

//        getSupportFragmentManager()
//                .beginTransaction()
//                .replace()
//                .addToBackStack()
//                .commit();
    }

    @Override
    public void getAccount(Account account) {
        tvUserName.setText(account.getUserName().toString());
        tvPassword.setText(account.getPassword().toString());
    }
}
