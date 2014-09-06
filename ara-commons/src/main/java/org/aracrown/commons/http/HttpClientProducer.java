package org.aracrown.commons.http;

import java.security.NoSuchAlgorithmException;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.jboss.resteasy.client.jaxrs.engines.ApacheHttpClient4Engine;

/**
 * Simple http client provider for various purposes.
 * 
 * @author vicento.ramos
 * 
 * @since 1.0.0
 * 
 */
public final class HttpClientProducer {
	/** Pooling client properties. */
	private static final int TIMEOUT_CON = 20000;

	/** Pooling client properties. */
	private static final int TIMEOUT_SO = 15000;

	/** Pooling client properties. */
	private static final int MAX_TOTAL = 200;

	/** Pooling client properties. */
	private static final int MAX_ROUTE = 200;

	/**
	 * Creates new apache http client using
	 * {@link PoolingClientConnectionManager}.
	 * 
	 * @return new instance of http client
	 * @throws NoSuchAlgorithmException
	 *             SSL context cannot be created
	 */
	@Produces
	@ApplicationScoped
	public HttpClient newHttpClient() throws NoSuchAlgorithmException {
		return getHttpClient();
	}

	/**
	 * Creates new http client for resteasy engine.
	 * 
	 * @return new instance of http client 4 engine
	 * @throws NoSuchAlgorithmException
	 *             SSL context cannot be created
	 */
	public ApacheHttpClient4Engine getEngine() throws NoSuchAlgorithmException {
		HttpClient httpClient = getHttpClient();

		return new ApacheHttpClient4Engine(httpClient);
	}

	private HttpClient getHttpClient() throws NoSuchAlgorithmException {

		// Ignores invalid certificate requests
		Registry<ConnectionSocketFactory> registry = getSchemeRegistry();

		// Default connection manager
		PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(registry);
		cm.setMaxTotal(MAX_TOTAL);
		cm.setDefaultMaxPerRoute(MAX_ROUTE);

		// Default request config
		RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(TIMEOUT_CON).setConnectTimeout(TIMEOUT_CON)
				.setSocketTimeout(TIMEOUT_SO).build();

		HttpClient client = HttpClientBuilder.create().setConnectionManager(cm).setDefaultRequestConfig(requestConfig).build();
		return client;
	}

	private Registry<ConnectionSocketFactory> getSchemeRegistry() throws NoSuchAlgorithmException {
		HostnameVerifier hostnameVerifier = SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;

		SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(SSLContext.getDefault(), (X509HostnameVerifier) hostnameVerifier);
		return RegistryBuilder.<ConnectionSocketFactory> create().register("http", PlainConnectionSocketFactory.getSocketFactory())
				.register("https", socketFactory).build();
	}
}
