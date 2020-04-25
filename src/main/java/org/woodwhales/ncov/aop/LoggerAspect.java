package org.woodwhales.ncov.aop;

import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.woodwhales.ncov.utils.IpUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Configuration
public class LoggerAspect {
	@Pointcut("execution(* org.woodwhales.ncov.controller..*.*(..))")
    public void executeService() {
    }
	
	@Around("executeService()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        log.info("request from IP = {}, URL = {}", IpUtil.getIpAddr(request), request.getRequestURL());
        if(StringUtils.isNotBlank(request.getQueryString())) {
        	log.info("query = {}", URLDecoder.decode(request.getQueryString(),"UTF-8"));
        }
        
        return pjp.proceed();
    }

}