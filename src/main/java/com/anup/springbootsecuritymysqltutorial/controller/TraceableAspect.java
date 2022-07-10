package com.anup.springbootsecuritymysqltutorial.controller;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.engine.transaction.jta.platform.internal.OC4JJtaPlatform;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class TraceableAspect {

    @Around("@annotation(Traceable)")
    public Object trace(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println( "Input is " + proceedingJoinPoint.getArgs()[0]);
        HttpServletRequest  httpServletRequest = (HttpServletRequest) proceedingJoinPoint.getArgs()[1];
        System.out.println( "Request URI is " + httpServletRequest.getRequestURI());
        System.out.println( "Remote Address is " + httpServletRequest.getRemoteAddr());
        Object result = proceedingJoinPoint.proceed();
        return result;
    }
}
