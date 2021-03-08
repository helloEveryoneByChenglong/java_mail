package com.mail.java.demo.utils;

import com.mail.java.demo.bean.Auth;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * 邮件相关操作类
 */
public class MailUtil {

    /**
     * 发送邮件
     *
     * @param user     发件人邮箱
     * @param password 授权码（注意不是邮箱登录密码）
     * @param host     服务器
     * @param port     端口
     * @param from     发件人
     * @param to       接收者
     * @param cc       抄送
     * @param subject  邮件主题
     * @param content  邮件内容
     * @return success 发送成功 failure 发送失败
     * @throws Exception
     */
    public static String sendMail(String user, String password, String host, String port,
                                  String from, List<String> to, List<String> cc, String subject, String content)
            throws Exception {
        if (to.isEmpty()) {
            return "收件人不能为空";
        }

        InternetAddress[] toAddress = new InternetAddress[to.size()];
        for (int i = 0; i < to.size(); i++) {
            toAddress[i] = new InternetAddress(to.get(i));
        }
        InternetAddress[] ccAddress = new InternetAddress[cc.size()];
        for (int i = 0; i < cc.size(); i++) {
            ccAddress[i] = new InternetAddress(cc.get(i));
        }

        Properties props = System.getProperties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.ssl.enable", "true");//开启ssl，根据使用的服务器判断是否开启
        props.setProperty("mail.transport.protocol", "smtp");

        Auth auth = new Auth(user, password);
        Session session = Session.getInstance(props, auth);
        session.setDebug(true);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipients(Message.RecipientType.TO, toAddress);
            message.addRecipients(Message.RecipientType.CC, ccAddress);
            message.setSubject(subject);
            message.setContent(content, "text/html;charset=utf-8");
            message.setSentDate(new Date(1614667200));//发送时间
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
            return "发送异常" + e;
        }
        return "发送成功";
    }
}