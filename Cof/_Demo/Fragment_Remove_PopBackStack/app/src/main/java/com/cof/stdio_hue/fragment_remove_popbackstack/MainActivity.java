package com.cof.stdio_hue.fragment_remove_popbackstack;

import android.app.ActionBar;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(MainActivity.this, "onCreate Main", Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void AddA(View view){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.layout_fragment, new FragmentA(), "ADD_A");
        fragmentTransaction.addToBackStack("Add_A");
        fragmentTransaction.commit();
    }

    public void AddB(View view){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.layout_fragment, new FragmentB(), "ADD_B");
        fragmentTransaction.addToBackStack("Add_B");
        fragmentTransaction.commit();
    }
    public void AddC(View view){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.layout_fragment, new FragmentC(), "ADD_C");
        fragmentTransaction.addToBackStack("Add_C");
        fragmentTransaction.commit();
    }
    public void RemoveA(View view){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = (FragmentA) fragmentManager.findFragmentByTag("ADD_A");
        if(fragmentA != null){
            fragmentTransaction.remove(fragmentA);
        }else{
            Toast.makeText(MainActivity.this, "Fragment_A Không Tồn Tại.", Toast.LENGTH_SHORT).show();
        }
        fragmentTransaction.commit();
    }
    public void RemoveB(View view){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = (FragmentB) fragmentManager.findFragmentByTag("ADD_B");
        if(fragmentB != null){
            fragmentTransaction.remove(fragmentB);
        }else{
            Toast.makeText(MainActivity.this, "Fragment_B Không Tồn Tại.", Toast.LENGTH_SHORT).show();
        }
        fragmentTransaction.commit();
    }
    public void RemoveC(View view){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentC fragmentC = (FragmentC) fragmentManager.findFragmentByTag("ADD_C");
        if(fragmentC != null){
            fragmentTransaction.remove(fragmentC);
        }else{
            Toast.makeText(MainActivity.this, "Fragment_C Không Tồn Tại.", Toast.LENGTH_SHORT).show();
        }
        fragmentTransaction.commit();
    }
    public void Back(View view){
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount() > 1){
            getSupportFragmentManager().popBackStack();
        }else{
            super.onBackPressed();
        }

    }

    @Override
    protected void onStart() {
        Toast.makeText(MainActivity.this, "onStart Main", Toast.LENGTH_SHORT).show();
        super.onStart();
    }

    @Override
    protected void onStop() {
        Toast.makeText(MainActivity.this, "onStop Main", Toast.LENGTH_SHORT).show();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(MainActivity.this, "onDestroy Main", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Toast.makeText(MainActivity.this, "onPause Main", Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    @Override
    protected void onResume() {
        Toast.makeText(MainActivity.this, "onResume Main", Toast.LENGTH_SHORT).show();
        super.onResume();
    }

    @Override
    protected void onRestart() {
        Toast.makeText(MainActivity.this, "onRestart Main", Toast.LENGTH_SHORT).show();
        super.onRestart();
    }
}
