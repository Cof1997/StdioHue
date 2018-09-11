package com.cof.stdio_hue.demo_login;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

//    public static final String KEY_USER_TO_MAIN = "KEY_USER_TO_MAIN";
//    public static final String KEY_PASSWORD_TO_MAIN = "KEY_PASSWORD_TO_MAIN";
    public static final String KEY_TO_MAIN = "KEY_TO_MAIN";

//    public static final String KEY_USER_FROM_REGISTER = "KEY_USER_FROM_REGISTER";
//    public static final String KEY_PASS_FROM_REGISTER = "KEY_PASS_FROM_REGISTER";
    public static final String KEY_FROM_REGISTER = "KEY_FROM_REGISTER";

    public static final int REQUEST_CODE_REGISTER = 1;

    ArrayList<Account> listAccount = new ArrayList<Account>();
    TextView tvRegister;
    EditText etUserName, etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        connectView();
    }

    private void connectView(){
        etUserName = (EditText) findViewById(R.id.et_UserNameLogin);
        etPassword = (EditText) findViewById(R.id.et_PasswordLogin);
        btnLogin = (Button) findViewById(R.id.btn_Login);
        tvRegister = (TextView) findViewById(R.id.tv_Register);
    }

    public void LOGIN(View view) {
        listAccount.add(new Account("admin", "123"));
        boolean errIsEmpty = false;
        boolean errLogin = false;
        String userName = etUserName.getText().toString();
        String password = etPassword.getText().toString();

        if(userName.isEmpty() || password.isEmpty()){
            errIsEmpty = true;
        }
        for(Account account : listAccount){
            String user = account.getUserName();
            String pass = account.getPassWord();
            if(userName.equals(user) && password.equals(pass)) {
                errLogin = true;
            }
        }
        if(errIsEmpty){
            Toast.makeText(LoginActivity.this, "Vui lòng điền đầy đủ thông tin.", Toast.LENGTH_SHORT).show();
        }else{
            if(errLogin){
                Account account = new Account(userName, password);
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                Send data Acticity_Main
//                intent.putExtra(KEY_USER_TO_MAIN, userName);
//                intent.putExtra(KEY_PASSWORD_TO_MAIN, password);
                intent.putExtra(KEY_TO_MAIN, account);
                startActivity(intent);
                Notification_Login("ĐĂNG NHẬP THÀNH CÔNG", "Xin Chào " + userName);
            }else{
                Toast.makeText(LoginActivity.this, "Sai thông tin đăng nhập.\nVui lòng thử lại.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void REGISTER(View view) {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivityForResult(intent, REQUEST_CODE_REGISTER);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == REQUEST_CODE_REGISTER && resultCode == RegisterActivity.RESULT_OK) {
            Account account = intent.getParcelableExtra(KEY_FROM_REGISTER);
            listAccount.add(account);
            etUserName.setText(account.userName);
            etPassword.setText(account.passWord);
        }
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
//        Toast.makeText(LoginActivity.this, "Accept", Toast.LENGTH_SHORT).show();
//        super.onActivityResult(requestCode, resultCode, intent);
//        if (requestCode == REQUEST_CODE_REGISTER && resultCode == RegisterActivity.RESULT_OK) {
//            String userName = intent.getStringExtra(KEY_USER_FROM_REGISTER);
//            String passWord = intent.getStringExtra(KEY_PASS_FROM_REGISTER);
//            Account account = new Account(userName, passWord);
//            listAccount.add(account);
//            etUserName.setText(userName);
//            etPassword.setText(passWord);
//        }
//    }

    public void Notification_Login(String title, String text){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
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
