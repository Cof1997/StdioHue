package com.cof.stdio_hue.demopassingobject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentA extends Fragment {
    private Account account;
    private EditText etUserName, etPassword;
    private Button btnONE;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        connectView(view);
        account = getArguments().getParcelable("KEY_ACCOUNT_SECOND_ACTIVIY");
        if(account != null){
            etUserName.setText(account.getUserName().toString());
            etPassword.setText(account.getPassword().toString());
        }

        btnONE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Account mAccount = new Account(etUserName.getText().toString(), etPassword.getText().toString());
                Bundle bundle = new Bundle();
                bundle.putParcelable("KEY_ACCOUNT_FRAGMENT_A", mAccount);
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                FragmentB fragmentB = new FragmentB();
                fragmentB.setArguments(bundle);
                fragmentTransaction.replace(R.id.fl_FragmentB, fragmentB, "ADD_B");
                fragmentTransaction.addToBackStack("Add_B");
                fragmentTransaction.commit();
            }
        });
        return view;
    }

    private void connectView(View view){
        etUserName = view.findViewById(R.id.et_UserNameA);
        etPassword = view.findViewById(R.id.et_PasswordA);
        btnONE = view.findViewById(R.id.btn_FragmentA);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
