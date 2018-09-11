package com.cof.stdio_hue.demoparcelable;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager = getSupportFragmentManager();

    private ArrayList<AccountItem> mAccountList;

    private RecyclerView mRecyclerView;
    private AccountAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createAccountList();
        buildRecycleView();
    }
    public void createAccountList(){
        mAccountList = new ArrayList<>();
        mAccountList.add(new AccountItem(R.drawable.icons_1, "Mixi Gaming", "Cao Bang"));
        mAccountList.add(new AccountItem(R.drawable.icons_2, "DJ Chip", "Ha Noi"));
        mAccountList.add(new AccountItem(R.drawable.icons_3, "Meo U", "Ha Noi"));
        mAccountList.add(new AccountItem(R.drawable.icons_4, "Funky_M", "TP Ho Chi Minh"));
        mAccountList.add(new AccountItem(R.drawable.icons_5, "Pino_NTK", "Ha Noi"));
        mAccountList.add(new AccountItem(R.drawable.icons_6, "PEW PEW", "TP Hai Phong"));
        mAccountList.add(new AccountItem(R.drawable.icons_aboy, "Rip113", "TP Ho Chi Minh"));
        mAccountList.add(new AccountItem(R.drawable.icons_1, "Snake", "TP Ho Chi Minh"));
        mAccountList.add(new AccountItem(R.drawable.icons_2, "Deftsu", "TP Ho Chi Minh"));
        mAccountList.add(new AccountItem(R.drawable.icons_3, "Killer Nhoc 7", "TP Ho Chi Minh"));
        mAccountList.add(new AccountItem(R.drawable.icons_girl, "Misthy", "Ha Noi"));
        mAccountList.add(new AccountItem(R.drawable.icons_4, "Tik Nao To", "TP Ho Chi Minh"));
        mAccountList.add(new AccountItem(R.drawable.icons_5, "Oc Day Ngu", "TP Ho Chi Minh"));
        mAccountList.add(new AccountItem(R.drawable.icons_6, "Huy Mat Ho", "TP Hue"));
        mAccountList.add(new AccountItem(R.drawable.icons_1, "QTV", "TP Ho Chi Minh"));
        mAccountList.add(new AccountItem(R.drawable.icons_3, "Cof 1997", "Quang Binh"));
    }

    public void buildRecycleView(){

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new AccountAdapter(mAccountList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new AccountAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(int position) {
                AccountItem mAccountItem = mAccountList.get(position);

                //SEND SECOND_ACTIVITY

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("Account Item", mAccountItem);
                startActivity(intent);


                // SEND == NEW_FRAGMENT

                mAccountItem = mAccountList.get(position);
                Bundle bundle = new Bundle();
                bundle.putParcelable("KEY", mAccountItem);

                FragmentAccount fragmentAccount = new FragmentAccount();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                FragmentAccount fragmentAccountDelete = (FragmentAccount) fragmentManager.findFragmentByTag("ADD");
                if(fragmentAccountDelete != null){
                    fragmentTransaction.remove(fragmentAccountDelete);
                }
                fragmentTransaction.replace(R.id.fragment_layout, fragmentAccount, "ADD");
                fragmentTransaction.addToBackStack("ADD");

                fragmentAccount.setArguments(bundle);
                fragmentTransaction.commit();

            }
        });
    }
}
