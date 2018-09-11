package com.cof.stdio_hue.appdemo.ui.fragment;

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

import com.cof.stdio_hue.appdemo.R;
import com.cof.stdio_hue.appdemo.model.Account;
import com.cof.stdio_hue.appdemo.AccountInterface;

import java.util.ArrayList;

public class FragmentLogin extends Fragment {
    private EditText etUserName;
    private EditText etPassword;
    private Button btnLogin;
    private AccountInterface accountInterface;
    private String user;
    private String pass;

    ArrayList<Account> listAccount = new ArrayList<Account>();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listAccount.add(new Account("admin", "123"));
            accountInterface = (AccountInterface) context;
        } catch (ClassCastException e) {
            throw new ClassCastException("Error Account Interface");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        etUserName = (EditText) view.findViewById(R.id.et_UserName);
        etPassword = (EditText) view.findViewById(R.id.et_PassWord);
        btnLogin = (Button) view.findViewById(R.id.btn_Login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = etUserName.getText().toString();
                pass = etPassword.getText().toString();

                for(Account account: listAccount){
                    if(user.equals(account.getUserName()) && pass.equals(account.getPassWord())){
                        accountInterface.SendString("Account Success");
                        accountInterface.SendObject(new Account(user, pass));
                    }
                    else{
                        accountInterface.SendString("Account Error");
                    }
                }
            }
        });
        return view;
    }

}
