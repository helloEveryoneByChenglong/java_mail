package com.mail.java.demo.bean;

import lombok.Data;

import java.util.List;

/**
 * 发送邮件请求参数
 */
@Data
public class SendMailReqBo {
    private String user;
    private String password;
    private String host;
    private String port;
    private String from;
    private List<String> to;
    private List<String> cc;
    private String subject;
    private String content;
}
