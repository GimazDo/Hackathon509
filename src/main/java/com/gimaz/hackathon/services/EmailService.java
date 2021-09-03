package com.gimaz.hackathon.services;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;

public interface EmailService {
    public void sendSimpleEmail(String toAddress, String subject, String message);
    public void sendEmailWithAttachment(String toAddress, String subject, String message, String attachment) throws MessagingException, FileNotFoundException, MessagingException;
}
