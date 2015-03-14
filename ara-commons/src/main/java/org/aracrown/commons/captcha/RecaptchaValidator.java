package org.aracrown.commons.captcha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Strings;
import com.google.gson.Gson;

@Named
public class RecaptchaValidator {
	private static final String RESPONSE = "g-recaptcha-response";

	private static final String RECAPTCHA_URL = "https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s&remoteip=user_ip_address";

	private static final Logger LOGGER = LoggerFactory.getLogger(RecaptchaValidator.class);

	@Inject
	private HttpClient httpClient;

	public boolean isValid(HttpServletRequest request, String privateKey) {
		String recaptcha = request.getParameter(RESPONSE);
		String remoteIpAddress = request.getRemoteAddr();
		if (Strings.isNullOrEmpty(recaptcha)) {
			return false;
		}
		return getResponse(recaptcha, remoteIpAddress, privateKey);
	}

	@SuppressWarnings("unchecked")
	private Boolean getResponse(String recaptcha, String remoteIpAddress, String privateKey) {
		try {
			String url = String.format(RECAPTCHA_URL, privateKey, recaptcha, remoteIpAddress);
			HttpGet request = new HttpGet(url);
			HttpResponse response = httpClient.execute(request);

			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			StringBuilder result = new StringBuilder();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			Map<String, Object> props = new Gson().fromJson(result.toString(), Map.class);
			return (Boolean) props.get("success");
		} catch (IOException e) {
			LOGGER.error("Error while contacting google site for client ip: {}", remoteIpAddress, e);
		}
		return Boolean.FALSE;
	}

}
