package com.cof.stdio_hue.contacts.ui.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.cof.stdio_hue.contacts.R;
import com.cof.stdio_hue.contacts.adapter.AdapterListProfile;
import com.cof.stdio_hue.contacts.data.DBManager;
import com.cof.stdio_hue.contacts.model.Profile;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvListProfile;
    private ImageView ivNext;

    private DBManager dbManager;

    private AdapterListProfile adapterListProfile;
    private List<Profile> listProfile = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbManager = new DBManager(this);

        connectView();
        setListProfile();
        setAdapter();
        setLayout();

        ivNext.setClickable(true);
        ivNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,InfoActivity.class);
                startActivity(intent);
            }
        });

        // Click
        adapterListProfile.setOnItemClickListener(new AdapterListProfile.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView,int position) {
                Profile profile = listProfile.get(position);
                Intent intent = new Intent(MainActivity.this,InfoActivity.class);
                intent.putExtra("KEY_PROFILE",profile);
                startActivity(intent);
            }
        });


        // DELETE -------------------------
        adapterListProfile.setOnItemLongClickListener(new AdapterListProfile.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(View itemView,int position) {
                final Profile profile = listProfile.get(position);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Xác Nhận Xóa");
                builder.setMessage("Bạn Có Muốn Xóa Không?");
                builder.setCancelable(false);
                builder.setPositiveButton("Đéo",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface,int i) {
                        Toast.makeText(MainActivity.this,"Không Xóa Được!",Toast.LENGTH_SHORT).show();
                        dialogInterface.dismiss();
                    }
                });
                builder.setNegativeButton("OK",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface,int i) {

                        int k = dbManager.deleteProfile(profile);

                        getListProfile();

                        if (k > 0)
                            Toast.makeText(MainActivity.this,"Đã Xóa!",Toast.LENGTH_SHORT).show();
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getListProfile();
    }

    private void connectView(){
        rvListProfile = findViewById(R.id.rv_profile_list);
        ivNext = findViewById(R.id.iv_next);
    }

    private void setAdapter(){
       adapterListProfile = new AdapterListProfile(listProfile);
       rvListProfile.setAdapter(adapterListProfile);
    }

    private void getListProfile(){
        listProfile.clear();
        listProfile.addAll(dbManager.getAllProfile());
        adapterListProfile.notifyDataSetChanged();
    }

    private void setLayout(){
        rvListProfile.setLayoutManager(new LinearLayoutManager(this));
    }
    private void setListProfile(){
        dbManager.getAllProfile();
    }
}

