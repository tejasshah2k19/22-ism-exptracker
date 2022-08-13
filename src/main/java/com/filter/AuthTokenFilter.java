package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class AuthTokenFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = ((HttpServletRequest) (request));

		String url = req.getRequestURL().toString();

		System.out.println("incoming url ---> " + url);

		if (url.contains("/public/")) {
			chain.doFilter(request, response);// goahed
		} else {
			// token - authentication
			String authToken = req.getHeader("authToken");
			if (authToken == null || authToken.trim().length() != 16) {
				
				
				HttpServletResponse resp = ((HttpServletResponse) response);
				resp.setContentType("application/json");
				resp.setStatus(401);
				resp.getWriter().write("{'msg':'Please Login before access service'}");
			} else {
				//token -> db user ? 
				
				chain.doFilter(request, response);// go ahead
			}

		}

	}
}
