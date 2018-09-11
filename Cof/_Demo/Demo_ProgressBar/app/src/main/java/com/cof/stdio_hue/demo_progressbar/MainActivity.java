package com.cof.stdio_hue.demo_progressbar;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnDownload;
    ProgressBar pbDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDownload = (Button) findViewById(R.id.buttonDownload);
        pbDownload = (ProgressBar) findViewById(R.id.progressBarDownload);
        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CountDownTimer countDownTimer = new CountDownTimer(10000, 100) {
                    @Override
                    public void onTick(long l) {
                        int current = pbDownload.getProgress();
                        if(current >= pbDownload.getMax())
                            current = 0;
                        pbDownload.setProgress(current + 1);
                    }

                    @Override
                    public void onFinish() {
//                        this.start();
                        Toast.makeText(MainActivity.this, "Download Hoàn Tất.", Toast.LENGTH_SHORT).show();
                    }
                };
                countDownTimer.start();
            }
        });


    }
}
