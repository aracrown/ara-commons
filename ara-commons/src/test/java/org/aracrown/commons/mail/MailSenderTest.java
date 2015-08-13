package org.aracrown.commons.mail;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;

import org.junit.Assert;
import org.junit.Test;

public class MailSenderTest {
	@Test(expected = NullPointerException.class)
	public void testDefault() throws MessagingException {
		javax.mail.Session mailSession = Session.getDefaultInstance(new Properties());

		MailSender ms = new MailSender(mailSession);
		ms.send();
	}

	@Test(expected=NullPointerException.class)
	public void testEmailTo() throws MessagingException {
		javax.mail.Session mailSession = Session.getDefaultInstance(new Properties());
		
		MailSender ms = new MailSender(mailSession);
		ms.mailTo("test@test.com");
		ms.send();
	}

	@Test
	public void testSend() throws MessagingException {
		javax.mail.Session mailSession = Session.getDefaultInstance(new Properties());

		MailSender ms = new MailSender(mailSession) {
			void sendInternal(javax.mail.internet.MimeMessage m) throws MessagingException {
				Assert.assertEquals("subject", m.getSubject());
				Assert.assertEquals("test2@test.com", m.getFrom()[0].toString());
				Assert.assertEquals("test@test.com", m.getRecipients(Message.RecipientType.TO)[0].toString());
				try {
					Assert.assertEquals("content", (String)m.getContent());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};
		};
		ms.mailTo("test@test.com");
		ms.from("test2@test.com");
		ms.subject("subject");
		ms.content("content");
		ms.send();
	}
}
