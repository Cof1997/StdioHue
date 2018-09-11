package com.cof.stdio_hue.serializable_vs_parcelable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    TextView tvData_S, tvData_P;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tvData_S = (TextView) findViewById(R.id.textViewData_S);
        tvData_P = (TextView) findViewById(R.id.textViewData_P);

        Intent intent = getIntent();
        Bundle bundle_s = intent.getBundleExtra("BUNDLE_S");
        Bundle bundle_p = intent.getBundleExtra("BUNDLE_P");
        if(bundle_s != null){
            Serializable_Class obj = (Serializable_Class) bundle_s.getSerializable("OBJ_S");
            tvData_S.setText(obj.getName());
        }else{
            tvData_S.setText("NULL");
        }
        if(bundle_p != null){
            Parcelable_Class obj = (Parcelable_Class) bundle_p.getParcelable("OBJ_P");
            tvData_P.setText(obj.getName());
        }else{
            tvData_P.setText("NULL");
        }

    }
}
