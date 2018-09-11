package com.cof.stdio_hue.demo_login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText etUserNameRegister, etPasswordRegister, etPasswordConfirmRegister;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        connectView();
        initEvents();
    }

    private void connectView(){
        etUserNameRegister = (EditText) findViewById(R.id.et_UserNameRegister);
        etPasswordRegister = (EditText) findViewById(R.id.et_PasswordRegister);
        etPasswordConfirmRegister = (EditText) findViewById(R.id.et_PasswordConfirmRegister);
        btnRegister = (Button) findViewById(R.id.btn_Register);
    }
    private void initEvents(){
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = etUserNameRegister.getText().toString();
                String pass = etPasswordRegister.getText().toString();
                String passConfirm = etPasswordConfirmRegister.getText().toString();

                if(user.isEmpty() || pass.isEmpty() || passConfirm.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Vui lòng điền đầy đủ thông tin.", Toast.LENGTH_SHORT).show();
                }else{

                    if(pass.equals(passConfirm)){
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        Account account = new Account(user, pass);
//                        intent.putExtra(LoginActivity.KEY_USER_FROM_REGISTER, user);
//                        intent.putExtra(LoginActivity.KEY_PASS_FROM_REGISTER, pass);
                        intent.putExtra((LoginActivity.KEY_FROM_REGISTER), account);
                        setResult(RESULT_OK, intent);
                        finish();
                    }else{
                        Toast.makeText(RegisterActivity.this, "PasswordConfirm Error!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
