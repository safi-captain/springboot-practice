package com.safi.config.aspect;

import com.safi.utils.JsonData;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by xiefeng
 * Time 2018/12/6
 */
@Aspect
@Component
public class SystemLogAspect {
    Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);

    @Pointcut("@annotation(com.safi.utils.annotation.SqlLog)")
    public void sqlLogAspect() {
    }

    @Around("sqlLogAspect()")
    public Object dealWithSqlOperation(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("---------------------- dealWithSqlOperation start.");
        Object object = joinPoint.proceed();
        logger.info("---------------------- dealWithSqlOperation end.");
        return object;
    }

    @Before("sqlLogAspect()")
    public void beforeSqlOperation() {
        logger.info("before sqlOperation");
    }

    @After("sqlLogAspect()")
    public void afterSqlOperation(){
        logger.info("after sqlOperation");
    }
}
