package com.demo.authserver.interceptor;

import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.util.StringUtils;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;

public class CustomSavedRequestAwareAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{

	protected final Log logger = LogFactory.getLog(this.getClass());

	private RequestCache requestCache = new HttpSessionRequestCache();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws ServletException, IOException {
		SavedRequest savedRequest = requestCache.getRequest(request, response);

		if (savedRequest == null) {
			super.onAuthenticationSuccess(request, response, authentication);

			return;
		}
		String targetUrlParameter = getTargetUrlParameter();
		if (isAlwaysUseDefaultTargetUrl()
				|| (targetUrlParameter != null && StringUtils.hasText(request
						.getParameter(targetUrlParameter)))) {
			requestCache.removeRequest(request, response);
			super.onAuthenticationSuccess(request, response, authentication);

			return;
		}

		clearAuthenticationAttributes(request);

		// Use the DefaultSavedRequest URL
		String targetUrl = savedRequest.getRedirectUrl();
		
		//http://localhost:8080/oauth/authorize?client_id=trusted-app&redirect_uri=http://localhost:9999/ui/login&response_type=code&state=GkV6uW
		StringBuilder test = new StringBuilder();
		
		int redirectUriStartIndex = targetUrl.indexOf("redirect_uri");
		test.append(targetUrl.substring(0, redirectUriStartIndex));
		
		test.append("redirect_uri=http://localhost:9999/ui/auth/confirmAccess&");
		
		int redirectUriEndIndex = targetUrl.indexOf("response_type", redirectUriStartIndex);
		test.append(targetUrl.substring(redirectUriEndIndex));
		
//		test.toString();
		
		logger.debug("Redirecting to DefaultSavedRequest Url: " + targetUrl);
		getRedirectStrategy().sendRedirect(request, response, targetUrl);
//		getRedirectStrategy().sendRedirect(request, response, test.toString());

	}

	public void setRequestCache(RequestCache requestCache) {
		this.requestCache = requestCache;
	}
}
