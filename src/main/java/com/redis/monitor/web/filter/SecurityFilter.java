package com.redis.monitor.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author pinke
 * @since 2016-04-29.
 */
public class SecurityFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) servletRequest).getSession();
		if (!isIgNore(((HttpServletRequest) servletRequest).getRequestURI()) && session.getAttribute("login") == null) {
			((HttpServletResponse) servletResponse).sendRedirect("login.htm");
		} else {
			filterChain.doFilter(servletRequest, servletResponse);
		}
	}

	private List<String> ignores = Arrays.asList(
			"/login.htm",
			"/logout.htm"
	);

	private boolean isIgNore(String requestURI) {
		return ignores.contains(requestURI);
	}

	public void destroy() {

	}
}
