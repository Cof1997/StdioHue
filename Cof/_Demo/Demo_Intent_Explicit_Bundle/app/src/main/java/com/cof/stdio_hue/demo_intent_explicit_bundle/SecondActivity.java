package com.cof.stdio_hue.demo_intent_explicit_bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView txtSecond;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        txtSecond = (TextView) findViewById(R.id.textViewSecond);
        Intent intent = getIntent();

        Bundle bundle = intent.getBundleExtra("DuLieu");
        if(bundle != null){
            String Chuoi = bundle.getString("Chuoi");
            int So = bundle.getInt("So", 0000);
            String[] arr = bundle.getStringArray("Mang");
            Student student = (Student) bundle.getSerializable("DoiTuong");

            txtSecond.setText(Chuoi + "\n" + So + "\n" + arr[3] + "\n" + student.getHoTen() + "\n" + student.getTuoi());

        }
    }
}
