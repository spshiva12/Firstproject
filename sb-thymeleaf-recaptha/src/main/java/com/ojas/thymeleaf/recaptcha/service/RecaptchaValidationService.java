package com.ojas.thymeleaf.recaptcha.service;

import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.ojas.thymeleaf.recaptcha.response.RecapthaResponseType;

@Service
public class RecaptchaValidationService {

	private static final String GOOGLE_RECAPTCHA_ENDPOINT = "https://www.google.com/recaptcha/api/siteverify";

	private final String RECAPTCHA_SECRET = "6LfxEYMlAAAAAKEuAx-q6XyRsj5fbPLfgfTMyOGG";

	public boolean validateCaptcha(String captchaResponse) {
		RestTemplate restTemplate = new RestTemplate();

		MultiValueMap<String, String> requestMap = new LinkedMultiValueMap<>();
		requestMap.add("secret", RECAPTCHA_SECRET);
		requestMap.add("response", captchaResponse);

		RecapthaResponseType apiResponse = restTemplate.postForObject(GOOGLE_RECAPTCHA_ENDPOINT, requestMap,
				RecapthaResponseType.class);
		if (apiResponse == null) {
			return false;
		}

		return Boolean.TRUE.equals(apiResponse.isSuccess());
	}

}
