package top.tobycold.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class EmailConfig {
    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.qq.com");
        javaMailSender.setPort(465);
        javaMailSender.setUsername("coldlen@qq.com");
        javaMailSender.setPassword("qcrpkykmdlazfgfc");
        javaMailSender.setProtocol("smtps");
        javaMailSender.setDefaultEncoding("UTF-8");

        Properties properties = new Properties();           // 配置项
        properties.put("mail.smtp.connectiontimeout", 5000);
        properties.put("mail.smtp.timeout", 3000);
        properties.put("mail.smtp.writetimeout", "5000");
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.starttls.required", true);

        javaMailSender.setJavaMailProperties(properties);
        return javaMailSender;
    }
}
