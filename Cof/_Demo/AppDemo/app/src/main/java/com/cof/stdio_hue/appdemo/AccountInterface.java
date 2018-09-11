package com.cof.stdio_hue.appdemo;

import com.cof.stdio_hue.appdemo.model.Account;

public interface AccountInterface {
    void SendString(String data);
    void SendObject(Account account);
}