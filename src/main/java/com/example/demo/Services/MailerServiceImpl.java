package com.example.demo.Services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.MailInfo;
import com.example.demo.Services.MailerService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailerServiceImpl implements MailerService {

	 private static final Logger logger = LoggerFactory.getLogger(MailerServiceImpl.class);
	 
    @Autowired
    JavaMailSender sender;
    List<com.example.demo.Repositories.MailInfo> list = new ArrayList<>();

    @Override
    public void send(com.example.demo.Repositories.MailInfo mail) {
        try {
            MimeMessage message = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom(mail.getFrom());
            helper.setTo(mail.getTo());
            helper.setSubject(mail.getSubject());
            helper.setText(mail.getBody(), true); // Gửi email dạng HTML
            helper.setReplyTo(mail.getFrom());

            sender.send(message);
            logger.info("Email sent successfully to: {}", mail.getTo());
        } catch (MessagingException e) {
            logger.error("Error sending email to {}: {}", mail.getTo(), e.getMessage());
            // Xử lý lỗi khác (ví dụ: thông báo cho người dùng hoặc quản trị viên)
            // Ví dụ: throw new MailServiceException("Failed to send email", e);
        }
    }

    @Override
	public void send(String to, String subject, String body) throws MessagingException {
		// TODO Auto-generated method stub
		this.send(new MailInfo(to, subject, body));
	}

	@Override
	public void queue(MailInfo mail) {
		// TODO Auto-generated method stub
		list.add(mail);
	}

	@Override
	public void queue(String to, String subject, String body) {
		// TODO Auto-generated method stub
		queue(new MailInfo(to, subject, body));
	}

	 @Scheduled(fixedDelay = 5000)
	    public void run() {
	        while (!list.isEmpty()) {
	            MailInfo mail = list.remove(0);
	            try {
	                this.send(mail);
	            } catch (Exception e) {
	                logger.error("Error sending queued email: {}", e.getMessage());
	            }
	        }
	    }
}
