package com.cof.stdio_hue.appdemo.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.cof.stdio_hue.appdemo.R;
import com.cof.stdio_hue.appdemo.model.Account;
import com.cof.stdio_hue.appdemo.ui.activity.SecondActivity;

public class FragmentHome extends Fragment{
    private Account mAccount;
    private TextView tvHome;
    private ImageButton btnNext;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        tvHome = (TextView) view.findViewById(R.id.tv_Home);
        btnNext = (ImageButton) view.findViewById(R.id.btn_Next);

        // NEXT ACTIVITY
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mAccount = getArguments().getParcelable("KEY");
                }catch (Exception tt){
                    mAccount = new Account("null", "null");
                    Toast.makeText(getActivity(), "Account Null", Toast.LENGTH_SHORT).show();
                }
                Bundle bundle = new Bundle();
                bundle.putParcelable("KEY_ACCOUNT", mAccount);
                Intent intent = new Intent(getActivity(), SecondActivity.class);
                intent.putExtra("KEY_BUNDLE", bundle);
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            if(getView()!=null)
                Toast.makeText(getActivity(), "aaaaa", Toast.LENGTH_SHORT).show();
        }
    }
}
