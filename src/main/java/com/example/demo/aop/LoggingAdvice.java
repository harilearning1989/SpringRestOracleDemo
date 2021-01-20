package com.example.demo.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Aspect
//@Configuration
public class LoggingAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAdvice.class);

    //@Pointcut(value = "execution(* com.example.demo.controls.QueryMethodsRestController.getAllCropInsurance(..))")
    @Pointcut(value = "execution(* com.example.demo.*.*.*(..) )")
    public void myPointCut() {

    }

    @Around("myPointCut()")
    public Object applicationLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ObjectMapper objectMapper = new ObjectMapper();
        String methodName = proceedingJoinPoint.getSignature().getName();
        String className = proceedingJoinPoint.getTarget().getClass().toString();
        Object[] objArray = proceedingJoinPoint.getArgs();

        LOGGER.info("methodName:=" + methodName + "===className:=" + className + "===objArray:=" + objectMapper.writeValueAsString(objArray));
        Object object = proceedingJoinPoint.proceed();
        LOGGER.info("Response:=" + objectMapper.writeValueAsString(object));
        return object;
    }
}