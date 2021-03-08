package com.mail.java.demo.bean;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 身份认证
 */
public class Auth extends Authenticator {

    private String username = "";
    private String password = "";

    public Auth(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
    }
}
