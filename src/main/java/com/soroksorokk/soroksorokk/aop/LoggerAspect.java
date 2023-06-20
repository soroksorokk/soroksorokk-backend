package com.soroksorokk.soroksorokk.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

// TODO: 2023/06/20
// 1. Pointcut 관리 방법
// 2. 무엇을 로그로 보일것인지
// 3. ex) trace, method name, args...
@Configuration
@Aspect
public class LoggerAspect {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    // when
    @Before("excution(* com.soroksorokk.soroksorokk.*(..)")
    public void loggerBeforeRun(JoinPoint joinPoint) {
        logger.info("parameters: {}", joinPoint.getArgs());
    }
}
