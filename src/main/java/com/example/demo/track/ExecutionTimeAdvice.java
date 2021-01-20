package com.example.demo.track;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
@ConditionalOnExpression("${aspect.enabled:true}")
public class ExecutionTimeAdvice {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExecutionTimeAdvice.class);

    @Around("@annotation(com.example.demo.track.TrackExecutionTime)")
    public Object executionTime(ProceedingJoinPoint point) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object object = point.proceed();
        long endtime = System.currentTimeMillis();
        LOGGER.info("Class Name: " + point.getSignature().getDeclaringTypeName() + ". Method Name: " + point.getSignature().getName() + ". Time taken for Execution is : " + (endtime - startTime) + "ms");
        Object[] methodArguments = point.getArgs();
        for(Object obj : methodArguments){
            LOGGER.info("Object Values===="+obj);
        }
        return object;
    }
}
