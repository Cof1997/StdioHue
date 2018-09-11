package com.cof.stdio_hue.demopassingobject;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cof.stdio_hue.demopassingobject.databinding.ActivityMainBinding;
import com.cof.stdio_hue.demopassingobject.event.mainEH;

public class MainActivity extends AppCompatActivity implements mainEH {
    private Account account;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    @Override
    public void onNextClick() {
        if(!binding.etUserName.getText().toString().equals("")  && !binding.etPassword.getText().toString().equals("")){
            account  = new Account(binding.etUserName.getText().toString(), binding.etPassword.getText().toString());
            Bundle bundle = new Bundle();
            bundle.putParcelable("KEY_ACCOUNT", account);
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);

            intent.putExtra("KEY", account);
            intent.putExtra("KEY_BUNDLE", bundle);
            startActivity(intent);
        }else{
            Toast.makeText(this, "EditText null", Toast.LENGTH_SHORT).show();
        }
    }
}
