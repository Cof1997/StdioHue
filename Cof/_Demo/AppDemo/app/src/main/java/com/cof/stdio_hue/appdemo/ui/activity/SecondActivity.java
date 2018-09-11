package com.cof.stdio_hue.appdemo.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.cof.stdio_hue.appdemo.R;
import com.cof.stdio_hue.appdemo.model.Account;

public class SecondActivity extends AppCompatActivity {

    private TextView tvUserName, tvPassword;
    private Account mAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvUserName = (TextView) findViewById(R.id.tv_UserName);
        tvPassword = (TextView) findViewById(R.id.tv_Password);

        Bundle bundle = getIntent().getBundleExtra("KEY_BUNDLE");
        mAccount = bundle.getParcelable("KEY_ACCOUNT");
        tvUserName.setText(mAccount.getUserName());
        tvPassword.setText(mAccount.getPassWord());
    }
}
