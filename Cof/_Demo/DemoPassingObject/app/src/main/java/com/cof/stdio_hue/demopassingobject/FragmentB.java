package com.cof.stdio_hue.demopassingobject;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentB extends Fragment {

    private InterfaceAccount interfaceAccount;
    private Account account;
    private EditText etUserName, etPassword;
    private Button btnTWO;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            interfaceAccount = (InterfaceAccount) context;
        } catch (ClassCastException e) {
            throw new ClassCastException("Error Account Interface");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);

        connectView(view);
        account = getArguments().getParcelable("KEY_ACCOUNT_FRAGMENT_A");
        if(account != null){
            etUserName.setText(account.getUserName().toString());
            etPassword.setText(account.getPassword().toString());
        }
        btnTWO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Account mAccount = new Account(etUserName.getText().toString(), etPassword.getText().toString());
                interfaceAccount.getAccount(mAccount);
            }
        });
        return view;
    }

    private void connectView(View view){
        etUserName = view.findViewById(R.id.et_UserNameB);
        etPassword = view.findViewById(R.id.et_PasswordB);
        btnTWO = view.findViewById(R.id.btn_FragmentB);
    }

}
