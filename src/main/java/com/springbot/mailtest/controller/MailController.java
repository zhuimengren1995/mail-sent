package com.springbot.mailtest.controller;

import com.springbot.mailtest.service.ServiceMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author amc2533064395@163.com
 * @date 2019/6/7 23:35
 */
@RestController
public class MailController {
    @Autowired
    private ServiceMail mailService;

    //接收邮箱地址
    private String to = "amc2533064395@163.com";

    @GetMapping("/to")
    public void sendSimpleMail() {
        mailService.sendSimpleMail(to, "主题：简单邮件", "测试邮件内容");
    }

    @GetMapping("/to33")
    public void sendHtmlMail() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("time", System.currentTimeMillis());
        model.put("message", "huhy   测试邮件");
        String content = "111111111111111111111111111111111";

        mailService.sendHtmlMail(to, "主题：html邮件", content);
    }

    @GetMapping("/to3344")
    public void sendAttachmentsMail() {
        mailService.sendAttachmentsMail(to, "主题：带附件的邮件", "有附件，请查收！", "C:\\Users\\Administrator\\Desktop\\mail.txt");
    }

    @GetMapping("/to334455")
    public void sendInlineResourceMail() {
        String rscId = "huhy";
        mailService.sendInlineResourceMail(to,
                "主题：嵌入静态资源的邮件",
                "<html><body>这是有嵌入静态资源：<img src=\'cid:" + rscId + "\' ></body></html>",
                "D:\\1.jpg",
                rscId);
    }


}

