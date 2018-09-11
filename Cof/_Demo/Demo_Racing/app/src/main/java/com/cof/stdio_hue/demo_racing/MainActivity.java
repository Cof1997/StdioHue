package com.cof.stdio_hue.demo_racing;

import android.content.Context;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txtPoint, txtView;
    CheckBox cbOne, cbTwo, cbThree;
    SeekBar sbOne, sbTwo, sbThree;
    ImageButton ibtnPlay;
    int point = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initControls();
        initEvents();
    }

    private void initControls(){
        txtPoint = (TextView) findViewById(R.id.textViewPoint);
        txtView = (TextView) findViewById(R.id.textView);
        cbOne = (CheckBox) findViewById(R.id.checkboxOne);
        cbTwo = (CheckBox) findViewById(R.id.checkboxTwo);
        cbThree = (CheckBox) findViewById(R.id.checkboxThree);
        sbOne = (SeekBar) findViewById(R.id.seekbarOne);
        sbTwo = (SeekBar) findViewById(R.id.seekbarTwo);
        sbThree = (SeekBar) findViewById(R.id.seekbarThree);
        ibtnPlay = (ImageButton) findViewById(R.id.buttonPlay);
    }

    private void initEvents(){

            CheckCheckBox();
            DisEnableSeekBar();
            final CountDownTimer countDownTimer = new CountDownTimer(50000, 50) {

                @Override
                public void onTick(long l) {
                    int speed = 5;
                    Random rd = new Random();
                    int one = rd.nextInt(speed);
                    int two = rd.nextInt(speed);
                    int three = rd.nextInt(speed);


                    if(sbOne.getProgress() >= sbOne.getMax()){
                        this.cancel();
                        Toast.makeText(MainActivity.this, "ONE WIN", Toast.LENGTH_SHORT).show();
                        ibtnPlay.setVisibility(View.VISIBLE);
                        if(cbOne.isChecked()){
                            point += 5;
                            Toast.makeText(MainActivity.this, "You Win!", Toast.LENGTH_SHORT).show();
                        }else{
                            point -= 5;
                            Toast.makeText(MainActivity.this, "You Lose!", Toast.LENGTH_SHORT).show();
                        }
                        EnableCheckBox();
                        txtPoint.setText(point + "");
                        if(point == 0) {
                            point = 20;
                            Toast.makeText(MainActivity.this, "GAME OVER!", Toast.LENGTH_LONG).show();
                            txtView.setText("Over");
                            txtPoint.setText("Chicken\nDinner");
                        }
                    }

                    if(sbTwo.getProgress() >= sbTwo.getMax()){
                        this.cancel();
                        Toast.makeText(MainActivity.this, "TWO WIN", Toast.LENGTH_SHORT).show();
                        ibtnPlay.setVisibility(View.VISIBLE);
                        if(cbTwo.isChecked()){
                            point += 5;
                            Toast.makeText(MainActivity.this, "You Win!", Toast.LENGTH_SHORT).show();
                        }else{
                            point -= 5;
                            Toast.makeText(MainActivity.this, "You Lose!", Toast.LENGTH_SHORT).show();
                        }
                        EnableCheckBox();
                        txtPoint.setText(point + "");
                        if(point == 0) {
                            point = 20;
                            Toast.makeText(MainActivity.this, "GAME OVER!", Toast.LENGTH_LONG).show();
                            txtView.setText("Over");
                            txtPoint.setText("Chicken\nDinner");
                        }
                    }
                    if(sbThree.getProgress() >= sbThree.getMax()){
                        this.cancel();
                        Toast.makeText(MainActivity.this, "THREE WIN", Toast.LENGTH_SHORT).show();
                        ibtnPlay.setVisibility(View.VISIBLE);
                        if(cbThree.isChecked()){
                            point += 5;
                            Toast.makeText(MainActivity.this, "You Win!", Toast.LENGTH_SHORT).show();
                        }else{
                            point -= 5;
                            Toast.makeText(MainActivity.this, "You Lose!", Toast.LENGTH_SHORT).show();
                        }
                        EnableCheckBox();
                        txtPoint.setText(point + "");
                        if(point == 0) {
                            point = 20;
                            Toast.makeText(MainActivity.this, "GAME OVER!", Toast.LENGTH_LONG).show();
                            txtView.setText("Over");
                            txtPoint.setText("Chicken\nDinner");
                        }
                    }
                    sbOne.setProgress(sbOne.getProgress() + one);
                    sbTwo.setProgress(sbTwo.getProgress() + two);
                    sbThree.setProgress(sbThree.getProgress() + three);

                }

                @Override
                public void onFinish() {

                }
            };

            ibtnPlay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    txtView.setText("Point");
                    txtPoint.setText(point + "");
                    if(cbOne.isChecked() || cbTwo.isChecked() || cbThree.isChecked()){
                        sbOne.setProgress(0);
                        sbTwo.setProgress(0);
                        sbThree.setProgress(0);
                        ibtnPlay.setVisibility(View.INVISIBLE);
                        countDownTimer.start();
                        DisEnableCheckBox();
                    }else{
                        Toast.makeText(MainActivity.this, "Xin vui lòng đặt cược.", Toast.LENGTH_SHORT).show();
                    }

                }
            });
    }

    private void EnableCheckBox(){
     cbOne.setEnabled(true);
     cbTwo.setEnabled(true);
     cbThree.setEnabled(true);
    }

    private void DisEnableSeekBar(){
        sbOne.setEnabled(false);
        sbTwo.setEnabled(false);
        sbThree.setEnabled(false);
    }

    private void DisEnableCheckBox(){
        cbOne.setEnabled(false);
        cbTwo.setEnabled(false);
        cbThree.setEnabled(false);
    }

    private void CheckCheckBox(){
        cbOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cbTwo.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });

        cbTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cbOne.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });

        cbThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cbOne.setChecked(false);
                    cbTwo.setChecked(false);
                }
            }
        });
    }

}
