package com.mail.java.demo.controller;

import com.mail.java.demo.bean.SendMailReqBo;
import com.mail.java.demo.utils.MailUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 */
@RestController
public class MailController {

    /**
     * 发送短信
     *
     * @param sendMailReqBo
     */
    @RequestMapping("/send/mail")
    public String sendMail(@RequestBody SendMailReqBo sendMailReqBo) {
        try {
            return MailUtil.sendMail(sendMailReqBo.getUser(), sendMailReqBo.getPassword(), sendMailReqBo.getHost(), sendMailReqBo.getPort(), sendMailReqBo.getFrom(),
                    sendMailReqBo.getTo(), sendMailReqBo.getCc(), sendMailReqBo.getSubject(), sendMailReqBo.getContent());
        } catch (Exception e) {
            e.printStackTrace();
            return "邮件发送异常";
        }
    }
}
