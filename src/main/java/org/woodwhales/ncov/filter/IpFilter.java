package org.woodwhales.ncov.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.woodwhales.ncov.utils.IpUtil;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@WebFilter(urlPatterns = {"/**"})
public class IpFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {		
		log.info("request from IP = {}, URL = {}", IpUtil.getIpAddr((HttpServletRequest)request), ((HttpServletRequest)request).getRequestURL());
		chain.doFilter(request, response);
	}

}
