package com.cflox.numberConverter.aspect;

import com.cflox.numberConverter.NumberConverterApplication;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Logging aspect declaration class
 *
 * @author tatmaca
 */
@Log4j2
@Aspect
@Component
public class LoggerAspect {


    /**
     * This method is an empty application pointcut declaration method
     */
    @Pointcut("within(com.cflox.numberConverter..*)")
    public void applicationPointcut() {
        // Method is empty as this is just a Pointcut, the implementations are in the advices.
    }

    /**
     * Exception logger method
     *
     * @param joinPoint : JoinPoint parameter
     * @param e : Exception parameter
     */
    @AfterThrowing(pointcut = "applicationPointcut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        log.error("Exception in {}.{}() with cause = {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), e.getCause() != null ? e.getStackTrace() : "NULL");
    }

    /**
     * This method declares the around advice that is executed before and after
     * the method(s) matching with appilcationPointcut()
     *
     * @param joinPoint : ProceedingJoinProint parameter
     * @return : Defined return type, Object
     * @throws Throwable : Throws IllegalArgumentException
     */
    @Around("applicationPointcut()")
    public Object logMethodAccessAfter(ProceedingJoinPoint joinPoint) throws Throwable {
        if (log.isInfoEnabled()) {
            log.info("Execution started for {}.{}() with following argument(s) => {}",
                    joinPoint.getSignature().getDeclaringTypeName(),
                    joinPoint.getSignature().getName(),
                    Arrays.asList(joinPoint.getArgs()));
        }

        try {
            Object result = joinPoint.proceed();
            if (log.isInfoEnabled()) {
                log.info("Execution completed for {}.{}() with result => {}",
                        joinPoint.getSignature().getDeclaringTypeName(),
                        joinPoint.getSignature().getName(),
                        result);
            }
            return result;
        } catch (IllegalArgumentException e) {
            log.error("Illegal argument: {} in {}.{}()",
                    Arrays.toString(joinPoint.getArgs()),
                    joinPoint.getSignature().getDeclaringTypeName(),
                    joinPoint.getSignature().getName());
            throw e;
        }
    }
}
