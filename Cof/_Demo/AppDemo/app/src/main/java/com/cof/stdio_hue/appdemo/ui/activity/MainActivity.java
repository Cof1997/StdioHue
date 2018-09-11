package com.cof.stdio_hue.appdemo.ui.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.cof.stdio_hue.appdemo.R;
import com.cof.stdio_hue.appdemo.model.Account;
import com.cof.stdio_hue.appdemo.ui.adapter.ViewPagerAdapterMain;
import com.cof.stdio_hue.appdemo.ui.fragment.FragmentHome;
import com.cof.stdio_hue.appdemo.AccountInterface;


public class MainActivity extends AppCompatActivity implements AccountInterface {
    private Account mAccount;
    private ViewPager vpMain;
    private TabLayout tlMain;
    private ViewPagerAdapterMain viewPagerAdapterMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolBar);
//        setSupportActionBar(toolbar);

        vpMain = findViewById(R.id.vp_Main);
        tlMain = findViewById(R.id.tl_Main);

        viewPagerAdapterMain = new ViewPagerAdapterMain(getSupportFragmentManager());
        vpMain.setAdapter(viewPagerAdapterMain);
        tlMain.setupWithViewPager(vpMain);
        vpMain.setOffscreenPageLimit(1);       // Set 3 OnscreenPage
    }

    @Override
    public void SendString(String data) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void SendObject(Account account) {
        // SEND OBJ -> FRAGMENT_HOME ???????????????
        mAccount = account;
        Bundle bundle = new Bundle();
        bundle.putParcelable("KEY", mAccount);
        FragmentHome fragmentHome = new FragmentHome();
        fragmentHome.setArguments(bundle);
        // Notification_Login("Login Success", "Account: " + mAccount.getUserName());
    }

    public void Notification_Login(String title, String text){
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 1, intent,0);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification.Builder notifyBuilder = new Notification.Builder(this);
        notifyBuilder.setContentTitle(title);
        notifyBuilder.setContentText(text);
        notifyBuilder.setSmallIcon(R.drawable.notification);
        notifyBuilder.setAutoCancel(true);
        notifyBuilder.setContentIntent(pIntent);
        notificationManager.notify(1, notifyBuilder.build());
    }
}
