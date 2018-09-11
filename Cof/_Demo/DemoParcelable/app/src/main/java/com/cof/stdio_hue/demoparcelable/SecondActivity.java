package com.cof.stdio_hue.demoparcelable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        AccountItem accountItem = intent.getParcelableExtra("Account Item");
        int image = accountItem.getImage();
        String name = accountItem.getName();
        String address = accountItem.getAddress();

        ImageView imageView = findViewById(R.id.image_second_activity);
        imageView.setImageResource(image);

        TextView tvName =  findViewById(R.id.textViewName_second_activity);
        tvName.setText(name);

        TextView tvAddress =  findViewById(R.id.textViewAddress_second_activity);
        tvAddress.setText(address);
    }
}
