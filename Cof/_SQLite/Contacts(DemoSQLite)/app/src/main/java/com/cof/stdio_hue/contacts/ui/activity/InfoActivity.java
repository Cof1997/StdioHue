package com.cof.stdio_hue.contacts.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.cof.stdio_hue.contacts.R;
import com.cof.stdio_hue.contacts.data.DBManager;
import com.cof.stdio_hue.contacts.model.Profile;

public class InfoActivity extends AppCompatActivity {
    private EditText etName;
    private EditText etPhoneNumber;
    private EditText etAddress;
    private EditText etEmail;
    private Button btnAdd;
    private Button btnUpdate;
    private ImageView ivBack;
    private Profile profile;
    private DBManager dbManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        dbManager = new DBManager(this);
        profile = getIntent().getParcelableExtra("KEY_PROFILE");

        connectView();
        setEnabledButton(profile);
        setEditText(profile);

        ivBack.setClickable(true);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InfoActivity.super.finish();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Profile mProfile = new Profile(etName.getText().toString(), etPhoneNumber.getText().toString(), etAddress.getText().toString(), etEmail.getText().toString());
                if(mProfile != null && dbManager != null){
                    dbManager.addProfile(mProfile);
                    InfoActivity.super.finish();
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Profile mProfile = new Profile(profile.getmID(), etName.getText().toString(), etPhoneNumber.getText().toString(), etAddress.getText().toString(), etEmail.getText().toString());
                if(mProfile != null && dbManager != null) {
                    if (dbManager.updateProfile(mProfile) > 0){
                        Toast.makeText(InfoActivity.this,"Update Success",Toast.LENGTH_SHORT).show();
                        InfoActivity.super.finish();
                    }
                    else
                        Toast.makeText(InfoActivity.this, "Update Fail", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void connectView(){
        etName = (EditText) findViewById(R.id.et_name);
        etPhoneNumber = (EditText) findViewById(R.id.et_phonenumber);
        etAddress = (EditText) findViewById(R.id.et_address);
        etEmail = (EditText) findViewById(R.id.et_email);
        btnAdd = (Button) findViewById(R.id.btn_add);
        btnUpdate = (Button) findViewById(R.id.btn_update);
        ivBack = (ImageView) findViewById(R.id.iv_back);
    }

    private void setEditText(Profile profile){
        if(profile != null){
            etName.setText(profile.getmName().toString());
            etPhoneNumber.setText(profile.getmPhoneNumber().toString());
            etAddress.setText(profile.getmAddress().toString());
            etEmail.setText(profile.getmEmail().toString());
        }
    }

    private void setEnabledButton(Profile profile){
        if(profile != null){
            btnAdd.setEnabled(false);
            btnUpdate.setEnabled(true);
        }
        else{
            btnAdd.setEnabled(true);
            btnUpdate.setEnabled(false);
        }
    }
}
