package com.recruit.recruitms.service.impl;

import com.recruit.recruitms.entity.NotificationEmail;
import com.recruit.recruitms.exception.ApiRequestException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Locale;

@Service
@Slf4j
@AllArgsConstructor
public class MailService {

    private final JavaMailSender mailSender;

    private final TemplateEngine templateEngine;

    @Async
    public void sendMail(NotificationEmail notificationEmail){

        try{
            // Prepare the evaluation context
            final Context ctx = new Context();
            ctx.setVariable("name", notificationEmail.getRecipient());
            ctx.setVariable("message", notificationEmail.getBody());

            // Prepare message using a Spring helper
            final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
            final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "UTF-8");
            message.setSubject(notificationEmail.getSubject());
            message.setFrom("recruitms.admin@email.com");
            message.setTo(notificationEmail.getRecipientEmail());

            // Create the HTML body using Thymeleaf
            final String htmlContent = this.templateEngine.process("mailTemplate.html", ctx);
            message.setText(htmlContent, true);

            this.mailSender.send(mimeMessage);
            log.info("Activation email sent!!");
        } catch (MailException e) {
            log.error("Exception occurred when sending mail", e);
            throw new ApiRequestException("Exception occurred when sending mail to " + notificationEmail.getRecipient(), e);
        }
        catch  (MessagingException ex){
            log.error("Exception occurred when generating the mail", ex);
            throw new ApiRequestException("Exception occurred when generating the mail to " + notificationEmail.getRecipient(), ex);
        }
    }
}
