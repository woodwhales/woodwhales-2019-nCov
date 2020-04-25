package org.woodwhales.ncov.exception;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.woodwhales.ncov.utils.IpUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public String exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception exception){
    	String requestIpAddr = IpUtil.getIpAddr(request);
        log.error("request IP = {}, URL = {} happened exception, message = {}", requestIpAddr, request.getRequestURL(), exception.getMessage());
        if(StringUtils.isNotBlank(request.getQueryString())) {
        	try {
				log.error("queryString = {} from request IP = {}, URL = {}", requestIpAddr, URLDecoder.decode(request.getQueryString(),"UTF-8"), request.getRequestURL());
			} catch (UnsupportedEncodingException e) {
				log.error("get queryString happen exception form ip = {}, ", requestIpAddr);
			}
        }
        
        return "404";
    }
}