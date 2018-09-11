package com.cof.stdio_hue.send_data;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SEND_HOME(View view){
        FragmentA fragmentA = (FragmentA) getSupportFragmentManager().findFragmentById(R.id.fragment_a);
        fragmentA.etA.setText("Change By Home");
    }

}
