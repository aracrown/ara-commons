package org.aracrown.commons.captcha;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class RecaptchaValidatorTest {
	@Test
	public void testDefault() throws Exception {

		HttpServletRequest mocked = Mockito.mock(HttpServletRequest.class);

		RecaptchaValidator v = new RecaptchaValidator();
		Assert.assertFalse(v.isValid(mocked, "test"));
	}

	@Test
	public void testSuccess() throws Exception {

		HttpServletRequest mocked = Mockito.mock(HttpServletRequest.class);
		HttpClient mockedClient = Mockito.mock(HttpClient.class);
		HttpResponse mockedResponse = Mockito.mock(HttpResponse.class);
		HttpEntity entity = Mockito.mock(HttpEntity.class);

		Mockito.when(mocked.getParameter("g-recaptcha-response")).thenReturn("value");
		Mockito.when(mockedClient.execute(Mockito.any(HttpGet.class))).thenReturn(mockedResponse);
		Mockito.when(mockedResponse.getEntity()).thenReturn(entity);
		Mockito.when(entity.getContent()).thenReturn(new ByteArrayInputStream("{success:true}".getBytes(StandardCharsets.UTF_8)));

		RecaptchaValidator v = new RecaptchaValidator(mockedClient);
		Assert.assertTrue(v.isValid(mocked, "test"));
	}

	@Test
	public void testCatchIOException() throws Exception {

		HttpServletRequest mocked = Mockito.mock(HttpServletRequest.class);
		HttpClient mockedClient = Mockito.mock(HttpClient.class);

		Mockito.when(mocked.getParameter("g-recaptcha-response")).thenReturn("value");
		Mockito.when(mockedClient.execute(Mockito.any(HttpGet.class))).thenThrow(new IOException());

		RecaptchaValidator v = new RecaptchaValidator(mockedClient);
		Assert.assertFalse(v.isValid(mocked, "test"));
	}
}
