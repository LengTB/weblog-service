package top.tobycold.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.io.UnsupportedEncodingException;
import java.util.Random;

@SpringBootTest
public class EmailTest {
    @Autowired
    JavaMailSender javaMailSender;

    @Test
    public void sendTest() throws MessagingException, UnsupportedEncodingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false);

        mimeMessageHelper.setFrom("coldlen@qq.com", "Cold的窝");
        mimeMessageHelper.setTo("tobycold@qq.com");
        Random random = new Random();
        int i = random.nextInt(100000, 1000000);

        mimeMessageHelper.setSubject("邮件测试");
        mimeMessageHelper.setText("<h2>验证码为：" + i + "</h2>", true);
        javaMailSender.send(mimeMessage);

    }
}
