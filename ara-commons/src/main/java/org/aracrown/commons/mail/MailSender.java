package org.aracrown.commons.mail;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {
	private final Session mailSession;

	private String emailTo;

	private String subject;

	private String content;
	
	private String from;

	public MailSender(Session mailSession) {
		this.mailSession = mailSession;
	}

	public MailSender mailTo(String emailTo) {
		this.emailTo = emailTo;
		return this;
	}

	public MailSender subject(String subject) {
		this.subject = subject;
		return this;
	}

	public MailSender content(String outputContent) {
		this.content = outputContent;
		return this;
	}
	
	public MailSender from(String from) {
		this.from = from;
		return this;
	}

	public void send() throws MessagingException {
		MimeMessage m = new MimeMessage(mailSession);
		Address[] to = new InternetAddress[] { new InternetAddress(emailTo) };

		m.setFrom(from);
		m.setRecipients(Message.RecipientType.TO, to);
		m.setSubject(subject);
		m.setSentDate(new java.util.Date());

		m.setContent(content, "text/html; charset=UTF-8");
		Transport.send(m);
	}

}
