# javaxMail 

## 简介
>使用spring-boot-starter-mail包实现发送邮件功能；

## 接口
>发送邮件

POST localhost:8080/javaxMail/send/mail

>请求参数

{
    "user":"xxx@qq.com",
    "password":"xxx",
    "host":"smtp.qq.com",
    "port":"465",
    "from":"xxx@qq.com",
    "to":["xxx@qq.com"],
    "cc":[],
    "subject":"邮件主题",
    "content":"邮件内容"
}
