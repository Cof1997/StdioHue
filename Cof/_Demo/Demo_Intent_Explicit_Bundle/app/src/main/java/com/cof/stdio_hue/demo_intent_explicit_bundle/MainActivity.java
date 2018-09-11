package com.cof.stdio_hue.demo_intent_explicit_bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnGetData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGetData = (Button) findViewById(R.id.buttonGetData);

        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                String[] arrayName = {"Android","IOS","NodeJS","PHP","C++"};
                Student st = new Student("Pham Van Duc", 1997);
                Bundle bundle = new Bundle();

                bundle.putString("Chuoi", "Stdio.Hue");
                bundle.putInt("So", 1000000);
                bundle.putStringArray("Mang", arrayName);
                bundle.putSerializable("DoiTuong" , st);

                intent.putExtra("DuLieu", bundle);

                startActivity(intent);
            }
        });


    }


}
