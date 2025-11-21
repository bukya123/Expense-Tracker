package com.example.demo.Services;

import com.example.demo.Modules.User;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class EmailNotificationServiceImp implements NotificationService {
//    @Autowired
//    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String fromMail;

    @Override
    public void sendUserRegistrationVerificationEmail(User user) throws MessagingException, UnsupportedEncodingException {
//        String toAddress = user.getEmail();
//        String fromAddress = fromMail;
//        String senderName = "Company";
//        String subject = "Please verify your registration";
//        String content = "Dear " + user.getUsername() + ",<br><br>"
//                + "<p>Thank you for joining us! We are glad to have you on board.</p><br>"
//                + "<p>To complete the sign up process, enter the verification code in your device.</p><br>"
//                + "<p>verification code: <strong>" + user.getVerificationCode() + "</strong></p><br>"
//                + "<p><strong>Please note that the above verification code will be expired within 15 minutes.</strong></p>"
//                + "<br>Thank you,<br>"
//                + "Your company name.";
//
//        MimeMessage message = javaMailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message);
//
//        helper.setFrom(fromAddress, senderName);
//        helper.setTo(toAddress);
//        helper.setSubject(subject);
//
//        helper.setText(content, true);
//
//        javaMailSender.send(message);
    }


    public void sendForgotPasswordVerificationEmail(User user) throws MessagingException, UnsupportedEncodingException {
//        String toAddress = user.getEmail();
//        String fromAddress = fromMail;
//        String senderName = "Company";
//        String subject = "Forgot password - Please verify your Account";
//        String content = "Dear " + user.getUsername() + ",<br><br>"
//                + "<p>To change your password, enter the verification code in your device.</p><br>"
//                + "<p>verification code: <strong>" + user.getVerificationCode() + "</strong></p><br>"
//                + "<p><strong>Please note that the above verification code will be expired within 15 minutes.</strong></p>"
//                + "<br>Thank you,<br>"
//                + "Your company name.";
//
//        MimeMessage message = javaMailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message);
//
//        helper.setFrom(fromAddress, senderName);
//        helper.setTo(toAddress);
//        helper.setSubject(subject);
//
//        helper.setText(content, true);
//
//        javaMailSender.send(message);
    }
}
