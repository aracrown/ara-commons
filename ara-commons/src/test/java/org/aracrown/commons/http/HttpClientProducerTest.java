package org.aracrown.commons.http;

import java.security.NoSuchAlgorithmException;

import org.apache.http.client.HttpClient;
import org.junit.Assert;
import org.junit.Test;

public class HttpClientProducerTest {

	@Test
	public void testDefault() throws NoSuchAlgorithmException {
		HttpClient c = new HttpClientProducer().newHttpClient();
		Assert.assertNotNull(c);
		
		Assert.assertNotNull(new HttpClientProducer().getEngine());
	}
}
