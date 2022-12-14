package com.filter;

import java.io.IOException;
import java.util.Enumeration;

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
	public void doFilter(ServletRequest reqx, ServletResponse resx, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = ((HttpServletRequest) (reqx));

		String url = request.getRequestURL().toString();

		System.out.println("incoming url ---> " + url);
		System.out.println("method ---> " + request.getMethod());
//		Enumeration<String> allHeaders = request.getHeaderNames();
//		System.out.println("***************");
//		while (allHeaders.hasMoreElements()) {
//			String hName = allHeaders.nextElement();
//			System.out.println(hName+" => "+request.getHeader(hName));
//		}
//		System.out.println("***************");
// || url.contains("/admin/")
		if (url.contains("/public/") || request.getMethod().toLowerCase().equals("options")) {
			System.out.println("options by pass....");
			chain.doFilter(reqx, resx);// goahed
		} else {
			// token - authentication

//			while (allHeaders.hasMoreElements()) {
//				String hName = allHeaders.nextElement();
//				System.out.println(hName+" => "+request.getHeader(hName));
//			}
//			System.out.println("***************");

			String authToken = request.getHeader("authToken");
			System.out.println("authToken => " + authToken);
			if (authToken == null || authToken.trim().length() != 16) {

				System.out.println("token verification failed.......");
				HttpServletResponse response = ((HttpServletResponse) resx);
				response.setContentType("application/json");
				response.setStatus(401);
				response.getWriter().write("{'msg':'Please Login before access service'}");
			} else {
				// token -> db user ?
				System.out.println("user verfied....");
				chain.doFilter(reqx, resx);// go ahead -> { Filter , Controller }
			}

		}

	}
}
