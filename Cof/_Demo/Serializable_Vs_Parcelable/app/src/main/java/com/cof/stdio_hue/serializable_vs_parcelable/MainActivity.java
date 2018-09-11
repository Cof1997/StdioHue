package com.cof.stdio_hue.serializable_vs_parcelable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void NextSerializable(View view){
        Serializable_Class obj_s = new Serializable_Class("SEND BY MAIN_ACTIVITY Serializable");
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("OBJ_S", obj_s);
        intent.putExtra("BUNDLE_S", bundle);
        startActivity(intent);
    }

    public void NextParcelable(View view){
        Parcelable_Class obj_p = new Parcelable_Class("SEND BY MAIN_ACTIVITY Parcelable");
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("OBJ_P", obj_p);
        intent.putExtra("BUNDLE_P", bundle);
        startActivity(intent);
    }
}
